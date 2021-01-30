package com.joshgm3z.chatapp.pages.chat;

import android.content.Context;

import com.joshgm3z.chatapp.common.data.Chat;

import java.util.List;

public interface ChatContract {

    interface Presenter {
        void onSendButtonClick(String message);

        void onDestroy();

        void refreshView();

        void setChatUser(String chatUser);
    }

    interface View {
        void updateChatList(List<Chat> chatList);
        void showMessage(String message);

        Context getContext();
    }

    interface Model {
        void sendChat(Chat chat, ChatContract.Model.OnChatSentListener listener);
        void getAllChats(ChatContract.Model.OnChatListReceivedListener listener);

        interface OnChatSentListener {
            void onChatSent(int id);
            void onChatSentFailed(String message);
        }

        interface OnChatListReceivedListener {
            void onChatListReceived(List<Chat> chatList);
            void onChatListReceiveFailed(String message);
        }
    }

}
