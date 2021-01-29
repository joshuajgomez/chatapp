package com.joshgm3z.chatapp.server.retrofit.response;

public class CheckUserResponse {

    private int status;
    private String message;
    private int id;
    private boolean isUserFound;

    public CheckUserResponse(int status, String message, int id, boolean isUserFound) {
        this.status = status;
        this.message = message;
        this.id = id;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserAddedResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", id=" + id +
                ", isUserFound=" + isUserFound +
                '}';
    }
}
