package fr.diginamic.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class EntityManagerFactoryProvider {
    private static final Map<String, EntityManagerFactory> emfs= new HashMap<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> emfs.values().forEach(EntityManagerFactory::close)));
    }

    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName) {
        if (null == emfs.get(persistenceUnitName)) {
            emfs.put(persistenceUnitName, Persistence.createEntityManagerFactory(persistenceUnitName));
        }
        return emfs.get(persistenceUnitName);
    }

    /* Prevent the class EntityManagerFactoryProvider from being instantiated. */
    private EntityManagerFactoryProvider() {}
}
