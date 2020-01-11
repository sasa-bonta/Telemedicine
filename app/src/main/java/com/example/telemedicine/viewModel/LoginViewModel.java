package com.example.telemedicine.viewModel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.telemedicine.model.RegisteredUser;
import com.example.telemedicine.model.ServerResponse;
import com.example.telemedicine.request.RetrofitCall;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<ServerResponse> registeredUserLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void makeAuthenticationRequest(RegisteredUser user) {
        compositeDisposable.add(authenticateUser(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    if (response.getResponseStatus().equals("SUCCESS")) {
                        Toast.makeText(getApplication(), "Successful", Toast.LENGTH_SHORT).show();
                        registeredUserLiveData.postValue(response);
                    } else {
                        Toast.makeText(getApplication(), response.getResponseToken(), Toast.LENGTH_SHORT).show();
                    }
                }, throwable -> Toast.makeText(getApplication(), throwable.getMessage(), Toast.LENGTH_SHORT).show()));
    }

    public MutableLiveData<ServerResponse> getRegisteredUserLiveData() {
        return registeredUserLiveData;
    }

    private Single<ServerResponse> authenticateUser(RegisteredUser user) {
        return RetrofitCall.getInstance().authenticateUser(user);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
