package com.joshgm3z.chatapp.chat;

import com.joshgm3z.chatapp.common.data.Chat;

import java.util.List;

public interface ChatContract {

    interface Presenter {
        void onSendButtonClick(String message);

        void onDestroy();
    }

    interface View {
        void updateChatList(List<Chat> chatList);
    }

    interface Model {
        void sendChat(Chat chat);

        interface OnChatAddedListener {
            void onChatAdded(List<Chat> chatList);
        }
    }

}
