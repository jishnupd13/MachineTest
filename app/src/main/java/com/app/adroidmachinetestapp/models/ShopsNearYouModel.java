package com.app.adroidmachinetestapp.models;

public class ShopsNearYouModel {
    int shopId;
    String shopName;
    int drawableImage;

    public ShopsNearYouModel(int shopId, String shopName, int drawableImage) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.drawableImage = drawableImage;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }
}
