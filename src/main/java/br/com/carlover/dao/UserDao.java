package br.com.carlover.dao;

import br.com.carlover.model.User;

public interface UserDao extends Persisted<User, Long> {

    boolean exists(User user);
}
