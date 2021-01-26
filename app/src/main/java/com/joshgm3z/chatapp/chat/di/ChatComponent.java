package com.joshgm3z.chatapp.chat.di;

import com.joshgm3z.chatapp.chat.ChatActivity;
import com.joshgm3z.chatapp.di.ActivityScope;
import com.joshgm3z.chatapp.di.AppComponent;

import javax.inject.Scope;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ChatMvpModule.class, ChatModule.class})
public interface ChatComponent {

    void inject(ChatActivity chatActivity);

}