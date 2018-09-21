package com.azazellj.wp.compiler;

import com.azazellj.wp.anotation.WPArg;
import com.azazellj.wp.anotation.WPArgsBuilder;
import com.azazellj.wp.anotation.WPField;

import javax.lang.model.element.Element;

import java.util.Objects;

public class BuilderClass {
    private Element annotatedClassElement;
    private String generatedClassName;
    private WPArg[] args;
    private WPField[] fields;

    public BuilderClass(Element classElement) {
        this.annotatedClassElement = classElement;

        WPArgsBuilder annotation = Objects.requireNonNull(classElement.getAnnotation(WPArgsBuilder.class));

        this.generatedClassName = Objects.requireNonNull(annotation.className());
        this.args = annotation.args();
        this.fields = annotation.fields();
    }

    public Element getAnnotatedClassElement() {
        return annotatedClassElement;
    }

    public String getGeneratedClassName() {
        return generatedClassName;
    }

    public WPArg[] getArgs() {
        return args;
    }

    public WPField[] getFields() {
        return fields;
    }
}