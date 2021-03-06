package br.com.carlover.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.carlover.dao.UserDao;
import br.com.carlover.model.User;

public class UserDaoImpl extends PersistedImpl<User, Long> implements UserDao {

    public UserDaoImpl(EntityManager manager) {
        super(manager);
    }

    @Override
    public boolean exists(User user) {
        TypedQuery<User> q = manager.createQuery("select u from User u where u.mail = :mail and u.password = :pass",
                User.class);
        q.setParameter("mail", user.getMail());
        q.setParameter("pass", user.getPassword());
        try {
            q.getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    @Override
    public User findByMailAndPassword(User user) {
        return manager
                .createQuery("from User u where u.mail = :mail and u.password = :pass", User.class)
                .setParameter("mail", user.getMail())
                .setParameter("pass", user.getPassword())
                .getSingleResult();
    }
}
