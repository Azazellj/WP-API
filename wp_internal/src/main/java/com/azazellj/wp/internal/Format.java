package com.azazellj.wp.internal;

public enum Format {
    STANDART("standard"),
    ASIDE("aside"),
    CHAT("chat"),
    GALLERY("gallery"),
    LINK("link"),
    IMAGE("image"),
    QUOTE("quote"),
    STATUS("status"),
    VIDEO("video"),
    AUDIO("audio");

    private String format;

    Format(String format) {
        this.format = format;
    }
}
