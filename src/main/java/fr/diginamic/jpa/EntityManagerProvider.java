package fr.diginamic.jpa;

import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

public class EntityManagerProvider {
    private static final Map<String, EntityManager> ems = new HashMap<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> ems.values().forEach(EntityManager::close)));
    }

    public static EntityManager getEntityManager(String persistenceUnitName) {
        if (null == ems.get(persistenceUnitName)) {
            ems.put(persistenceUnitName, EntityManagerFactoryProvider.getEntityManagerFactory(persistenceUnitName).createEntityManager());
        }
        return  ems.get(persistenceUnitName);
    }

    private EntityManagerProvider() {}
}
