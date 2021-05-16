package br.com.carlover.bean;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.carlover.dao.UserDao;
import br.com.carlover.model.User;

@Named
@RequestScoped
public class UserBean {

    private User user = new User();

    private UserDao dao = new UserDaoImpl(ConnectionFactory.getConnection());

    private final LocalDate minDate = LocalDate.of(1900, 1, 1);

    public void save() {
        new UserDao().save(this.user);
        System.out.println("Saving: " + this.user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully registered"));
    }

    public List<User> getUsers() {
        return dao.findAll();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getMinDate() {
        return minDate;
    }
}
