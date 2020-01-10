package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserAppointmentResponse implements Parcelable {

    @SerializedName("ConsId")
    private int appointmentId;
    @SerializedName("Name")
    private String name;
    @SerializedName("Disease")
    private String disease;
    @SerializedName("Address")
    private String address;
    @SerializedName("Description")
    private String description;
    @SerializedName("DocId")
    private int doctorId;
    @SerializedName("IsConfirmed")
    private boolean isConfirmed;

    public UserAppointmentResponse(int appointmentId, String name, String disease, String address,
                                   String description, int doctorId, boolean isConfirmed) {
        this.appointmentId = appointmentId;
        this.name = name;
        this.disease = disease;
        this.address = address;
        this.description = description;
        this.doctorId = doctorId;
        this.isConfirmed = isConfirmed;
    }

    private UserAppointmentResponse(Parcel in) {
        appointmentId = in.readInt();
        name = in.readString();
        disease = in.readString();
        address = in.readString();
        description = in.readString();
        doctorId = in.readInt();
        isConfirmed = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(appointmentId);
        dest.writeString(name);
        dest.writeString(disease);
        dest.writeString(address);
        dest.writeString(description);
        dest.writeInt(doctorId);
        dest.writeByte((byte) (isConfirmed ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserAppointmentResponse> CREATOR = new Creator<UserAppointmentResponse>() {
        @Override
        public UserAppointmentResponse createFromParcel(Parcel in) {
            return new UserAppointmentResponse(in);
        }

        @Override
        public UserAppointmentResponse[] newArray(int size) {
            return new UserAppointmentResponse[size];
        }
    };

    public int getAppointmentId() {
        return appointmentId;
    }

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

    public int getDoctorId() {
        return doctorId;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }
}
