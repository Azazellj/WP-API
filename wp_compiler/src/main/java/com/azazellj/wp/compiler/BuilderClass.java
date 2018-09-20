package com.azazellj.wp.compiler;

import com.azazellj.wp.anotation.WPArgsBuilder;

import java.util.Objects;

import javax.lang.model.element.Element;

public class BuilderClass {
    private Element annotatedClassElement;
    private String generatedClassName;

    public BuilderClass(Element classElement) {
        this.annotatedClassElement = classElement;

        WPArgsBuilder annotation = Objects.requireNonNull(classElement.getAnnotation(WPArgsBuilder.class));

        this.generatedClassName = Objects.requireNonNull(annotation.className());
    }

    public Element getAnnotatedClassElement() {
        return annotatedClassElement;
    }


    public String getGeneratedClassName() {
        return generatedClassName;
    }
}