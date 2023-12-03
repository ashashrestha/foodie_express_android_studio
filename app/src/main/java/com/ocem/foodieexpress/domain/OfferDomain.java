package com.ocem.foodieexpress.domain;

import androidx.annotation.NonNull;

import java.util.stream.IntStream;

public class OfferDomain implements CharSequence {

    protected String pic;
    private String title;
    private   String food;
    private String amount;
    private   String offerP;
    private   String price;
    private String offer;


    public OfferDomain(String pic, String title, String food, String amount, String offerP, String price, String offer) {
        this.pic = pic;
        this.title = title;
        this.food = food;
        this.amount = amount;
        this.offerP = offerP;
        this.price = price;
        this.offer = offer;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOfferP() {
        return offerP;
    }

    public void setOfferP(String offerP) {
        this.offerP = offerP;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @NonNull
    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @NonNull
    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @NonNull
    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }
}
