package com.joshgm3z.chatapp.chat;

import com.joshgm3z.chatapp.common.data.Chat;

import java.util.List;

public interface ChatContract {

    interface Presenter {
        void onSendButtonClick(String message);

        void onDestroy();

        void refreshView();
    }

    interface View {
        void updateChatList(List<Chat> chatList);
        void showMessage(String message);
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
