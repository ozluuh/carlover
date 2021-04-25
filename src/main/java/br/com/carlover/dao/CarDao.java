package br.com.carlover.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.carlover.model.Car;

public class CarDao {

    public void save(Car car) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("carlover-persistence-unit");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(car);
        manager.getTransaction().commit();
        manager.close();
    }

}
