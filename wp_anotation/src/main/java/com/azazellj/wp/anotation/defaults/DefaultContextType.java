package com.azazellj.wp.anotation.defaults;

import com.azazellj.wp.internal.ContextType;

public @interface DefaultContextType {
    ContextType value() default ContextType.VIEW;
}
