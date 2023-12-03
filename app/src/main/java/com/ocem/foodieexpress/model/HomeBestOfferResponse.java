package com.ocem.foodieexpress.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ocem.foodieexpress.model.HomeBestOffer;

import java.util.List;

public class HomeBestOfferResponse {
    @SerializedName("data")
    @Expose
    private List<HomeBestOffer> data;

    public List<HomeBestOffer> getData() {
        return data;
    }

    public void setData(List<HomeBestOffer> data) {
        this.data = data;
    }
}
