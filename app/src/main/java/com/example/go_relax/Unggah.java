package com.example.go_relax;

import android.os.Parcel;
import android.os.Parcelable;

public class Unggah implements Parcelable{
    private String Id;

    private String Nama;
    private String Alamat;
    private String Number;
    private String Info;

    private String CheckIn;
    private String CheckOut;

    private String user_id;

    protected Unggah(Parcel in) {
        Id = in.readString();
        Nama = in.readString();
        Alamat = in.readString();
        Number = in.readString();
        Info = in.readString();
        CheckIn = in.readString();
        CheckOut = in.readString();
        user_id = in.readString();
    }

    @Override
    public void  writeToParcel(Parcel dest, int flags) {
        dest.writeString(Id);
        dest.writeString(Nama);
        dest.writeString(Alamat);
        dest.writeString(Number);
        dest.writeString(Info);
        dest.writeString(CheckIn);
        dest.writeString(CheckOut);
        dest.writeString(user_id);

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public  int describeContents() {return  0;}

    public static  final Creator<Unggah> CREATOR = new  Creator<Unggah>() {
        @Override
        public  Unggah createFromParcel(Parcel in) { return new Unggah(in);}
        @Override
        public Unggah[] newArray(int size) {return  new Unggah[size];}
    };


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }


    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String checkIn) {
        CheckIn = checkIn;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String checkOut) {
        CheckOut = checkOut;
    }
}

