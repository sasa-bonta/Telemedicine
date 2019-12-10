package com.example.telemedicine.request;

import com.example.telemedicine.model.NewUserResponse;

import io.reactivex.Single;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @FormUrlEncoded
    @POST("~/api/Login/UserAuth")
    Single<NewUserResponse> register();

}
