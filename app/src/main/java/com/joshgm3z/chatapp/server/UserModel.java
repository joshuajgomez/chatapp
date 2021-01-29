package com.joshgm3z.chatapp.server;

import com.joshgm3z.chatapp.common.constants.Config;
import com.joshgm3z.chatapp.common.data.User;
import com.joshgm3z.chatapp.server.retrofit.response.CheckUserResponse;
import com.joshgm3z.chatapp.server.retrofit.response.UserAddedResponse;
import com.joshgm3z.chatapp.signup.SignUpContract;
import com.joshgm3z.chatapp.server.retrofit.UserService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserModel implements SignUpContract.Model {

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
    public void checkUsername(String username, OnPhoneNumberCheckedListener listener) {
        mUserService.checkUsername(new User(username)).enqueue(new Callback<CheckUserResponse>() {
            @Override
            public void onResponse(Call<CheckUserResponse> call, Response<CheckUserResponse> response) {
                CheckUserResponse body = response.body();
                if (body != null && body.isUserFound()) {
                    listener.onUserFound(body.getId());
                } else {
                    listener.onUserNotFound();
                }
            }

            @Override
            public void onFailure(Call<CheckUserResponse> call, Throwable t) {
                listener.onUserCheckError(t.getMessage());
            }
        });
    }

    @Override
    public void registerUser(String phoneNumber, String userName, onUserRegisteredListener listener) {
        mUserService.registerUser(userName).enqueue(new Callback<UserAddedResponse>() {
            @Override
            public void onResponse(Call<UserAddedResponse> call, Response<UserAddedResponse> response) {
                listener.onUserRegistered(response.body().getId());
            }

            @Override
            public void onFailure(Call<UserAddedResponse> call, Throwable t) {
                listener.onUserRegisterError(t.getMessage());
            }
        });
    }
}
