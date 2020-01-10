package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Doctor implements Parcelable {

    @SerializedName("DocId")
    private int doctorId;
    @SerializedName("FullName")
    private String doctorFullName;
    @SerializedName("Specs")
    private String doctorSpecialization;
    @SerializedName("Address")
    private String doctorAddress;
    @SerializedName("About")
    private String doctorInformation;
    @SerializedName("Stars")
    private String doctorRating;
    @SerializedName("Photo")
    private String base64Photo;

    public Doctor(int doctorId, String doctorFullName, String doctorSpecialization,
                  String doctorAddress, String doctorInformation, String doctorRating,
                  String base64Photo) {
        this.doctorId = doctorId;
        this.doctorFullName = doctorFullName;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorAddress = doctorAddress;
        this.doctorInformation = doctorInformation;
        this.doctorRating = doctorRating;
        this.base64Photo = base64Photo;
    }

    private Doctor(Parcel in) {
        doctorId = in.readInt();
        doctorFullName = in.readString();
        doctorSpecialization = in.readString();
        doctorAddress = in.readString();
        doctorInformation = in.readString();
        doctorRating = in.readString();
        base64Photo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(doctorId);
        dest.writeString(doctorFullName);
        dest.writeString(doctorSpecialization);
        dest.writeString(doctorAddress);
        dest.writeString(doctorInformation);
        dest.writeString(doctorRating);
        dest.writeString(base64Photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Doctor> CREATOR = new Creator<Doctor>() {
        @Override
        public Doctor createFromParcel(Parcel in) {
            return new Doctor(in);
        }

        @Override
        public Doctor[] newArray(int size) {
            return new Doctor[size];
        }
    };

    public int getDoctorId() {
        return doctorId;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public String getDoctorInformation() {
        return doctorInformation;
    }

    public String getDoctorRating() {
        return doctorRating;
    }

    public String getBase64Photo() {
        return base64Photo;
    }
}
