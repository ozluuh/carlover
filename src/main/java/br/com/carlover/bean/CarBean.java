package br.com.carlover.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.carlover.connection.ConnectionFactory;
import br.com.carlover.dao.CarDao;
import br.com.carlover.model.Car;

@Named // CDI -> não usar ManagedBean
//Escopo Default do CDI -> ViewScope
@RequestScoped
public class CarBean {

    private Car car = new Car();

    private CarDao dao = new CarDao(ConnectionFactory.getConnection());

    public void save() {
        dao.save(this.car);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully registered"));
    }

    public List<Car> getCars(){
        return dao.getAll();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
