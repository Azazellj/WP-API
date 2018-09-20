package com.azazellj.wp.internal;

public enum Order {
    ASCEND("asc"),
    DESCEND("desc");

    private String status;

    Order(String status) {
        this.status = status;
    }
}
