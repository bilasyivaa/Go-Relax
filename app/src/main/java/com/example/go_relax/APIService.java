package com.example.go_relax;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>> login(@Field("username") String username,
                                @Field("password") String password);
    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>> register(@Field("username") String username,
                                @Field("password") String password);



    @FormUrlEncoded
    @GET("GoRelax")
    Call<ValueData<List<Unggah>>> getGoRelax();

    @FormUrlEncoded
    @POST("GoRelax")
    Call<ValueData> addGoRelax(@Field("Nama") String Nama,
                               @Field("Alamat") String Alamat,
                               @Field("Number") String Number,
                               @Field("Info") String Info,
                               @Field("CheckIn") String CheckIn,
                               @Field("CheckOut") String CheckOut,
                               @Field("User_id") String User_id);

}
