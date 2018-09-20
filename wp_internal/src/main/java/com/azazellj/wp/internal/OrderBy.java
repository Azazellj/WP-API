package com.azazellj.wp.internal;

public enum OrderBy {
    AUTHOR("author"),
    DATE("date"),
    ID("id"),
    INCLUDE("include"),
    MODIFIED("modified"),
    PARENT("parent"),
    RELEVANCE("relevance"),
    SLUG("slug"),
    TITLE("title");

    private String status;

    OrderBy(String status) {
        this.status = status;
    }
}
