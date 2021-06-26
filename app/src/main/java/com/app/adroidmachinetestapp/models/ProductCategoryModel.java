package com.app.adroidmachinetestapp.models;

public class ProductCategoryModel {
    int categoryId;
    String categoryName;
    int drawableImage;

    public ProductCategoryModel(int categoryId, String categoryName, int drawableImage) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.drawableImage = drawableImage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }
}
