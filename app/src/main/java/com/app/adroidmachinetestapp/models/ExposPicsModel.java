package com.app.adroidmachinetestapp.models;

import android.graphics.drawable.Drawable;

public class ExposPicsModel {
    int id;
    String FoodName;
    String FoodSubHeading;
    String FoodTime;
    int drawable;

    public ExposPicsModel(int id, String foodName, String foodSubHeading, String foodTime, int drawable) {
        this.id = id;
        FoodName = foodName;
        FoodSubHeading = foodSubHeading;
        FoodTime = foodTime;
        this.drawable = drawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getFoodSubHeading() {
        return FoodSubHeading;
    }

    public void setFoodSubHeading(String foodSubHeading) {
        FoodSubHeading = foodSubHeading;
    }

    public String getFoodTime() {
        return FoodTime;
    }

    public void setFoodTime(String foodTime) {
        FoodTime = foodTime;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
