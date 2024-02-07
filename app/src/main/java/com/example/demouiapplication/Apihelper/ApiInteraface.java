package com.example.demouiapplication.Apihelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInteraface {

    @GET("/v1/search")
    Call<Model>getcityname(@Query("name") String name);

//    @GET("/v1/search")
//    Call<ResponseBody>getcityname(@Query("name") String name);


}
