package br.com.carlover.bean;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.carlover.connection.ConnectionFactory;
import br.com.carlover.dao.UserDao;
import br.com.carlover.dao.impl.UserDaoImpl;
import br.com.carlover.exception.CommitTransactionException;
import br.com.carlover.model.User;

@Named
@RequestScoped
public class UserBean {

    private User user = new User();

    private UserDao dao = new UserDaoImpl(ConnectionFactory.getConnection());

    private final LocalDate minDate = LocalDate.of(1900, 1, 1);

    public void save() {
        dao.save(this.user);
        try {
            dao.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully registered"));
        } catch (CommitTransactionException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }

    public String login() {
        boolean exist = dao.exists(user);

        if (exist) {
            return "index?faces-redirect=true";
        }

        FacesContext context = FacesContext.getCurrentInstance();

        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Login inválido"));

        return "login?faces-redirect=true";
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
