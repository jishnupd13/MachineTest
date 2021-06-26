package com.app.adroidmachinetestapp.models;

public class ProductStoryModel {

    int productId;
    String productName;
    int drawableImage;

    public ProductStoryModel(int productId, String productName, int drawableImage) {
        this.productId = productId;
        this.productName = productName;
        this.drawableImage = drawableImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }
}
