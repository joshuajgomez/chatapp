package com.joshgm3z.chatapp.server;

import com.joshgm3z.chatapp.common.constants.Config;
import com.joshgm3z.chatapp.common.data.User;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.server.retrofit.response.CheckUserResponse;
import com.joshgm3z.chatapp.server.retrofit.response.UserAddedResponse;
import com.joshgm3z.chatapp.server.retrofit.UserService;


import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserModel implements UserModelCallBacks {

    private UserService mUserService;

    @Inject
    public UserModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.SERVER_URL)
                .build();
        mUserService = retrofit.create(UserService.class);
    }

    @Override
    public void checkUsername(String username, OnUsernameCheckedListener listener) {
        mUserService.checkUsername(new User(username)).enqueue(new Callback<CheckUserResponse>() {
            @Override
            public void onResponse(Call<CheckUserResponse> call, Response<CheckUserResponse> response) {
                CheckUserResponse body = response.body();
                if (body != null && body.isUserFound()) {
                    listener.onUserFound(body.getUsername());
                } else {
                    listener.onUserNotFound(body.getUsername());
                }
            }

            @Override
            public void onFailure(Call<CheckUserResponse> call, Throwable t) {
                listener.onUserCheckError(t.getMessage());
            }
        });
    }

    @Override
    public void registerUser(String userName, onUserRegisteredListener listener) {
        mUserService.registerUser(new User(userName)).enqueue(new Callback<UserAddedResponse>() {
            @Override
            public void onResponse(Call<UserAddedResponse> call, Response<UserAddedResponse> response) {
                UserAddedResponse body = response.body();
                if (body != null) {
                    listener.onUserRegistered(body.getUsername());
                } else {
                    listener.onUserRegisterError("Unable to register user");
                }
            }

            @Override
            public void onFailure(Call<UserAddedResponse> call, Throwable t) {
                listener.onUserRegisterError(t.getMessage());
            }
        });
    }

    public void getUsersList(String currentUser, OnUsersListListener listener) {
        Logger.log("currentUser = [" + currentUser + "]");
        mUserService.getUsersListExcluding(new User(currentUser)).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> userList = response.body();
                if (userList != null) {
                    listener.onUsersReceived(userList);
                } else {
                    listener.onUsersFetchError("Unable to fetch user list");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.onUsersFetchError(t.getMessage());
            }
        });
    }


}
