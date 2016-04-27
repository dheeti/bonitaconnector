package com.lh.connectors.dto;

import java.util.HashMap;

/**
 * Created by jayramj on 16/3/16.
 */
public class UnifyNotificationDTO {
    String content ;
    String createdBy;
    HashMap <String,String> participants;
    String shareable;
    HashMap <String,Object> messages;

    public String getDefaultParticipant() {
        return defaultParticipant;
    }

    public void setDefaultParticipant(String defaultParticipant) {
        this.defaultParticipant = defaultParticipant;
    }

    String defaultParticipant;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public HashMap<String, String> getParticipants() {

        return participants;
    }

    public void setParticipants(HashMap<String, String> participants) {
        this.participants = participants;
    }

    public String getShareable() {
        return shareable;
    }

    public void setShareable(String shareable) {
        this.shareable = shareable;
    }

    public HashMap<String, Object> getMessages() {
        return messages;
    }

    public void setMessages(HashMap<String, Object> messages) {
        this.messages = messages;
    }

    public UnifyNotificationDTO() {
    }
}
