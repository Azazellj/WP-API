package com.azazellj.wp.internal;

public enum PostStatus {
    PUBLISH("publish"),
    FUTURE("future"),
    DRAFT("draft"),
    PENDING("pending"),
    PRIVATE("private");

    private String status;

    PostStatus(String status) {
        this.status = status;
    }
}
