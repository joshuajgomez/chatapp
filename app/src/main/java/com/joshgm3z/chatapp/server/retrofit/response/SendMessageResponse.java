package com.joshgm3z.chatapp.server.retrofit.response;

public class SendMessageResponse {

    private int status;
    private String message;
    private int id;

    public SendMessageResponse(int status, String message, int id) {
        this.status = status;
        this.message = message;
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SendMessageResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
