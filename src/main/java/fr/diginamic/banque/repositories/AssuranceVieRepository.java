package fr.diginamic.banque.repositories;

import fr.diginamic.banque.entities.AssuranceVie;
import fr.diginamic.jpa.ARepository;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssuranceVieRepository extends ARepository<AssuranceVie> {
    private static final Logger LOG = LoggerFactory.getLogger( AssuranceVieRepository.class );
    private static AssuranceVieRepository instance;

    public static AssuranceVieRepository getInstance() {
        if (null == instance) {
            instance = new AssuranceVieRepository();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("banque");

    private AssuranceVieRepository() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<AssuranceVie> getEntityType() {
        return AssuranceVie.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
