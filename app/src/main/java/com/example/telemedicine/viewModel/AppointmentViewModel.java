package com.example.telemedicine.viewModel;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.telemedicine.model.UserAppointment;
import com.example.telemedicine.model.UserAppointmentResponse;
import com.example.telemedicine.request.RetrofitCall;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AppointmentViewModel extends AndroidViewModel {

    private MutableLiveData<UserAppointmentResponse> appointmentLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AppointmentViewModel(@NonNull Application application) {
        super(application);
    }

    @SuppressLint("CheckResult")
    public void makeNewAppointmentRequest(String token, UserAppointment appointment) {
        compositeDisposable.add(requestNewAppointment(token, appointment)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userAppointmentResponse ->
                                appointmentLiveData.postValue(userAppointmentResponse),
                        Throwable::printStackTrace));
    }

    public MutableLiveData<UserAppointmentResponse> getAppointmentLiveData() {
        return appointmentLiveData;
    }

    private Single<UserAppointmentResponse> requestNewAppointment(String token, UserAppointment appointment) {
        return RetrofitCall.getInstance().setNewAppointment(token, appointment);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}