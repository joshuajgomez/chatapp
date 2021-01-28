package com.joshgm3z.chatapp.server.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/user/checkEmail")
    Call<String> checkPhoneNumber(@Body String phoneNumber);

    @POST("/user/register")
    Call<String> registerUser(@Body String phoneNumber,@Body String userName);

}
