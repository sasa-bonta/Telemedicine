package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AuthenticationResponse implements Parcelable {

    @SerializedName("Status")
    private String responseStatus;
    @SerializedName("Message")
    private String responseToken;

    public AuthenticationResponse(String responseStatus, String responseToken) {
        this.responseStatus = responseStatus;
        this.responseToken = responseToken;
    }

    private AuthenticationResponse(Parcel in) {
        responseStatus = in.readString();
        responseToken = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(responseStatus);
        dest.writeString(responseToken);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AuthenticationResponse> CREATOR = new Creator<AuthenticationResponse>() {
        @Override
        public AuthenticationResponse createFromParcel(Parcel in) {
            return new AuthenticationResponse(in);
        }

        @Override
        public AuthenticationResponse[] newArray(int size) {
            return new AuthenticationResponse[size];
        }
    };

    public String getResponseStatus() {
        return responseStatus;
    }

    public String getResponseToken() {
        return responseToken;
    }
}
