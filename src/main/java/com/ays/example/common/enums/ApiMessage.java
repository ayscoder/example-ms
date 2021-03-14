package com.ays.example.common.enums;

public enum ApiMessage {
    LINK_CREATED("eg-001", "Success", "Tracker link generated successfully"),
    LINK_RETRIEVED("eg-002", "Success", "Tracker link retrieved successfully"),
    USER_CREATE("eg-003", "Success", "User created successfully"),
    USER_READ("eg-004", "Success", "User retrieved successfully"),

    ;
    private final String code;
    private final String reason;
    private final String message;

    ApiMessage(String code, String reason, String message) {
        this.code = code;
        this.reason = reason;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public String getMessage() {
        return message;
    }
}
