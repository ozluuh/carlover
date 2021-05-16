package br.com.carlover.dao.impl;

import javax.persistence.EntityManager;

import br.com.carlover.dao.UserDao;
import br.com.carlover.model.User;

public class UserDaoImpl extends PersistedImpl<User, Long> implements UserDao {

    public UserDaoImpl(EntityManager manager) {
        super(manager);
    }
}
