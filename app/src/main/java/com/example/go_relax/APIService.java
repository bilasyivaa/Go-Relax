package com.example.go_relax;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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
    Call<ValueNoData> addGoRelax(@Field("Nama") String Nama,
                                 @Field("Alamat") String Alamat,
                                 @Field("Number") String Number,
                                 @Field("Info") Integer Info,
                                 @Field("CheckIn") Integer CheckIn,
                                 @Field("CheckOut") Integer CheckOut,
                                 @Field("User_id") Integer User_id);

    @FormUrlEncoded
    @PUT("GoRelax")
    Call<ValueNoData> updateUnggah(@Field("Nama") String Nama,
                                 @Field("Alamat") String Alamat,
                                 @Field("Number") String Number,
                                 @Field("Info") Integer Info,
                                 @Field("CheckIn") Integer CheckIn,
                                 @Field("CheckOut") Integer CheckOut,
                                 @Field("User_id") int User_id);

    @DELETE("GoRelax/{id}")
    Call<ValueNoData> deleteUnggah(@Path("id") String id);

    Call<ValueNoData> getGoRelax(String id, String nama, String alamat, int number, int info, int checkin, int checkout);
}
