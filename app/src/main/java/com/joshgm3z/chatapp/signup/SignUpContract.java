package com.joshgm3z.chatapp.signup;

import com.joshgm3z.chatapp.common.data.User;

public interface SignUpContract {

    interface View {

        void showLoadingMask(String message);

        void hideLoadingMask();

        void showNameInput();
    }

    interface Presenter {

        void onSignInClick(String phoneNumber);

        void onSignUpClick(String phoneNumber, String name);
    }

    interface Model {

        void checkUsername(String phoneNumber, OnPhoneNumberCheckedListener listener);

        interface OnPhoneNumberCheckedListener {

            void onUserFound(int id);

            void onUserNotFound();

            void onUserCheckError(String message);
        }

        void registerUser(String phoneNumber, String userName, onUserRegisteredListener listener);

        interface onUserRegisteredListener {

            void onUserRegistered(int id);

            void onUserRegisterError(String message);
        }
    }

}
