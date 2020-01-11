package com.example.telemedicine.request;

import com.example.telemedicine.model.ServerResponse;
import com.example.telemedicine.model.Doctor;
import com.example.telemedicine.model.RegisteredUser;
import com.example.telemedicine.model.UnregisteredUser;
import com.example.telemedicine.model.UserAppointment;
import com.example.telemedicine.model.UserAppointmentResponse;
import com.example.telemedicine.model.UserProfile;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface {

    //http://81.180.72.17/api/

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("Register/UserReg")
    Single<ServerResponse> registerUser(@Body UnregisteredUser unregisteredUser);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("Login/UserAuth")
    Single<ServerResponse> authenticateUser(@Body RegisteredUser registeredUser);

    @FormUrlEncoded
    @GET("Profile/GetProfile")
    Single<UserProfile> getUserProfile(@Header("token") String token);

    @FormUrlEncoded
    @GET("Doctor/GetDoctorList")
    Single<List<Doctor>> getDoctorsList(@Header("token") String token);

    @FormUrlEncoded
    @GET("Doctor/GetDoctor/{id}")
    Single<Doctor> getDoctor(@Path("id") int doctorId,
                             @Header("token") String token);

    @FormUrlEncoded
    @POST("Doctor/AddConsultation")
    Single<UserAppointmentResponse> addAppointment(@Header("token") String token,
                                                   @Body UserAppointment userAppointment);
}
