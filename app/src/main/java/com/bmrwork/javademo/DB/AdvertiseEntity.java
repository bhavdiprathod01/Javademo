package com.bmrwork.javademo.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// AdvertiseEntity.java
@Entity(tableName = "advertise_table")
public class AdvertiseEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String thumbImage;
    private String appLink;
    private String packageName;

    // Constructor
    public AdvertiseEntity(String name, String thumbImage, String appLink, String packageName) {
        this.name = name;
        this.thumbImage = thumbImage;
        this.appLink = appLink;
        this.packageName = packageName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public String getAppLink() {
        return appLink;
    }

    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}