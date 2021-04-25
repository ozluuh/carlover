package br.com.carlover.model;

import java.math.BigDecimal;

public class Car {
    
    private String model;
    
    private String brand;
    
    private String description;
    
    private BigDecimal price;

    @Override
    public String toString() {
        return "Car [model=" + model + ", brand=" + brand + ", description=" + description + ", price=" + price + "]";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
