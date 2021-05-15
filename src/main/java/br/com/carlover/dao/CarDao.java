package br.com.carlover.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.carlover.model.Car;

public class CarDao {

    private EntityManager manager;

    public CarDao(EntityManager connectionInstance) {
        this.manager = connectionInstance;
    }

    public void save(Car car) {
        manager.getTransaction().begin();
        manager.persist(car);
        manager.getTransaction().commit();
        manager.close();
    }

    public List<Car> getAll() {
        String jpql = "SELECT c from Car c";

        return manager.createQuery(jpql, Car.class).getResultList();
    }

    public Car findById(Long id) {
        return manager.find(Car.class, id);
    }

    public void update(Car car) {
        manager.getTransaction().begin();
        manager.merge(car);
        manager.flush();
        manager.getTransaction().commit();
        manager.close();
    }

    public void delete(Car car) {
        manager.remove(car);
    }

}
