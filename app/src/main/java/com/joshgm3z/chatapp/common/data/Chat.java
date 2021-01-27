package com.joshgm3z.chatapp.common.data;

import com.google.gson.annotations.Expose;

public class Chat {

    private String message;
    private long time;
    private String fromUser;
    private String toUser;

    public Chat(String message, long time, String fromUser, String toUser) {
        this.message = message;
        this.time = time;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Chat{" +
                "message='" + message + '\'' +
                ", time=" + time +
                ", fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                '}';
    }
}
