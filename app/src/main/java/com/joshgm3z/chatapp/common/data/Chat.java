package com.joshgm3z.chatapp.common.data;

public class Chat {

    private String mMessage;
    private long mTime;
    private User mFromUser;
    private User mToUser;

    public Chat(String message, long time, User fromUser, User toUser) {
        mMessage = message;
        mTime = time;
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


    @Override
    public String toString() {
        return "Chat{" +
                "mMessage='" + mMessage + '\'' +
                ", mTime=" + mTime +
                ", mFromUser=" + mFromUser +
                ", mToUser=" + mToUser +
                '}';
    }
}
