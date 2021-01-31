package com.joshgm3z.chatapp.pages.users.di;

import com.joshgm3z.chatapp.di.AppComponent;
import com.joshgm3z.chatapp.pages.users.UsersActivity;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = UsersMvpModule.class)
public interface UsersComponent {

    void inject(UsersActivity usersActivity);

}
