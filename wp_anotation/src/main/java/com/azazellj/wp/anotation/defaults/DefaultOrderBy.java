package com.azazellj.wp.anotation.defaults;

import com.azazellj.wp.internal.OrderBy;

public @interface DefaultOrderBy {
    OrderBy value() default OrderBy.DATE;
}
