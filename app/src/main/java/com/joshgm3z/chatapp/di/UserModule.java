package com.joshgm3z.chatapp.di;

import com.joshgm3z.chatapp.server.UserModel;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    public UserModel providesUserModel() {
        return new UserModel();
    }

}
