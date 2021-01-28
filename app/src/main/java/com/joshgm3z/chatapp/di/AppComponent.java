package com.joshgm3z.chatapp.di;

import com.joshgm3z.chatapp.InitApplication;

import dagger.Component;

@Component(modules = {AppModule.class, ContextModule.class, ServerModule.class, UserModule.class})
public interface AppComponent {

}
