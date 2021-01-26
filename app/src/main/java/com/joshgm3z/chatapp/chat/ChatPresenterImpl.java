package com.joshgm3z.chatapp.chat;

import android.util.Log;

import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.data.User;

import javax.inject.Inject;

public class ChatPresenterImpl implements ChatContract.Presenter {

    private ChatContract.View mView;
    private ChatModel mModel;

    @Inject
    public ChatPresenterImpl(ChatContract.View view, ChatModel model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void onSendButtonClick(String message) {
        Log.i("Joshua", message);

        User fromUser = new User("Joshua");
        User toUser = new User("Albin");

        mModel.sendChat(new Chat(message, System.currentTimeMillis(), fromUser, toUser));
    }

    @Override
    public void onDestroy() {
        this.mView = null;
    }
}
