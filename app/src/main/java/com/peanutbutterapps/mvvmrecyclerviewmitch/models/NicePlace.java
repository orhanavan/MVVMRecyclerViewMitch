package com.peanutbutterapps.mvvmrecyclerviewmitch.models;

public class NicePlace {

    private String title;
    private String imageUrl;

    public NicePlace(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public NicePlace() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
