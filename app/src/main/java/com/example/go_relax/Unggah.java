package com.example.go_relax;

public class Unggah {
    private String Id;

    private String Nama;
    private String Alamat;
    private Integer Number;
    private Integer Info;
    private Integer check_in;
    private Integer check_out;


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

