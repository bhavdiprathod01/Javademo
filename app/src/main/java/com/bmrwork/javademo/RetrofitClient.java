package com.bmrwork.javademo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
// RetrofitClient.java
public class RetrofitClient {
    private static final String BASE_URL = "https://vasundharaapps.com/artwork_apps/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}