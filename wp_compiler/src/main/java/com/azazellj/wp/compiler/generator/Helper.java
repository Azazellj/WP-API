package com.azazellj.wp.compiler.generator;

public class Helper {
    private Helper() {
    }

    public static final String GENERATED_PACKAGE = Helper.class.getPackage().getName();

    public static String generatedMockClassName(String methodName) {
        return methodName + "Builder";
    }

//    public static String fullGeneratedHelperPath(String className) {
//        return GENERATED_PACKAGE + "." + generatedMockClassName(className) + "." + generatedMockGetter() + "()";
//    }

    static String camelsify(String in) {
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = false;
        for (char c : in.toCharArray()) {
            if (c == '_') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    sb.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
