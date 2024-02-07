package com.example.demouiapplication;

import com.example.demouiapplication.Apihelper.ApiInteraface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public   class RetrofitInstance {
   public static RetrofitInstance instance;
    String url = "https://jsonplaceholder.typicode.com/photos/";
    ApiInteraface apiInterface;

    RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInteraface.class);
    }


    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();

        }
        return instance;
    }



}
