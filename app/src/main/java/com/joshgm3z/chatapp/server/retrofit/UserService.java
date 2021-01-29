package com.joshgm3z.chatapp.server.retrofit;

import com.joshgm3z.chatapp.common.data.User;
import com.joshgm3z.chatapp.server.retrofit.response.BasicResponse;
import com.joshgm3z.chatapp.server.retrofit.response.CheckUserResponse;
import com.joshgm3z.chatapp.server.retrofit.response.UserAddedResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/user/checkUser")
    Call<CheckUserResponse> checkUsername(@Body User username);

    @POST("/user/add")
    Call<UserAddedResponse> registerUser(@Body String username);

    @POST("/user/list_users")
    Call<List<User>> listUsers();

}
