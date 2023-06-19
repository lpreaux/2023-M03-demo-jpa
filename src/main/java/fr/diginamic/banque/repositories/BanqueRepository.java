package fr.diginamic.banque.repositories;

import fr.diginamic.banque.entities.Banque;
import fr.diginamic.jpa.ARepository;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BanqueRepository extends ARepository<Banque> {
    private static BanqueRepository instance;
    private static final Logger LOG = LoggerFactory.getLogger( BanqueRepository.class );

    public static BanqueRepository getInstance() {
        if (null == instance) {
            instance = new BanqueRepository();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("banque");

    private BanqueRepository() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Banque> getEntityType() {
        return Banque.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
