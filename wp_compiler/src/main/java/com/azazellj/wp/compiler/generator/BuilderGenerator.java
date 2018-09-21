package com.azazellj.wp.compiler.generator;

import com.azazellj.wp.anotation.WPArg;
import com.azazellj.wp.anotation.WPField;
import com.azazellj.wp.anotation.WPParam;
import com.azazellj.wp.compiler.BuilderClass;
import com.squareup.javapoet.*;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Modifier;
import javax.tools.Diagnostic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BuilderGenerator {

    public static void p(Messager messager, String key, String value) {
        messager.printMessage(Diagnostic.Kind.ERROR, key + " " + value);
    }

    private static MethodSpec getBuilderMethod(ClassName builderClassName, WPParam param) {
        String variableName = Helper.camelsify(param.getParamName());
        String methodName = "set" + variableName.substring(0, 1).toUpperCase() + variableName.substring(1);
        return MethodSpec.methodBuilder(methodName)
                .returns(builderClassName)
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Object.class, variableName)
                .addStatement("map.put($S, $L)", param.getParamName(), variableName)
                .addStatement("return this")
                .build();
    }

    public static boolean generateClass(Filer filer, Messager messager, BuilderClass builderClass) {
        String className = builderClass.getGeneratedClassName();
        ClassName builderClassName = ClassName.get(Helper.GENERATED_PACKAGE, className);

        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL);

        ParameterizedTypeName mapType = ParameterizedTypeName.get(Map.class, String.class, Object.class);
        ParameterizedTypeName hashMapType = ParameterizedTypeName.get(HashMap.class, String.class, Object.class);

        FieldSpec mapFiled = FieldSpec.builder(mapType, "map")
                .addModifiers(Modifier.PRIVATE)
                .initializer("new $T()", hashMapType)
                .build();

        classBuilder.addField(mapFiled);

        MethodSpec instanceMethod = MethodSpec.methodBuilder("getInstance")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(builderClassName)
                .addStatement("return new $T()", builderClassName)
                .build();

        classBuilder.addMethod(instanceMethod);

        /*
         * Generate setters.
         */

        for (WPArg arg : builderClass.getArgs()) {
            classBuilder.addMethod(getBuilderMethod(builderClassName, arg));
        }

        for (WPField field : builderClass.getFields()) {
            classBuilder.addMethod(getBuilderMethod(builderClassName, field));
        }

        MethodSpec getMethod = MethodSpec.methodBuilder("get")
                .addModifiers(Modifier.PUBLIC)
                .returns(mapType)
                .addStatement("return map")
                .build();

        classBuilder.addMethod(getMethod);
        TypeSpec generatedClass = classBuilder.build();
        JavaFile generatedFile = JavaFile.builder(Helper.GENERATED_PACKAGE, generatedClass).build();

        try {
            generatedFile.writeTo(filer);
            return true;
        } catch (IOException ioEx) {
            messager.printMessage(Diagnostic.Kind.ERROR, ioEx.toString());
            return false;
        }
    }
}
