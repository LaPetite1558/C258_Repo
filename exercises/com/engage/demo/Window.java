package com.engage.demo;

public class Window {
    private float height;
    private float width;

    public Window(float height, float width) {
        setHeight(height);
        setWidth(width);
    }

    public float getArea() {
        return getHeight() * getWidth();
    }

    public float getPerimeter() {
        return (getHeight() * 2) + (getWidth() * 2);
    }

    public float getTotalCost() {
        float glassCost = 3.50f * getArea();
        float trimCost = 2.25f * getPerimeter();
        return glassCost + trimCost;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
