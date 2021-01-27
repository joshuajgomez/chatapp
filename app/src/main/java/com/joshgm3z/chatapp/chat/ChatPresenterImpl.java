package com.joshgm3z.chatapp.chat;

import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.data.User;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.server.ServerModel;

import javax.inject.Inject;

public class ChatPresenterImpl implements ChatContract.Presenter {

    private ChatContract.View mView;
    private ServerModel mModel;

    @Inject
    public ChatPresenterImpl(ChatContract.View view, ServerModel model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void onSendButtonClick(String message) {
        Logger.log("message = [" + message + "]");

        String fromUser = "Joshua";
        String toUser = "Albin";
        long time = System.currentTimeMillis();

        mModel.sendChat(new Chat(message, time, fromUser, toUser));
    }

    @Override
    public void onDestroy() {
        this.mView = null;
    }
}
