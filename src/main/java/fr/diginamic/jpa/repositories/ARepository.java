package fr.diginamic.jpa.repositories;

import fr.diginamic.entities.ABaseEntity;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Function;

public abstract class ARepository<T extends ABaseEntity> {
    private static final String FIND_ALL = "SELECT e FROM %s e";
    private static final String FIND_ONE = "SELECT e FROM %s e WHERE ID=:id";
    private final EntityManager em = EntityManagerProvider.getEntityManager("demo-jpa");

    public abstract ARepository<T> getInstance();
    protected abstract Class<T> getEntityType();
    protected  abstract Logger getLogger();

    private <R> R doWithEm(Function<EntityManager, R> fn) {
        return fn.apply(em);
    }

    private <R> R doWithTransaction(Function<EntityManager, R> fn) {
        return doWithEm(em -> {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            R result = fn.apply(em);
            tx.commit();
            return result;
        });
    }

    public List<T> findAll() {
        Class<T> entityType = getEntityType();
        String qlString = String.format(FIND_ALL, entityType.getSimpleName());
        return doWithEm(em -> em.createQuery(qlString, entityType).getResultList());
    }

    public T findById(int id) {
        Class<T> entityType = getEntityType();
        String qlString = String.format(FIND_ONE, entityType);
        return doWithTransaction(em -> {
            TypedQuery<T> query = em.createQuery(qlString, entityType);
            query.setParameter("id", id);
            return query.getSingleResult();
        });
    }

    public void persist(T entity) {
        doWithTransaction(em -> {
            em.persist(entity);
            return entity;
        });
        getLogger().info("New {} added with id: {}", getEntityType().getSimpleName(), entity.getId());
    }

    public void delete(T entity) {
        doWithTransaction(em -> {
            em.remove(entity);
            return entity;
        });
    }
}
