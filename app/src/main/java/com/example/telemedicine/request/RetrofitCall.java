package com.example.telemedicine.request;

import com.example.telemedicine.model.ServerResponse;
import com.example.telemedicine.model.Doctor;
import com.example.telemedicine.model.RegisteredUser;
import com.example.telemedicine.model.UnregisteredUser;
import com.example.telemedicine.model.UserAppointment;
import com.example.telemedicine.model.UserAppointmentResponse;
import com.example.telemedicine.model.UserProfile;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCall {

    private static RetrofitCall retrofitInstance;
    public static final String API_BASE_URL = "http://81.180.72.17/api/";

    private RetrofitCall() {
    }


    public static RetrofitCall getInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new RetrofitCall();
        }
        return retrofitInstance;
    }

    private static Retrofit getRetrofit(String url) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);

        return new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    public Single<ServerResponse> registerNewUser(UnregisteredUser unregisteredUser) {
        RetrofitInterface retrofitInterface = getRetrofit(API_BASE_URL).create(RetrofitInterface.class);
        return retrofitInterface.registerUser(unregisteredUser);
    }

    public Single<ServerResponse> authenticateUser(RegisteredUser registeredUser) {
        RetrofitInterface retrofitInterface = getRetrofit(API_BASE_URL).create(RetrofitInterface.class);
        return retrofitInterface.authenticateUser(registeredUser);
    }

    public Single<UserProfile> getUserProfile(String token) {
        RetrofitInterface retrofitInterface = getRetrofit(API_BASE_URL).create(RetrofitInterface.class);
        return retrofitInterface.getUserProfile(token);
    }

    public Single<List<Doctor>> getAllDoctors(String token) {
        RetrofitInterface retrofitInterface = getRetrofit(API_BASE_URL).create(RetrofitInterface.class);
        return retrofitInterface.getDoctorsList(token);
    }

    public Single<Doctor> getSingleDoctor(int doctorId, String token) {
        RetrofitInterface retrofitInterface = getRetrofit(API_BASE_URL).create(RetrofitInterface.class);
        return retrofitInterface.getDoctor(doctorId, token);
    }

    public Single<UserAppointmentResponse> setNewAppointment(String token, UserAppointment userAppointment) {
        RetrofitInterface retrofitInterface = getRetrofit(API_BASE_URL).create(RetrofitInterface.class);
        return retrofitInterface.addAppointment(token, userAppointment);
    }

}
