package com.joshgm3z.chatapp.pages.signup;

import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.common.utils.SharedPrefs;
import com.joshgm3z.chatapp.server.UserModel;
import com.joshgm3z.chatapp.server.UserModelCallBacks;

import javax.inject.Inject;

public class SignUpPresenterImpl implements SignUpContract.Presenter,
        UserModelCallBacks.OnUsernameCheckedListener,
        UserModelCallBacks.onUserRegisteredListener {

    private final SignUpContract.View mView;
    private final UserModel mModel;

    @Inject
    public SignUpPresenterImpl(SignUpContract.View view, UserModel model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void onSignInClick(String username) {
        mModel.checkUsername(username, this);
    }

    @Override
    public void onUserFound(String username) {
        Logger.log("username = [" + username + "]");
        mView.showMessage("User found: " + username);
        SharedPrefs.setCurrentUser(mView.getContext(), username);
        mView.goToHome();

    }

    @Override
    public void onUserNotFound(String username) {
        Logger.log("");
        onSignUpClick(username);
    }

    @Override
    public void onUserCheckError(String message) {
        Logger.log("message = [" + message + "]");
        mView.showMessage(message);
    }

    @Override
    public void onSignUpClick(String userName) {
        mView.showMessage("Registering user: " + userName);
        mModel.registerUser(userName, this);
    }

    @Override
    public void onUserRegistered(String username) {
        Logger.log("username = [" + username + "]");
        mView.showMessage("User registered: " + username);
        SharedPrefs.setCurrentUser(mView.getContext(), username);
        mView.goToHome();
    }

    @Override
    public void onUserRegisterError(String message) {
        Logger.log("message = [" + message + "]");
        mView.showMessage(message);
    }
}
