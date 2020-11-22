package com.signia.backend.model;

public class Message {
    private String sessionId;
    private String code;

    public Message() {
    }

    public Message(String sessionId, String code) {
        this.sessionId = sessionId;
        this.code = code;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
