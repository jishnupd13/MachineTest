package com.app.androidmachinetestapi.remotenetwork;

import com.app.androidmachinetestapi.models.UserDetailsModel;
import com.app.androidmachinetestapi.models.UserListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/api/users")
    Call<UserListModel> doGetUserList();

    @GET("/api/users/{UserId}")
    Call<UserDetailsModel> getUserDetailsById(@Path("UserId") Integer userId);
}
