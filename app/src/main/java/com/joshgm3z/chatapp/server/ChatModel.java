package com.joshgm3z.chatapp.server;

import com.joshgm3z.chatapp.chat.ChatContract;
import com.joshgm3z.chatapp.common.constants.Config;
import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.server.retrofit.ChatService;
import com.joshgm3z.chatapp.server.retrofit.response.BasicResponse;
import com.joshgm3z.chatapp.server.retrofit.response.SendMessageResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatModel implements ChatContract.Model {

    private ChatService mChatService;

    @Inject
    public ChatModel() {
        init();
    }

    public void init(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.SERVER_URL)
                .build();
        mChatService = retrofit.create(ChatService.class);
    }

    @Override
    public void sendChat(Chat chat, OnChatSentListener listener) {
        Logger.log("chat = [" + chat + "]");
        if (mChatService != null) {
            Call<SendMessageResponse> send = mChatService.send(chat);
            send.enqueue(new Callback<SendMessageResponse>() {
                @Override
                public void onResponse(Call<SendMessageResponse> call, Response<SendMessageResponse> response) {
                    Logger.log("send:onResponse = " + response.body());
                    listener.onChatSent(response.body().getId());
                }

                @Override
                public void onFailure(Call<SendMessageResponse> call, Throwable t) {
                    Logger.log("send:onFailure throwable = " + t.getMessage());
                    listener.onChatSentFailed(t.getMessage());
                }
            });
        }
    }

    @Override
    public void getAllChats(OnChatListReceivedListener listener) {
        mChatService.listAll().enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                listener.onChatListReceived(response.body());
            }

            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                listener.onChatListReceiveFailed(t.getMessage());
            }
        });
    }
}
