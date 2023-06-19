package fr.diginamic.banque.repositories;

import fr.diginamic.banque.entities.Operation;
import fr.diginamic.jpa.ARepository;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperationRepository extends ARepository<Operation> {
    private static final Logger LOG = LoggerFactory.getLogger( OperationRepository.class );
    private static OperationRepository instance;

    public static OperationRepository getInstance() {
        if (null == instance) {
            instance = new OperationRepository();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("banque");

    private OperationRepository() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Operation> getEntityType() {
        return Operation.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
