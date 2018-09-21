package com.azazellj.wp.internal;

public enum PingStatus {
    OPEN("open"),
    CLOSED("closed");

    private String status;

    PingStatus(String status) {
        this.status = status;
    }
}
