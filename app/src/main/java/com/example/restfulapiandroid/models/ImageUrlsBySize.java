package com.example.restfulapiandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageUrlsBySize {

    @SerializedName("90")
    @Expose
    private String _90;

    public ImageUrlsBySize(String _90) {
        this._90 = _90;
    }

    public String get_90() {
        return _90;
    }

    public void set_90(String _90) {
        this._90 = _90;
    }
}
