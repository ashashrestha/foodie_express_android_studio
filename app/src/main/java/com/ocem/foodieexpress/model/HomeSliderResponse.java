package com.ocem.foodieexpress.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ocem.foodieexpress.model.HomeSlider;

import java.util.List;

public class HomeSliderResponse {
        @SerializedName("status")
        @Expose
        private Boolean status;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("data")
        @Expose
        private List<HomeSlider> data;

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<HomeSlider> getData() {
            return data;
        }

        public void setData(List<HomeSlider> data) {
            this.data = data;
        }
}
