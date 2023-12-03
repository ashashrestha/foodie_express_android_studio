package com.ocem.foodieexpress.model.BestFood;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BestFoodResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<BestFood> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BestFood> getData() {
        return data;
    }

    public void setData(List<BestFood> data) {
        this.data = data;
    }
}
