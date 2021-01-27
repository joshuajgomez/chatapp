package com.joshgm3z.chatapp.server.retrofit;

import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.server.retrofit.response.SendMessageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {

    @GET("/chat/test")
    Call<String> test();

    @POST("/chat/send")
    Call<SendMessageResponse> send(@Body Chat chat);

    @POST("/chat/list_all")
    Call<List<Chat>> listAll();

}
