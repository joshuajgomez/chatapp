package com.joshgm3z.chatapp.pages.home.di;

import com.joshgm3z.chatapp.di.AppComponent;
import com.joshgm3z.chatapp.pages.home.HomeActivity;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = HomeMvpModule.class)
public interface HomeComponent {

    void inject(HomeActivity homeActivity);

}
