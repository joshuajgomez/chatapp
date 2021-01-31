package com.joshgm3z.chatapp.pages.users.di;

import com.joshgm3z.chatapp.pages.users.UsersContract;
import com.joshgm3z.chatapp.pages.users.UsersPresenterImpl;
import com.joshgm3z.chatapp.server.UserModel;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersMvpModule {

    private UsersContract.View mView;

    public UsersMvpModule(UsersContract.View view) {
        mView = view;
    }

    @Provides
    UsersContract.View providesView(){
        return mView;
    }

    @Provides
    UsersContract.Presenter providesPresenter(UsersContract.View view, UserModel model){
        return new UsersPresenterImpl(view, model);
    }
}
