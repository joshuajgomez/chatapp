package com.joshgm3z.chatapp.pages.signup.di;

import com.joshgm3z.chatapp.di.ActivityScope;
import com.joshgm3z.chatapp.di.AppComponent;
import com.joshgm3z.chatapp.pages.signup.SignUpActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {SignUpMvpModule.class})
public interface SignUpComponent {

    void inject(SignUpActivity activity);
}
