package com.joshgm3z.chatapp.common.data;

public class Chat {

    private String mMessage;
    private long mDateTime;
    private User mFromUser;
    private User mToUser;

    public Chat(String message, long dateTime, User fromUser, User toUser) {
        mMessage = message;
        mDateTime = dateTime;
        mFromUser = fromUser;
        mToUser = toUser;
    }

    public User getFromUser() {
        return mFromUser;
    }

    public void setFromUser(User fromUser) {
        mFromUser = fromUser;
    }

    public User getToUser() {
        return mToUser;
    }

    public void setToUser(User toUser) {
        mToUser = toUser;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public long getDateTime() {
        return mDateTime;
    }

    public void setDateTime(long dateTime) {
        mDateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "mMessage='" + mMessage + '\'' +
                ", mDateTime=" + mDateTime +
                ", mFromUser=" + mFromUser +
                ", mToUser=" + mToUser +
                '}';
    }
}
