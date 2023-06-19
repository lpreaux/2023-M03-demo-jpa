package fr.diginamic.banque.repositories;

import fr.diginamic.banque.entities.Compte;
import fr.diginamic.jpa.ARepository;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompteRepository extends ARepository<Compte> {
    private static final Logger LOG = LoggerFactory.getLogger( CompteRepository.class );
    private static CompteRepository instance;

    public static CompteRepository getInstance() {
        if (null == instance) {
            instance = new CompteRepository();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("banque");

    private CompteRepository() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Compte> getEntityType() {
        return Compte.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
