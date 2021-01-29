package com.joshgm3z.chatapp.server.retrofit.response;

public class BasicResponse {

    private int status;
    private String message;

    public BasicResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "BasicResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
