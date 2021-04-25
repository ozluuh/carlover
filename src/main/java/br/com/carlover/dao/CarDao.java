package br.com.carlover.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.carlover.connection.ConnectionFactory;
import br.com.carlover.model.Car;

public class CarDao {

    public void save(Car car) {
        EntityManager manager = ConnectionFactory.getConnection();

        manager.getTransaction().begin();
        manager.persist(car);
        manager.getTransaction().commit();
        manager.close();
    }

    public List<Car> getAll() {
        EntityManager manager = ConnectionFactory.getConnection();
        String jpql = "SELECT c from Car c";

        return manager.createQuery(jpql, Car.class).getResultList();
    }

}
