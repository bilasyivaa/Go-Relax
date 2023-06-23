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



    @GET("addGoRelax")
    Call<ValueData<List<Unggah>>> getGoRelax();

    @FormUrlEncoded
    @POST("addGoRelax")
    Call<ValueNoData> addGoRelax(@Field("user_id") String User_id,
                                 @Field("Nama") String Nama,
                                 @Field("Alamat") String Alamat,
                                 @Field("Number") String Number,
                                 @Field("Info") String Info,
                                 @Field("CheckIn") String CheckIn,
                                 @Field("CheckOut") String CheckOut);


    @FormUrlEncoded
    @PUT("addGoRelax")
    Call<ValueNoData> updateUnggah(@Field("id") String id,
                                   @Field("Nama") String Nama,
                                   @Field("Alamat") String Alamat,
                                   @Field("Number") String Number,
                                   @Field("Info") String Info,
                                   @Field("CheckIn") String CheckIn,
                                   @Field("CheckOut") String CheckOut);


    @DELETE("addGoRelax/{id}")
    Call<ValueNoData> deleteUnggah(@Path("id") String id);

}
