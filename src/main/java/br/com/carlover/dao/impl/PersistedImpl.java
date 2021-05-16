package br.com.carlover.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;

import br.com.carlover.dao.Persisted;
import br.com.carlover.exception.CommitTransactionException;

public abstract class PersistedImpl<E, K> implements Persisted<E, K> {

    protected EntityManager manager;
    private Class<E> clazz;

    @SuppressWarnings("unchecked")
    public PersistedImpl(EntityManager manager) {
        this.manager = manager;
        clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(E entity) {
        manager.persist(entity);
    }

    @Override
    public void update(E entity) {
        manager.merge(entity);
    }

    @Override
    public E findById(K key) {
        return manager.find(clazz, key);
    }

    @Override
    public List<E> findAll() {
        return manager.createQuery("from " + clazz.getName(), clazz).getResultList();
    }

    @Override
    public void delete(K key) throws EntityNotFoundException {
        E entity = findById(key);
        if(entity == null){
            throw new EntityNotFoundException();
        }
        manager.remove(entity);
    }

    @Override
    public void commit() throws CommitTransactionException {
        EntityTransaction trx = null;

        try {
            trx = manager.getTransaction();
            trx.begin();
            manager.flush();
            trx.commit();
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();
            }
            throw new CommitTransactionException();
        }

    }

}
