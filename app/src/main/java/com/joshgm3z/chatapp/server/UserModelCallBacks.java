package com.joshgm3z.chatapp.server;

import com.joshgm3z.chatapp.common.data.User;

import java.util.List;

public interface UserModelCallBacks {


    void checkUsername(String phoneNumber, OnUsernameCheckedListener listener);

    interface OnUsernameCheckedListener {

        void onUserFound(String username);

        void onUserNotFound(String username);

        void onUserCheckError(String message);
    }


    void registerUser(String userName, onUserRegisteredListener listener);

    interface onUserRegisteredListener {

        void onUserRegistered(String username);

        void onUserRegisterError(String message);
    }


    void getUsersList(String currentUser, OnUsersListListener listener);

    public interface OnUsersListListener {

        void onUsersReceived(List<User> userList);

        void onUsersFetchError(String message);
    }
}