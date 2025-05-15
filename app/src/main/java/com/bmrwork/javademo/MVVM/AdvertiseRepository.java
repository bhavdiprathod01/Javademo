package com.bmrwork.javademo.MVVM;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.bmrwork.javademo.DB.AdvertiseEntity;
import com.bmrwork.javademo.DB.AdvertiseDao;
import com.bmrwork.javademo.DB.AppDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
// AdvertiseRepository.java
// AdvertiseRepository.java
public class AdvertiseRepository {
    private ApiService apiService;
    private AdvertiseDao advertiseDao;
    private Executor executor;

    public AdvertiseRepository(Application application) {
        apiService = RetrofitClient.getClient().create(ApiService.class);
        AppDatabase db = AppDatabase.getDatabase(application);
        advertiseDao = db.advertiseDao();
        executor = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<AdvertiseEntity>> getAllAdvertise() {
        return advertiseDao.getAllAdvertise();
    }

    public void refreshAdvertiseData() {
        executor.execute(() -> {
            // Check if data exists in DB
            boolean hasData = advertiseDao.getAllAdvertise().getValue() != null &&
                    !advertiseDao.getAllAdvertise().getValue().isEmpty();

            // Always fetch fresh data but show cached data first if available
            Call<ApiResponse> call = apiService.getAdvertiseData();
            call.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        executor.execute(() -> {
                            // Clear old data
                            advertiseDao.deleteAll();

                            // Process and insert new data
                            List<AdvertiseEntity> entities = new ArrayList<>();

                            // Process data section
                            if (response.body().getData() != null) {
                                for (AdvertiseModel model : response.body().getData()) {
                                    entities.add(new AdvertiseEntity(
                                            model.getName(),
                                            model.getThumb_image(),
                                            model.getApp_link(),
                                            model.getPackage_name()
                                    ));
                                }
                            }

                            // Process app_center sections
                            if (response.body().getApp_center() != null) {
                                for (ApiResponse.AppCenter appCenter : response.body().getApp_center()) {
                                    if (appCenter.getSub_category() != null) {
                                        for (ApiResponse.SubCategory subCategory : appCenter.getSub_category()) {
                                            entities.add(new AdvertiseEntity(
                                                    subCategory.getName(),
                                                    subCategory.getIcon(),
                                                    subCategory.getApp_link(),
                                                    "" // package name might not be available here
                                            ));
                                        }
                                    }
                                }
                            }

                            // Insert all entities
                            advertiseDao.insert(entities);
                        });
                    }
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    // Failure handled by observing LiveData in ViewModel
                }
            });
        });
    }
}