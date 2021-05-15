package br.com.carlover.dao;

import java.util.List;

import br.com.carlover.exception.CommitTransactionException;

public interface Persisted<E, K> {

    /**
     * Persist entity
     *
     * @param entity entity instance
     */
    void save(E entity);

    /**
     * Update the entity
     *
     * @param entity entity instance
     */
    void update(E entity);

    /**
     * Find entity by id
     *
     * @param key id
     * @return entity instance or null if not found
     */
    E findById(K key);

    /**
     * Find all entity
     *
     * @return list of entities
     */
    List<E> findAll();

    /**
     * Delete managed entity
     *
     * @param key key to remove
     */
    void delete(K key);

    /**
     * Commit transaction
     */
    void commit() throws CommitTransactionException;
}
