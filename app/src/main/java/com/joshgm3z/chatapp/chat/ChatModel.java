package com.joshgm3z.chatapp.chat;

import android.util.Log;

import com.joshgm3z.chatapp.common.data.Chat;

import javax.inject.Inject;

public class ChatModel implements ChatContract.Model {

    private ChatContract.Model.OnChatAddedListener mChatAddedListener;

    @Inject
    public ChatModel() {

    }

    @Override
    public void sendChat(Chat chat) {
        Log.i("Joshua", "sendChat " + chat.toString());
    }
}
