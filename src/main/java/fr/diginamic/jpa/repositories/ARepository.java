package fr.diginamic.jpa.repositories;

import fr.diginamic.DataException;
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

    protected abstract Class<T> getEntityType();
    protected  abstract Logger getLogger();

    protected <R> R doWithEm(Function<EntityManager, R> fn) {
        return fn.apply(em);
    }

    protected <R> R doWithTransaction(Function<EntityManager, R> fn) {
        return doWithEm(em -> {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            R result = fn.apply(em);
            tx.commit();
            return result;
        });
    }

    private void persist(T entity) {
        doWithTransaction(em -> {
            em.persist(entity);
            return entity;
        });
    }

    public List<T> findAll() {
        Class<T> entityType = getEntityType();
        String qlString = String.format(FIND_ALL, entityType.getSimpleName());
        List<T> entities = doWithEm(em -> em.createQuery(qlString, entityType).getResultList());
        entities.forEach(T::trackNotNew);
        return entities;
    }

    public T findById(int id) {
        Class<T> entityType = getEntityType();
        String qlString = String.format(FIND_ONE, entityType.getSimpleName());
        T entity = doWithEm(em -> {
            TypedQuery<T> query = em.createQuery(qlString, entityType);
            query.setParameter("id", id);
            return query.getSingleResult();
        });
        entity.trackNotNew();
        return entity;
    }

    public T findReferenceById(int id) {
        T entity = doWithEm(em -> em.getReference(getEntityType(), id));
        entity.trackNotNew();
        return entity;
    }

    public void create(T entity) {
        if (!entity.isNew()) {
            throw new DataException("Entity of type " + getEntityType().getSimpleName() +
                    " with id " + entity.getId() +
                    " already exist.");
        }
        persist(entity);
        entity.trackNotNew();
        getLogger().info("New {} added with id: {}", getEntityType().getSimpleName(), entity.getId());
    }

    public void update(T entity) {
        if (entity.isNew()) {
            throw new DataException("Entity of type " + getEntityType().getSimpleName() +
                    " with id " + entity.getId() +
                    " is new and can't be updated. It must be created first with create(...)");
        }
        persist(entity);
        getLogger().info("Entity of type {} with id {} updated", getEntityType().getSimpleName(), entity.getId());
    }

    public void delete(T entity) {
        doWithTransaction(em -> {
            em.remove(entity);
            return entity;
        });
        getLogger().info("Entity of type {} with id {} deleted", getEntityType().getSimpleName(), entity.getId());
    }
}
