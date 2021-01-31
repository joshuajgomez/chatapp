package com.joshgm3z.chatapp.server.retrofit;

import com.joshgm3z.chatapp.common.data.Chat;
import com.joshgm3z.chatapp.common.data.User;
import com.joshgm3z.chatapp.server.retrofit.response.BasicResponse;
import com.joshgm3z.chatapp.server.retrofit.response.SendMessageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ChatService {

    @GET("/chat/test")
    Call<String> test();

    @POST("/chat/send")
    Call<SendMessageResponse> send(@Body Chat chat);

    @GET("/chat/list_all_chats_for_user")
    Call<List<Chat>> listAllChatsForUser(@Query("username") String username);

    @GET("/chat/list_chat_between_users")
    Call<List<Chat>> listChatsBetweenUsers(@Query("username1") String username1, @Query("username2") String username2);

}
