package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ServerResponse implements Parcelable {

    @SerializedName("Status")
    private String responseStatus;
    @SerializedName("Message")
    private String responseToken;

    public ServerResponse(String responseStatus, String responseToken) {
        this.responseStatus = responseStatus;
        this.responseToken = responseToken;
    }

    private ServerResponse(Parcel in) {
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

    public static final Creator<ServerResponse> CREATOR = new Creator<ServerResponse>() {
        @Override
        public ServerResponse createFromParcel(Parcel in) {
            return new ServerResponse(in);
        }

        @Override
        public ServerResponse[] newArray(int size) {
            return new ServerResponse[size];
        }
    };

    public String getResponseStatus() {
        return responseStatus;
    }

    public String getResponseToken() {
        return responseToken;
    }
}
