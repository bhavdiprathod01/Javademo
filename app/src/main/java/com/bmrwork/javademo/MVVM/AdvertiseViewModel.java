package com.bmrwork.javademo.MVVM;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bmrwork.javademo.DB.AdvertiseEntity;

import java.util.List;

// AdvertiseViewModel.java
// AdvertiseViewModel.java
public class AdvertiseViewModel extends AndroidViewModel {
    private AdvertiseRepository repository;
    private LiveData<List<AdvertiseEntity>> allAdvertise;
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public AdvertiseViewModel(@NonNull Application application) {
        super(application);
        repository = new AdvertiseRepository(application);
        allAdvertise = repository.getAllAdvertise();
        loadData();
    }

    public LiveData<List<AdvertiseEntity>> getAllAdvertise() {
        return allAdvertise;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void loadData() {
        repository.refreshAdvertiseData();
    }
}