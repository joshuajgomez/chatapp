package com.joshgm3z.chatapp.signup.di;

import com.joshgm3z.chatapp.server.UserModel;
import com.joshgm3z.chatapp.signup.SignUpContract;
import com.joshgm3z.chatapp.signup.SignUpPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpMvpModule {

    private SignUpContract.View mView;

    public SignUpMvpModule(SignUpContract.View view){
        mView = view;
    }

    @Provides
    SignUpContract.View providesView(){
        return mView;
    }

    @Provides
    SignUpContract.Presenter providesPresenter(SignUpContract.View view, UserModel model){
        return new SignUpPresenterImpl(view, model);
    }

}
