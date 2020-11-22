package com.signia.backend.model;

public class Message {
    private String sessionId;

    public Message() {
    }

    public Message(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
