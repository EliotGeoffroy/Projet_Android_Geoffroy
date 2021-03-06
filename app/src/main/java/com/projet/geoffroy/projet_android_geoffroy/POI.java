package com.projet.geoffroy.projet_android_geoffroy;

public class POI {
    private String type;
    private String display;
    private Double distance;
    private String image;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public POI(String type, String display, Double distance, String image) {
        this.type = type;
        this.display = display;
        this.distance = distance;
        this.image = image;
    }
}
