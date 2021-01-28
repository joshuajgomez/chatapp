package com.joshgm3z.chatapp.signup;

import com.joshgm3z.chatapp.common.data.User;
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
        mModel.checkPhoneNumber(phoneNumber, this);
    }

    @Override
    public void onUserFound() {

    }

    @Override
    public void onSignUpClick(String phoneNumber, String userName) {
        mModel.registerUser(phoneNumber, userName, this);
    }

    @Override
    public void onUserFound(User user) {

    }

    @Override
    public void onUserNotFound(String phoneNumber) {

    }

    @Override
    public void onUserCheckError(String message) {

    }

    @Override
    public void onUserRegistered(User user) {

    }

    @Override
    public void onUserRegisterError(String message) {

    }
}
