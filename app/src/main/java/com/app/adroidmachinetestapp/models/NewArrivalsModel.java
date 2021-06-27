package com.app.adroidmachinetestapp.models;

public class NewArrivalsModel {

    int productId;
    String productName;
    String productSubHeading;
    int drawableImage;

    public NewArrivalsModel(int productId, String productName, String productSubHeading, int drawableImage) {
        this.productId = productId;
        this.productName = productName;
        this.productSubHeading = productSubHeading;
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

    public String getProductSubHeading() {
        return productSubHeading;
    }

    public void setProductSubHeading(String productSubHeading) {
        this.productSubHeading = productSubHeading;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }
}
