package com.app.adroidmachinetestapp.models;

public class HotDealsModel {
    int hotDealsId;
    int drawableImage;

    public HotDealsModel(int hotDealsId, int drawableImage) {
        this.hotDealsId = hotDealsId;
        this.drawableImage = drawableImage;
    }

    public int getHotDealsId() {
        return hotDealsId;
    }

    public void setHotDealsId(int hotDealsId) {
        this.hotDealsId = hotDealsId;
    }

    public int getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(int drawableImage) {
        this.drawableImage = drawableImage;
    }
}
