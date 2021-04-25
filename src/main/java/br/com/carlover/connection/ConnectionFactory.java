package br.com.carlover.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static final String CARLOVER_PERSISTENCE_UNIT = "carlover-persistence-unit";

    private static EntityManagerFactory factory;

    public static EntityManager getConnection() {
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(CARLOVER_PERSISTENCE_UNIT);

        return factory.createEntityManager();
    }

    private ConnectionFactory() {
    }
}
