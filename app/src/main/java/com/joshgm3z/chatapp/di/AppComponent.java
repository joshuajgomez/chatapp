package com.joshgm3z.chatapp.di;

import android.content.Context;

import com.joshgm3z.chatapp.InitApplication;
import com.joshgm3z.chatapp.server.ServerModel;

import dagger.Component;

@Component(modules = {AppModule.class, ContextModule.class, ServerModule.class})
public interface AppComponent {

    void inject(InitApplication initApplication);

    ServerModel getServerModel();
}
