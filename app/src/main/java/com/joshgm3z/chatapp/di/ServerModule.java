package com.joshgm3z.chatapp.di;

import com.joshgm3z.chatapp.server.ChatModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ServerModule {

    @Provides
    ChatModel providesServerModel() {
        return new ChatModel();
    }

}
