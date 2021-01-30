package com.joshgm3z.chatapp.pages.chat.di;

import com.joshgm3z.chatapp.pages.chat.ChatActivity;
import com.joshgm3z.chatapp.di.ActivityScope;
import com.joshgm3z.chatapp.di.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ChatMvpModule.class})
public interface ChatComponent {

    void inject(ChatActivity chatActivity);

}
