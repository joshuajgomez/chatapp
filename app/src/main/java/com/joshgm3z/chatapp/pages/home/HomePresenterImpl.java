package com.joshgm3z.chatapp.pages.home;

import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.data.HomeItem;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.common.utils.SharedPrefs;
import com.joshgm3z.chatapp.pages.chat.ChatContract;
import com.joshgm3z.chatapp.server.ChatModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class HomePresenterImpl implements HomeContract.Presenter,
        ChatContract.Model.OnChatListReceivedListener {

    private HomeContract.View mView;
    private ChatModel mModel;
    private String mCurrentUser;

    @Inject
    public HomePresenterImpl(HomeContract.View view, ChatModel model) {
        mView = view;
        mModel = model;
        mCurrentUser = SharedPrefs.getCurrentUser(view.getContext());
    }

    @Override
    public void onActivityResume() {
        mModel.getAllChats(mCurrentUser, this);
    }

    @Override
    public void onChatListReceived(List<Chat> chatList) {
        Logger.log("chatList = [" + chatList + "]");
        mView.updateList(buildHomeItemList(chatList));
    }

    private List<HomeItem> buildHomeItemList(List<Chat> chatList) {
        HashMap<String, HomeItem> homeItemList = new HashMap<>();
        if (chatList != null) {
            for (Chat chat : chatList) {
                String key = "";
                if (chat.getFromUser().equals(mCurrentUser)) {
                    // Sent message
                    key = chat.getToUser();
                } else if (chat.getToUser().equals(mCurrentUser)) {
                    // Received message
                    key = chat.getFromUser();
                } else {
                    // Invalid message
                }
                HomeItem homeItem;
                if (!key.isEmpty()) {
                    if (!homeItemList.containsKey(key)) {
                        // Create new entry
                        homeItem = new HomeItem();
                        homeItem.setCounter(1);
                    } else {
                        // Update existing entry
                        homeItem = homeItemList.get(key);
                        homeItem.incrementCounter();
                    }
                    homeItem.setMessage(chat.getMessage());
                    homeItem.setUsername(key);

                    homeItemList.put(key, homeItem);
                } else {
                    // invalid sender
                }
            }
        }
        return new ArrayList<>(homeItemList.values());
    }

    @Override
    public void onChatListReceiveFailed(String message) {
        mView.showMessage(message);
    }
}
