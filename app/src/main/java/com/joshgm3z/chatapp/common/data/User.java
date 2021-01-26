package com.joshgm3z.chatapp.common.data;

public class User {

    private String mName;

    public User(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "mName='" + mName + '\'' +
                '}';
    }
}
