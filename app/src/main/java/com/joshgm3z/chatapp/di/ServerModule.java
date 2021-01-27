package com.joshgm3z.chatapp.di;

import com.joshgm3z.chatapp.server.ServerModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ServerModule {

    @Provides
    ServerModel providesServerModel() {
        return new ServerModel();
    }

}
