package br.com.carlover.dao.impl;

import javax.persistence.EntityManager;

import br.com.carlover.dao.CarDao;
import br.com.carlover.model.Car;

public class CarDaoImpl extends PersistedImpl<Car, Long> implements CarDao {

    public CarDaoImpl(EntityManager manager) {
        super(manager);
    }

}
