package com.joshgm3z.chatapp.server.retrofit.response;

public class UserAddedResponse {

    private int status;
    private String message;
    private String username;

    public UserAddedResponse(int status, String message, String username) {
        this.status = status;
        this.message = message;
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "SendMessageResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", username=" + username +
                '}';
    }
}
