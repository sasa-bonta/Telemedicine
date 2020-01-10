package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserAppointment implements Parcelable {

    @SerializedName("Name")
    private String name;
    @SerializedName("Disease")
    private String disease;
    @SerializedName("Address")
    private String address;
    @SerializedName("Address")
    private String description;

    public UserAppointment(String name, String disease, String address, String description) {
        this.name = name;
        this.disease = disease;
        this.address = address;
        this.description = description;
    }

    private UserAppointment(Parcel in) {
        name = in.readString();
        disease = in.readString();
        address = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(disease);
        dest.writeString(address);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserAppointment> CREATOR = new Creator<UserAppointment>() {
        @Override
        public UserAppointment createFromParcel(Parcel in) {
            return new UserAppointment(in);
        }

        @Override
        public UserAppointment[] newArray(int size) {
            return new UserAppointment[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDisease() {
        return disease;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}
