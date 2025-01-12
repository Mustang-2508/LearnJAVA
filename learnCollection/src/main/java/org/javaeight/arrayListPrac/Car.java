package org.javaeight.arrayListPrac;

public class Car {
    private String model;
    private String color;
    private Double milage;

    public Car(String model, String color, Double milage) {
        this.model = model;
        this.color = color;
        this.milage = milage;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Double getMilage() {
        return milage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", milage=" + milage +
                '}';
    }
}
