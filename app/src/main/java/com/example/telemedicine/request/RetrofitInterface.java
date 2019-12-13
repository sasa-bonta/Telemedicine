package com.example.telemedicine.request;

import com.example.telemedicine.model.NewUserResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterface {

    //http://81.180.72.17/

    @Headers({
            "Content-Type:application/x-www-form-urlencoded"
    })

    @FormUrlEncoded
    @POST("api/Register/UserReg")
    Single<NewUserResponse> registerUser(@Field("FullName") String fullName,
                                         @Field("Birthday") String birthday,
                                         @Field("Email") String email,
                                         @Field("Phone") String phone,
                                         @Field("Address") String address,
                                         @Field("Username") String username,
                                         @Field("Password") String password,
                                         @Field("Base64Photo") String base64Photo);

    /*@FormUrlEncoded
    @POST("/api/Login/UserAuth")
    Single<>*/
}
