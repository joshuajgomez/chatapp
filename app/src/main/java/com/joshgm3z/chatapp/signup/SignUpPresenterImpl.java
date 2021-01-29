package com.joshgm3z.chatapp.signup;

import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.server.UserModel;

import javax.inject.Inject;

public class SignUpPresenterImpl implements SignUpContract.Presenter,
        SignUpContract.Model.OnPhoneNumberCheckedListener,
        SignUpContract.Model.onUserRegisteredListener {

    private final SignUpContract.View mView;
    private final UserModel mModel;

    @Inject
    public SignUpPresenterImpl(SignUpContract.View view, UserModel model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void onSignInClick(String phoneNumber) {
        mModel.checkUsername(phoneNumber, this);
    }

    @Override
    public void onSignUpClick(String phoneNumber, String userName) {
        mModel.registerUser(phoneNumber, userName, this);
    }

    @Override
    public void onUserFound(int id) {
        Logger.log("id = [" + id + "]");
    }

    @Override
    public void onUserNotFound() {
        Logger.log("");
    }

    @Override
    public void onUserCheckError(String message) {
        Logger.log("message = [" + message + "]");
    }

    @Override
    public void onUserRegistered(int id) {
        Logger.log("id = [" + id + "]");
    }

    @Override
    public void onUserRegisterError(String message) {
        Logger.log("message = [" + message + "]");
    }
}
