package br.com.carlover.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.carlover.dao.CarDao;
import br.com.carlover.model.Car;

@ManagedBean
public class CarBean {

    private Car car = new Car();

    public void save() {
        new CarDao().save(this.car);
        System.out.println("salvando..." + this.car);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully registered"));
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
