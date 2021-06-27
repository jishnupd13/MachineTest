package com.app.adroidmachinetestapp.models;

public class AdvertisementModel {

    int id;
    int advertisementImage1;
    int advertisementImage2;

    public AdvertisementModel(int id, int advertisementImage1, int advertisementImage2) {
        this.id = id;
        this.advertisementImage1 = advertisementImage1;
        this.advertisementImage2 = advertisementImage2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdvertisementImage1() {
        return advertisementImage1;
    }

    public void setAdvertisementImage1(int advertisementImage1) {
        this.advertisementImage1 = advertisementImage1;
    }

    public int getAdvertisementImage2() {
        return advertisementImage2;
    }

    public void setAdvertisementImage2(int advertisementImage2) {
        this.advertisementImage2 = advertisementImage2;
    }
}
