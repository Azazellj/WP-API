package com.azazellj.wp.compiler.generator;

import com.azazellj.wp.compiler.BuilderClass;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

public class BuilderGenerator {

    public static void p(Messager messager, String key, String value) {
        messager.printMessage(Diagnostic.Kind.ERROR, key + " " + value);
    }

    public static void generateClass(Elements elements, Types types, Filer filer,
                                     Messager messager, BuilderClass builderClass) throws IOException {
        Element typeElement = builderClass.getAnnotatedClassElement();

        String className = builderClass.getGeneratedClassName();


//        TypeMirror mapType = elements.getTypeElement("java.util.Map<String, Object>").asType();
//        TypeMirror hashMapType = elements.getTypeElement("java.util.HashMap<String, Object>").asType();


        ParameterizedTypeName mapType = ParameterizedTypeName.get(Map.class, String.class, Object.class);
        ParameterizedTypeName hashMapType = ParameterizedTypeName.get(HashMap.class, String.class, Object.class);


        FieldSpec mapFiled = FieldSpec.builder(mapType, "map")
                .addModifiers(Modifier.PRIVATE)
                .initializer("$T", hashMapType)
                .build();


//        MethodSpec.Builder builder = MethodSpec.methodBuilder(Helper.generatedMockGetter())
//                .returns(classType)
//                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                .addCode(CodeBlock.builder().build())
//                .addStatement("$T $L = new $T()", classType, Helper.OBJECT_NAME, classType);
//
//        for (Element e : typeElement.getEnclosedElements()) {
//            if (!e.getKind().isField()) continue;
//
//
//            TypeMirror eC = types.erasure(e.asType());
//
//            Element erasureElem = types.asElement(eC);
//
//
//            if (erasureElem != null) {
//                TypeElement lte = elements.getTypeElement(Collection.class.getName());
//
////                p(messager, "erasureElem", erasureElem.toString());
//
//                TypeMirror eCl = types.erasure(lte.asType());
//
//
//                p(messager, "e.asType() ", e.asType().toString());
//                p(messager, "erasureElem.asType() ", erasureElem.asType().toString());
//                p(messager, "lte.asType() ", lte.asType().toString());
//
//                p(messager, "is assignable e1 = ", String.valueOf(types.isAssignable(eC, eCl)));
//                p(messager, "declared instance = ", String.valueOf(e.asType() instanceof DeclaredType));
//
//                DeclaredType dt = (DeclaredType) e.asType();
//
//                p(messager, "type params = ", String.valueOf(dt.getTypeArguments()));
//
//
////                p(messager, "dt = ", String.valueOf(collectionType.toString()));
//
//
////                p(messager, "sub type = ", String.valueOf(types.isSubtype(erasureElem.asType(),lte.asType())));
////                p(messager, "same type = ", String.valueOf(types.isSameType(erasureElem.asType(),lte.asType())));
////                p(messager, "is assignable = ", String.valueOf(types.isAssignable(erasureElem.asType(),lte.asType
//// ())));
////                p(messager, "is assignable e = ", String.valueOf(types.isAssignable(e.asType(),lte.asType()
////                )));
////
////                p(messager, "hides = ",  String.valueOf(elements.hides(erasureElem, lte)));
////
////
////
////                p(messager, "lte", lte.toString());
////                p(messager, "lte.getSuperclass", lte.getNestingKind().toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////                p(messager, "lte", lte.toString());
////
////p(messager, "is sub type " + erasureElem.toString() + " of " +lte.toString()+ " = ", String.valueOf( types
////        .isSubtype
////        (lte
////        .asType(), eC)
////) );
//
//
////                messager.printMessage(Diagnostic.Kind.ERROR, String.valueOf(types.isAssignable(erasureElem.asType(),
////                        elements.getTypeElement(List.class.getName()).asType())));
////                messager.printMessage(Diagnostic.Kind.ERROR, String.valueOf(types.isSubtype(erasureElem.asType(),
////                        elements.getTypeElement(List.class.getName()).asType())));
//
//            }
//
////            messager.printMessage(Diagnostic.Kind.ERROR,   e.asType().toString());
//
//
//            String nullOrFunction = nullOfHelperFunction(e);
//            if (nullOrFunction == null) {
//                String comment = String.format("For field \"%s\" value is set to null.", e.getSimpleName());
//                builder.addComment(comment);
//                messager.printMessage(Diagnostic.Kind.WARNING, comment);
//            }
//
//            builder.addStatement("$L.$L = $L", Helper.OBJECT_NAME, e.getSimpleName(), nullOrFunction);
//        }
//
//        builder.addStatement("return $L", Helper.OBJECT_NAME);
//
//
////        Method annotationMethod = MockTypeHelper.class.getMethods()[0];
////        String annotationMethodName = annotationMethod.getName();
//
//        CodeBlock codeBlock = CodeBlock.builder().add("{$L.class}", className).build();
//        AnnotationSpec specs = AnnotationSpec.builder(MockTypeHelper.class).addMember("types", codeBlock).build();
//        MethodSpec methodGetMock = builder.addAnnotation(specs).build();
//


        TypeSpec generatedClass = TypeSpec.classBuilder(Helper.generatedMockClassName(className))
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addField(mapFiled)
//                .addMethod(methodGetMock)
                .build();

        JavaFile generatedFile = JavaFile.builder(Helper.GENERATED_PACKAGE, generatedClass).build();

        try {
            generatedFile.writeTo(filer);
        } catch (IOException ioEx) {
            messager.printMessage(Diagnostic.Kind.ERROR, ioEx.toString());
        }
    }

//    private static String nullOfHelperFunction(Element field) {
//        return MockCompilerProcessor.registeredFunctions.get(field.asType().toString());
//    }
}
