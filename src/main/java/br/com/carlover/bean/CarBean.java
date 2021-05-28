package br.com.carlover.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.carlover.connection.ConnectionFactory;
import br.com.carlover.dao.CarDao;
import br.com.carlover.dao.impl.CarDaoImpl;
import br.com.carlover.exception.CommitTransactionException;
import br.com.carlover.model.Car;
import br.com.carlover.model.User;

@Named // CDI -> não usar ManagedBean
// Escopo Default do CDI -> ViewScope
@RequestScoped
public class CarBean {

    private Car car = new Car();

    private CarDao dao = new CarDaoImpl(ConnectionFactory.getConnection());

    public void save() {
        FacesContext context = FacesContext.getCurrentInstance();
        User user = (User) context.getExternalContext().getSessionMap().get("user");
        this.car.setUser(user);

        dao.save(this.car);
        try {
            dao.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully registered"));
        } catch (CommitTransactionException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }

    public List<Car> getCars() {
        return dao.findAll();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
