package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserProfile implements Parcelable {

    @SerializedName("FullName")
    private String fullName;
    @SerializedName("Birthday")
    private String userBirthday;
    @SerializedName("Email")
    private String userEmail;
    @SerializedName("Phone")
    private String userPhone;
    @SerializedName("Address")
    private String userAddress;
    @SerializedName("Username")
    private String username;
    @SerializedName("Base64Photo")
    private String base64Photo;
    @SerializedName("Status")
    private String status;

    private UserProfile(Parcel in) {
        fullName = in.readString();
        userBirthday = in.readString();
        userEmail = in.readString();
        userPhone = in.readString();
        userAddress = in.readString();
        username = in.readString();
        base64Photo = in.readString();
        status = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(userBirthday);
        dest.writeString(userEmail);
        dest.writeString(userPhone);
        dest.writeString(userAddress);
        dest.writeString(username);
        dest.writeString(base64Photo);
        dest.writeString(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        @Override
        public UserProfile createFromParcel(Parcel in) {
            return new UserProfile(in);
        }

        @Override
        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };
}
