package com.bmrwork.javademo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

// AdvertiseDao.java
@Dao
public interface AdvertiseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<AdvertiseEntity> advertiseEntities);

    @Query("DELETE FROM advertise_table")
    void deleteAll();

    @Query("SELECT * FROM advertise_table ORDER BY name ASC")
    LiveData<List<AdvertiseEntity>> getAllAdvertise();
}