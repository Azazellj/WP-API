package com.azazellj.wp.compiler.generator;

public class Helper {
    private Helper() {}

    public static final String GENERATED_PACKAGE = Helper.class.getPackage().getName();

    public static String generatedMockClassName(String methodName) {
        return methodName + "Builder";
    }

//    public static String fullGeneratedHelperPath(String className) {
//        return GENERATED_PACKAGE + "." + generatedMockClassName(className) + "." + generatedMockGetter() + "()";
//    }
}
