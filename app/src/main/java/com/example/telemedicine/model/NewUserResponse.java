package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NewUserResponse implements Parcelable {

    private String fullName;
    private String birthday;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;
    private String base64Photo;

    public NewUserResponse(String fullName, String birthday, String email, String phone,
                           String address, String username, String password, String base64Photo) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.base64Photo = base64Photo;
    }

    private NewUserResponse(Parcel in) {
        fullName = in.readString();
        birthday = in.readString();
        email = in.readString();
        phone = in.readString();
        address = in.readString();
        username = in.readString();
        password = in.readString();
        base64Photo = in.readString();
    }

    public static final Creator<NewUserResponse> CREATOR = new Creator<NewUserResponse>() {
        @Override
        public NewUserResponse createFromParcel(Parcel in) {
            return new NewUserResponse(in);
        }

        @Override
        public NewUserResponse[] newArray(int size) {
            return new NewUserResponse[size];
        }
    };

    public String getFullName() {
        return fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBase64Photo() {
        return base64Photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fullName);
        parcel.writeString(birthday);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(address);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(base64Photo);
    }
}
