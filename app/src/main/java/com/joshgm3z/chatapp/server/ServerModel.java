package com.joshgm3z.chatapp.server;

import com.joshgm3z.chatapp.chat.ChatContract;
import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.utils.Logger;
import com.joshgm3z.chatapp.server.retrofit.RetrofitService;
import com.joshgm3z.chatapp.server.retrofit.response.SendMessageResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerModel implements ChatContract.Model {

    public static final String SERVER_URL = "http://10.0.2.2:8080";

    private ChatContract.Model.OnChatAddedListener mChatAddedListener;

    private RetrofitService mRetrofitService;

    @Inject
    public ServerModel() {
        init();
    }

    public void init(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();
        mRetrofitService = retrofit.create(RetrofitService.class);
    }

    @Override
    public void sendChat(Chat chat) {
        Logger.log("chat = [" + chat + "]");
        if (mRetrofitService != null) {
            Call<SendMessageResponse> send = mRetrofitService.send(chat);
            send.enqueue(new Callback<SendMessageResponse>() {
                @Override
                public void onResponse(Call<SendMessageResponse> call, Response<SendMessageResponse> response) {
                    Logger.log("send:onResponse = " + response.body());
                }

                @Override
                public void onFailure(Call<SendMessageResponse> call, Throwable t) {
                    Logger.log("send:onFailure throwable = " + t.getMessage());
                }
            });
        }
    }
}
