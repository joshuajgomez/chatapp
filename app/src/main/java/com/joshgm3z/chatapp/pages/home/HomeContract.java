package com.joshgm3z.chatapp.pages.home;

import android.content.Context;

import com.joshgm3z.chatapp.common.data.HomeItem;

import java.util.List;

public interface HomeContract {

    interface View {
        void updateList(List<HomeItem> chatList);

        void showMessage(String message);

        Context getContext();
    }

    interface Presenter {
        void onActivityResume();
    }

}
