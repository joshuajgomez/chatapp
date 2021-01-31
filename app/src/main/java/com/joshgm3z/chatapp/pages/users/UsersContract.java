package com.joshgm3z.chatapp.pages.users;

import android.content.Context;

import com.joshgm3z.chatapp.common.data.User;

import java.util.List;

public interface UsersContract {

    interface View {
        void updateList(List<User> userList);

        Context getContext();

        void showMessage(String message);
    }

    interface Presenter {
        void onActivityResume();
    }

}
