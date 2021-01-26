package com.joshgm3z.chatapp.chat.di;

import com.joshgm3z.chatapp.chat.ChatModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ChatModule {

    @Provides
    ChatModel providesChatModel() {
        return new ChatModel();
    }

}
