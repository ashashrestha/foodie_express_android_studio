package com.ocem.foodieexpress.domain;

public class NVRDemo {
    protected String RestroLogo;
    private String RestroNAme;
    private   String RestroAdd;
    protected String AddLogo;
    private   String DeliveryHrs;

    public NVRDemo(String restroLogo, String restroNAme, String restroAdd, String addLogo, String deliveryHrs) {
        RestroLogo = restroLogo;
        RestroNAme = restroNAme;
        RestroAdd = restroAdd;
        AddLogo = addLogo;
        DeliveryHrs = deliveryHrs;
    }

    public String getRestroLogo() {
        return RestroLogo;
    }

    public void setRestroLogo(String restroLogo) {
        RestroLogo = restroLogo;
    }

    public String getRestroNAme() {
        return RestroNAme;
    }

    public void setRestroNAme(String restroNAme) {
        RestroNAme = restroNAme;
    }

    public String getRestroAdd() {
        return RestroAdd;
    }

    public void setRestroAdd(String restroAdd) {
        RestroAdd = restroAdd;
    }

    public String getAddLogo() {
        return AddLogo;
    }

    public void setAddLogo(String addLogo) {
        AddLogo = addLogo;
    }

    public String getDeliveryHrs() {
        return DeliveryHrs;
    }

    public void setDeliveryHrs(String deliveryHrs) {
        DeliveryHrs = deliveryHrs;
    }
}
