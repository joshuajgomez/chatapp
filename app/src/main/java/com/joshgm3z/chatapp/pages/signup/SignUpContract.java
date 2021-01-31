package com.joshgm3z.chatapp.pages.signup;

import android.content.Context;

public interface SignUpContract {

    interface View {

        void showLoadingMask(String message);

        void hideLoadingMask();

        void showNameInput();

        Context getContext();

        void goToHome();

        void showMessage(String message);
    }

    interface Presenter {

        void onSignInClick(String username);

        void onSignUpClick(String username);
    }

}
