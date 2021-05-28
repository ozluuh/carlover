package br.com.carlover.dao;

import java.util.List;

import br.com.carlover.model.Car;
import br.com.carlover.model.User;

public interface CarDao extends Persisted<Car, Long> {

    List<Car> findByUserId(User user);
}
