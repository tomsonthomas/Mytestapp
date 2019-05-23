package com.example.mytestapp;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiInterface {
    @POST("android/getTable.php")
    @FormUrlEncoded
    Call<Model>getData(@Field("table")String name);
}
