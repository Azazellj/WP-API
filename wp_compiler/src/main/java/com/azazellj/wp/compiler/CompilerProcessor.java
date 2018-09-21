package com.azazellj.wp.compiler;

import com.azazellj.wp.anotation.WPArgsBuilder;
import com.azazellj.wp.compiler.generator.BuilderGenerator;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

@AutoService(Processor.class)
public class CompilerProcessor extends AbstractProcessor {
    Filer filer;
    Messager messager;
    Elements elements;
    Types types;

    private Map<String, BuilderClass> builderClasses = new LinkedHashMap<>();
    public static Map<String, String> registeredFunctions = new HashMap<>();

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);

        filer = env.getFiler();
        messager = env.getMessager();
        elements = env.getElementUtils();
        types = env.getTypeUtils();
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        registerDefaultHelpers();
        registerCustomHelpers(env);

        findAnnotatedClasses(env);
        registerHelpersFromMockAnnotatedClasses();

        generateMockClasses();

        return false;
    }

    private void generateMockClasses() {
        for (BuilderClass builderClass : builderClasses.values()) {
            if (!BuilderGenerator.generateClass(filer, messager, builderClass)) {
                break;
            }
        }

        builderClasses.clear();
    }

    private void findAnnotatedClasses(RoundEnvironment env) {
        Set<? extends Element> elements = env.getElementsAnnotatedWith(WPArgsBuilder.class);

        for (Element annotatedElement : elements) {
            if (!isValidAnnotatedElement(annotatedElement)) continue;

            registerMockAnnotatedClass(annotatedElement);
        }
    }

    private void registerHelpersFromMockAnnotatedClasses() {
        for (String preGeneratedClassName : builderClasses.keySet()) {
            String fullClassName = builderClasses.get(preGeneratedClassName).getAnnotatedClassElement().toString();
//            String postGeneratedFunction = Helper.fullGeneratedHelperPath(preGeneratedClassName);

//            registeredFunctions.put(fullClassName, postGeneratedFunction);
        }
    }

    private void registerMockAnnotatedClass(Element element) {
        BuilderClass annotatedClass = new BuilderClass(element);
        String elementName = elementName(element);

        if (builderClasses.containsKey(elementName)) {
            // TODO: 1/7/18 write overriding and prioritizing
        }

        builderClasses.put(elementName, annotatedClass);
    }

    private boolean isValidAnnotatedElement(Element element) {
        boolean isValid = true;
//        if (element.getKind() != ElementKind.CLASS) {
//            error(element, "Only classes can be annotated with @%s", WPArgsBuilder.class.getSimpleName());
//            isValid = false;
//        }
//        if (element.getModifiers().contains(Modifier.PRIVATE)) {
//            error(element, "Abstract class can`t be annotated with @%s", WPArgsBuilder.class.getSimpleName());
//            isValid = false;
//        }


        // TODO: 9/20/18 add validation
        return isValid;
    }

    private void registerDefaultHelpers() {
        TypeElement typeElement = elements.getTypeElement(WPArgsBuilder.class.getName());

        registerFunctions(typeElement.getEnclosedElements());
    }

    private void registerCustomHelpers(RoundEnvironment env) {
        registerFunctions(env.getElementsAnnotatedWith(WPArgsBuilder.class));
    }

    void registerFunctions(Collection<? extends Element> elements) {
        for (Element element : elements) {
            if (!isMockHelperMethodValid(element)) continue;

            String helperFunctionName = helperFunctionName(element);
            registerFunction(element, helperFunctionName);
        }
    }

    void registerFunction(Element element, String helperFunctionName) {
//        try {
//            MockTypeHelper helper = element.getAnnotation(MockTypeHelper.class);
//            for (Class supportedClass : helper.types()) {
//                // TODO: 1/6/18 write overriding and prioritizing
//                registeredFunctions.put(supportedClass.toString(), helperFunctionName);
//            }
//        } catch (MirroredTypesException typesEx) {
//            for (TypeMirror typeMirror : typesEx.getTypeMirrors()) {
//                // TODO: 1/6/18 write overriding and prioritizing
//                registeredFunctions.put(typeMirror.toString(), helperFunctionName);
//            }
//        }
//
////        messager.printMessage(Diagnostic.Kind.ERROR, helperFunctionName);
//

    }


    private void error(Element e, String msg, Object... args) {
        messager.printMessage(
                Diagnostic.Kind.ERROR,
                String.format(msg, args),
                e);
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new HashSet<>();
        annotations.add(WPArgsBuilder.class.getCanonicalName());
//        annotations.add(MockTypeHelper.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // HELP METHODS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    String elementName(Element element) {
        return checkNotNull(element).getSimpleName().toString();
    }

    boolean isMockHelperMethodValid(Element element) {
        checkNotNull(element);

        boolean isMethod = element.getKind() == ElementKind.METHOD;
        boolean isStatic = element.getModifiers().contains(Modifier.STATIC);
        boolean isPublic = element.getModifiers().contains(Modifier.PUBLIC);
        return isMethod && isPublic && isStatic;
    }

    String helperFunctionName(Element element) {
        checkNotNull(element);
        checkNotNull(element.getEnclosingElement());

        String className = element.getEnclosingElement().asType().toString();
        String functionName = element.toString();
        return String.format("%s.%s", className, functionName);
    }
}
