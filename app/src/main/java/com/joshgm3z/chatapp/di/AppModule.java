package com.joshgm3z.chatapp.di;

import android.app.Application;

import com.joshgm3z.chatapp.InitApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private InitApplication mInitApplication;

    public AppModule(InitApplication initApplication) {
        mInitApplication = initApplication;
    }

    @Provides
    Application providesApplication(){
        return mInitApplication;
    }
}
