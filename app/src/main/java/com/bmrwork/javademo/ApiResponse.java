package com.bmrwork.javademo;

import com.google.gson.annotations.SerializedName;
import java.util.List;
public class ApiResponse {
    private int status;
    private String message;
    private List<AdvertiseModel> data;
    private List<AppCenter> app_center;
    private List<Home> home;
    private List<MoreApps> more_apps;
    private NativeAdd native_add;
    private TranslatorAdsId translator_ads_id;

    // Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AdvertiseModel> getData() {
        return data;
    }

    public void setData(List<AdvertiseModel> data) {
        this.data = data;
    }

    public List<AppCenter> getApp_center() {
        return app_center;
    }

    public void setApp_center(List<AppCenter> app_center) {
        this.app_center = app_center;
    }

    public List<Home> getHome() {
        return home;
    }

    public void setHome(List<Home> home) {
        this.home = home;
    }

    public List<MoreApps> getMore_apps() {
        return more_apps;
    }

    public void setMore_apps(List<MoreApps> more_apps) {
        this.more_apps = more_apps;
    }

    public NativeAdd getNative_add() {
        return native_add;
    }

    public void setNative_add(NativeAdd native_add) {
        this.native_add = native_add;
    }

    public TranslatorAdsId getTranslator_ads_id() {
        return translator_ads_id;
    }

    public void setTranslator_ads_id(TranslatorAdsId translator_ads_id) {
        this.translator_ads_id = translator_ads_id;
    }

    public static class AppCenter {
        private String name;
        private List<SubCategory> sub_category;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubCategory> getSub_category() {
            return sub_category;
        }

        public void setSub_category(List<SubCategory> sub_category) {
            this.sub_category = sub_category;
        }
    }

    public static class SubCategory {
        private String name;
        private String icon;
        private String app_link;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getApp_link() {
            return app_link;
        }

        public void setApp_link(String app_link) {
            this.app_link = app_link;
        }
    }

    public static class Home {
        private String name;
        private List<SubCategory> sub_category;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubCategory> getSub_category() {
            return sub_category;
        }

        public void setSub_category(List<SubCategory> sub_category) {
            this.sub_category = sub_category;
        }
    }

    public static class MoreApps {
        private String name;
        private List<SubCategory> sub_category;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubCategory> getSub_category() {
            return sub_category;
        }

        public void setSub_category(List<SubCategory> sub_category) {
            this.sub_category = sub_category;
        }
    }

    public static class NativeAdd {
        private String image;
        private String playstore_link;

        // Getters and setters
        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPlaystore_link() {
            return playstore_link;
        }

        public void setPlaystore_link(String playstore_link) {
            this.playstore_link = playstore_link;
        }
    }

    public static class TranslatorAdsId {
        private String banner;
        private String interstitial;

        // Getters and setters
        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public String getInterstitial() {
            return interstitial;
        }

        public void setInterstitial(String interstitial) {
            this.interstitial = interstitial;
        }
    }
}