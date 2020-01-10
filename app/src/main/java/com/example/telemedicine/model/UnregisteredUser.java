package com.example.telemedicine.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UnregisteredUser implements Parcelable {

    @SerializedName("FullName")
    private String fullName;
    @SerializedName("Birthday")
    private String birthday;
    @SerializedName("Email")
    private String email;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("Address")
    private String address;
    @SerializedName("Username")
    private String username;
    @SerializedName("Password")
    private String password;
    @SerializedName("Base64Photo")
    private String base64Photo;

    public UnregisteredUser(String fullName, String birthday, String email, String phone,
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

    private UnregisteredUser(Parcel in) {
        fullName = in.readString();
        birthday = in.readString();
        email = in.readString();
        phone = in.readString();
        address = in.readString();
        username = in.readString();
        password = in.readString();
        base64Photo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(birthday);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(address);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(base64Photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UnregisteredUser> CREATOR = new Creator<UnregisteredUser>() {
        @Override
        public UnregisteredUser createFromParcel(Parcel in) {
            return new UnregisteredUser(in);
        }

        @Override
        public UnregisteredUser[] newArray(int size) {
            return new UnregisteredUser[size];
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

}
