package br.com.carlover.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.carlover.connection.ConnectionFactory;
import br.com.carlover.model.User;

public class UserDao {

    public void save(User user) {
        EntityManager manager = ConnectionFactory.getConnection();

        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();

    }

    public List<User> getAll() {
        EntityManager manager = ConnectionFactory.getConnection();
        String jpql = "SELECT u FROM User u";

        return manager.createQuery(jpql, User.class).getResultList();
    }

}
