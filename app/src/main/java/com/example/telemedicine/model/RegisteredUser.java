package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RegisteredUser implements Parcelable {

    @SerializedName("Email")
    private String userEmail;
    @SerializedName("Password")
    private String userPassword;

    public RegisteredUser(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    private RegisteredUser(Parcel in) {
        userEmail = in.readString();
        userPassword = in.readString();
    }

    public static final Creator<RegisteredUser> CREATOR = new Creator<RegisteredUser>() {
        @Override
        public RegisteredUser createFromParcel(Parcel in) {
            return new RegisteredUser(in);
        }

        @Override
        public RegisteredUser[] newArray(int size) {
            return new RegisteredUser[size];
        }
    };

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userEmail);
        parcel.writeString(userPassword);
    }
}
