package fr.diginamic.banque.repositories;

import fr.diginamic.banque.entities.Virement;
import fr.diginamic.jpa.ARepository;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirementRepository extends ARepository<Virement> {
    private static final Logger LOG = LoggerFactory.getLogger( VirementRepository.class );
    private static VirementRepository instance;

    public static VirementRepository getInstance() {
        if (null == instance) {
            instance = new VirementRepository();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("banque");

    private VirementRepository() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Virement> getEntityType() {
        return Virement.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
