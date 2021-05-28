package br.com.carlover.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.carlover.dao.CarDao;
import br.com.carlover.model.Car;
import br.com.carlover.model.User;

public class CarDaoImpl extends PersistedImpl<Car, Long> implements CarDao {

    public CarDaoImpl(EntityManager manager) {
        super(manager);
    }

    @Override
    public List<Car> findByUserId(User user) {
        return manager
                .createQuery("from Car c where c.user.id = :id", Car.class)
                .setParameter("id", user.getId())
                .getResultList();
    }

}
