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

    interface Model {

        void checkUsername(String phoneNumber, OnPhoneNumberCheckedListener listener);

        interface OnPhoneNumberCheckedListener {

            void onUserFound(String username);

            void onUserNotFound(String username);

            void onUserCheckError(String message);
        }

        void registerUser(String userName, onUserRegisteredListener listener);

        interface onUserRegisteredListener {

            void onUserRegistered(String username);

            void onUserRegisterError(String message);
        }
    }

}
