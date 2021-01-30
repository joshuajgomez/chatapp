package com.joshgm3z.chatapp.common.data;

public class HomeItem {

    private String mUsername;
    private String mMessage;
    private int mCounter = 0;
    private String mImageUrl;

    public HomeItem() {
    }

    public HomeItem(String username, String message, int counter, String imageUrl) {
        mUsername = username;
        mMessage = message;
        mCounter = counter;
        mImageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "HomeItem{" +
                "mUsername='" + mUsername + '\'' +
                ", mMessage='" + mMessage + '\'' +
                ", mCounter=" + mCounter +
                ", mImageUrl='" + mImageUrl + '\'' +
                '}';
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public int getCounter() {
        return mCounter;
    }

    public void setCounter(int counter) {
        mCounter = counter;
    }

    public void incrementCounter() {
        mCounter++;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
