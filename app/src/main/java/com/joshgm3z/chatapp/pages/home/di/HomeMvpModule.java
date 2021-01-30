package com.joshgm3z.chatapp.pages.home.di;

import com.joshgm3z.chatapp.pages.home.HomeContract;
import com.joshgm3z.chatapp.pages.home.HomePresenterImpl;
import com.joshgm3z.chatapp.server.ChatModel;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeMvpModule {

    private HomeContract.View mView;

    public HomeMvpModule(HomeContract.View view) {
        mView = view;
    }

    @Provides
    HomeContract.View providesView(){
        return mView;
    }

    @Provides
    HomeContract.Presenter providesPresenter(HomeContract.View view, ChatModel model){
        return new HomePresenterImpl(view, model);
    }
}
