package com.example.mytestapp;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RetrofitInstance {
    public  static String URl="http://beautyclub.nyesteventuretech.com/";
    public static Retrofit retrofit;
    public  static  Retrofit getInstance(){
        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(URl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
