package com.azazellj.wp.anotation;

import com.azazellj.wp.internal.ContextType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Context {
    ContextType[] values();

    ContextType defaultType() default ContextType.VIEW;
}
