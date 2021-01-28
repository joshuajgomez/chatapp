package com.joshgm3z.chatapp.server;

import com.joshgm3z.chatapp.common.constants.Config;
import com.joshgm3z.chatapp.signup.SignUpContract;
import com.joshgm3z.chatapp.server.retrofit.UserService;

import javax.inject.Inject;

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
    public void checkPhoneNumber(String phoneNumber, OnPhoneNumberCheckedListener listener) {
        mUserService.checkPhoneNumber(phoneNumber);
    }

    @Override
    public void registerUser(String phoneNumber, String userName, onUserRegisteredListener listener) {
        mUserService.registerUser(phoneNumber, userName);
    }
}
