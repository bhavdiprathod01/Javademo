package com.bmrwork.javademo.MVVM;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("AdvertiseNewApplications/17/com.hd.camera.apps.high.quality")
    Call<ApiResponse> getAdvertiseData();
}