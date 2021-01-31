package com.joshgm3z.chatapp.pages.users;

import com.joshgm3z.chatapp.common.data.User;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.common.utils.SharedPrefs;
import com.joshgm3z.chatapp.server.UserModel;
import com.joshgm3z.chatapp.server.UserModelCallBacks;

import java.util.List;

public class UsersPresenterImpl implements UsersContract.Presenter, UserModelCallBacks.OnUsersListListener {

    private UsersContract.View mView;
    private UserModel mModel;
    private String mCurrentUser;

    public UsersPresenterImpl(UsersContract.View view, UserModel model) {
        mView = view;
        mModel = model;
        mCurrentUser = SharedPrefs.getCurrentUser(mView.getContext());
    }

    @Override
    public void onActivityResume() {
        mModel.getUsersList(mCurrentUser, this);
    }

    @Override
    public void onUsersReceived(List<User> userList) {
        Logger.log("userList = [" + userList + "]");
        mView.updateList(userList);
    }

    @Override
    public void onUsersFetchError(String message) {
        mView.showMessage(message);
    }
}
