package com.azazellj.wp.internal;

public enum CommentStatus {
    OPEN("open"),
    CLOSED("closed");

    private String status;

    CommentStatus(String status) {
        this.status = status;
    }
}
