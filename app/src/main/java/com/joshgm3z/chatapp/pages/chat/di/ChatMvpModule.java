package com.joshgm3z.chatapp.pages.chat.di;

import com.joshgm3z.chatapp.pages.chat.ChatContract;
import com.joshgm3z.chatapp.pages.chat.ChatPresenterImpl;
import com.joshgm3z.chatapp.server.ChatModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ChatMvpModule {

    private ChatContract.View mView;

    public ChatMvpModule(ChatContract.View view) {
        mView = view;
    }

    @Provides
    ChatContract.View providesView(){
        return mView;
    }

    @Provides
    ChatContract.Presenter providesPresenter(ChatContract.View view, ChatModel model){
        return new ChatPresenterImpl(view, model);
    }

}
