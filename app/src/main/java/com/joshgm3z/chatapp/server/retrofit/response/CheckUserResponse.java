package com.joshgm3z.chatapp.server.retrofit.response;

public class CheckUserResponse {

    private int status;
    private String message;
    private String username;
    private boolean isUserFound;

    public CheckUserResponse(int status, String message, String username, boolean isUserFound) {
        this.status = status;
        this.message = message;
        this.username = username;
        this.isUserFound = isUserFound;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isUserFound() {
        return isUserFound;
    }

    public String getUsername() {
        return username;
    }
}
