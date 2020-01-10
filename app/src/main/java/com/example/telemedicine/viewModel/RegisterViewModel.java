package com.example.telemedicine.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.telemedicine.model.UnregisteredUser;
import com.example.telemedicine.request.RetrofitCall;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RegisterViewModel extends AndroidViewModel {

    private MutableLiveData<UnregisteredUser> unregisteredUserMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void makeRegisterRequest(UnregisteredUser user) {
        registerNewUser(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(unregisteredUser ->
                                unregisteredUserMutableLiveData.postValue(unregisteredUser),
                        Throwable::printStackTrace);
    }

    public MutableLiveData<UnregisteredUser> getUnregisteredUserLiveData() {
        return unregisteredUserMutableLiveData;
    }

    private Single<UnregisteredUser> registerNewUser(UnregisteredUser user) {
        return RetrofitCall.getInstance().registerNewUser(user);
    }
}