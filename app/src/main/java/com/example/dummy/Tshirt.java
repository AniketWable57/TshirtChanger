package com.example.dummy;

public class Tshirt {
    private final String name;
    private final String size;
    private final String style;
    private final double price;
    private final int imageResourceId;

    public Tshirt(String name, String size, String style, double price, int imageResourceId) {
        this.name = name;
        this.size = size;
        this.style = style;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getStyle() {
        return style;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
