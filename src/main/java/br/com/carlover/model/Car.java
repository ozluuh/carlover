package br.com.carlover.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLR_CAR")
public class Car {

    @Id
    @Column(name = "id_car")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_model", length = 125, nullable = false)
    private String model;

    @Column(name = "ds_brand", length = 30, nullable = false)
    private String brand;

    @Column(name = "ds_car")
    private String description;

    @Column(name = "vl_car", nullable = false)
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
