package com.example.go_relax;

import android.os.Parcel;
import android.os.Parcelable;

public class Unggah implements Parcelable{
    private String Id;

    private String Nama;
    private String Alamat;
    private Integer Number;
    private Integer Info;
    private Integer check_in;
    private Integer check_out;
    private String user_id;

    protected Unggah(Parcel in) {
        Id = in.readString();
        Nama = in.readString();
        Alamat = in.readString();
        Number = in.readInt();
        Info = in.readInt();
        check_in = in.readInt();
        check_out = in.readInt();
        user_id = in.readString();
    }

    @Override
    public void  writeToParcel(Parcel dest, int flags) {
        dest.writeString(Id);
        dest.writeString(Nama);
        dest.writeString(Alamat);
        dest.writeInt(Number);
        dest.writeInt(Info);
        dest.writeInt(check_in);
        dest.writeInt(check_out);
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

    public void setId(String Id) {
        Id = Id;
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

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public Integer getInfo() {
        return Info;
    }

    public void setInfo(Integer info) {
        Info = info;
    }

    public Integer getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Integer check_in) {
        this.check_in = check_in;
    }

    public Integer getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Integer check_out) {
        this.check_out = check_out;
    }


}

