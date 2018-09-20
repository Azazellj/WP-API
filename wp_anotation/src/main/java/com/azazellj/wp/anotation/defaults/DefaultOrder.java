package com.azazellj.wp.anotation.defaults;

import com.azazellj.wp.internal.Order;

public @interface DefaultOrder {
    Order value() default Order.DESCEND;
}
