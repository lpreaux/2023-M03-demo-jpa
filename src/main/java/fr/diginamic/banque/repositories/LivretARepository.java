package fr.diginamic.banque.repositories;

import fr.diginamic.banque.entities.LivretA;
import fr.diginamic.jpa.ARepository;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivretARepository extends ARepository<LivretA> {
    private static final Logger LOG = LoggerFactory.getLogger( LivretARepository.class );
    private static LivretARepository instance;

    public static LivretARepository getInstance() {
        if (null == instance) {
            instance = new LivretARepository();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("banque");

    private LivretARepository() {}


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<LivretA> getEntityType() {
        return LivretA.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
