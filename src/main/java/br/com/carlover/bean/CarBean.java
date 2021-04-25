package br.com.carlover.bean;

import javax.faces.bean.ManagedBean;

import br.com.carlover.model.Car;

@ManagedBean
public class CarBean {

    private Car car = new Car();

    public void save() {
        System.out.println("salvando..." + this.car);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
