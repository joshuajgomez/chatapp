package com.joshgm3z.chatapp.di;

import android.content.Context;

import com.joshgm3z.chatapp.InitApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context mContext;

    public ContextModule(InitApplication application) {
        mContext = application.getApplicationContext();
    }

    @Provides
    Context providesContext(){
        return mContext;
    }
}
