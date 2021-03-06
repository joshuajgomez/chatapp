package com.joshgm3z.chatapp.pages.chat;

import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.common.utils.SharedPrefs;
import com.joshgm3z.chatapp.server.ChatModel;

import java.util.List;

import javax.inject.Inject;

public class ChatPresenterImpl implements ChatContract.Presenter,
        ChatContract.Model.OnChatSentListener, ChatContract.Model.OnChatListReceivedListener {

    private ChatContract.View mView;
    private ChatModel mModel;
    private String mCurrentUser;
    private String mChatUser;

    @Inject
    public ChatPresenterImpl(ChatContract.View view, ChatModel model) {
        mView = view;
        mModel = model;
        mCurrentUser = SharedPrefs.getCurrentUser(mView.getContext());
    }

    @Override
    public void onSendButtonClick(String message) {
        Logger.log("message = [" + message + "]");
        mModel.sendChat(
                new Chat(
                        message,
                        System.currentTimeMillis(),
                        mCurrentUser,
                        mChatUser),
                this);
    }

    @Override
    public void onDestroy() {
        this.mView = null;
    }

    @Override
    public void refreshView() {
        mModel.getChatsBetweenUsers(mCurrentUser, mChatUser, this);
    }

    @Override
    public void setChatUser(String chatUser) {
        mChatUser = chatUser;
    }

    @Override
    public void onChatSent(int id) {
        Logger.log("id = [" + id + "]");
        refreshView();
    }

    @Override
    public void onChatSentFailed(String message) {
        mView.showMessage(message);
    }

    @Override
    public void onChatListReceived(List<Chat> chatList) {
        Logger.log("chatList = [" + chatList + "]");
        mView.updateChatList(chatList);
    }

    @Override
    public void onChatListReceiveFailed(String message) {
        mView.showMessage(message);
    }
}
