package com.azazellj.wp.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface WPArgsBuilder {
    String className();

    WPArg[] args() default {};

    WPField[] fields() default {};
}
