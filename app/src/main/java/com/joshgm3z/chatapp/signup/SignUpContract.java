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

        void onUserFound();

        void onSignUpClick(String phoneNumber, String name);
    }

    interface Model {

        void checkPhoneNumber(String phoneNumber, OnPhoneNumberCheckedListener listener);

        interface OnPhoneNumberCheckedListener {

            void onUserFound(User user);

            void onUserNotFound(String phoneNumber);

            void onUserCheckError(String message);
        }

        void registerUser(String phoneNumber, String userName, onUserRegisteredListener listener);

        interface onUserRegisteredListener {

            void onUserRegistered(User user);

            void onUserRegisterError(String message);
        }
    }

}
