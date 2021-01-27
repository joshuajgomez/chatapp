package com.joshgm3z.chatapp;

import android.app.Application;
import android.content.Context;

import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.di.AppComponent;
import com.joshgm3z.chatapp.di.AppModule;
import com.joshgm3z.chatapp.di.ContextModule;
import com.joshgm3z.chatapp.di.DaggerAppComponent;
import com.joshgm3z.chatapp.di.ServerModule;

public class InitApplication extends Application {

    private AppComponent mAppComponent;

    public static InitApplication getInstance(Context context){
        return (InitApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.log("Heyyy");
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .contextModule(new ContextModule(this))
                .serverModule(new ServerModule())
        .build();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
