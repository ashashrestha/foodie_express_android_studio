package com.ocem.foodieexpress.domain;

public class ColdBeverageDomain {
    private String heading;
    protected String titleImage;

    private String plate;
    private   String CNrs;

    public ColdBeverageDomain(String heading, String titleImage, String plate, String CNrs){
        this.heading = heading;
        this.titleImage = titleImage;
        this.plate = plate;
        this.CNrs = CNrs;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCNrs() {
        return CNrs;
    }

    public void setCNrs(String CNrs) {
        this.CNrs = CNrs;
    }
}
