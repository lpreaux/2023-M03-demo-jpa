package fr.diginamic.jpa.repositories;

import fr.diginamic.entities.Livre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivreRepository extends ARepository<Livre> {
    private static LivreRepository instance;

    private final Logger LOG = LoggerFactory.getLogger(LivreRepository.class);

    private LivreRepository() {}

    @Override
    public ARepository<Livre> getInstance() {
        if (null != instance) {
            instance = new LivreRepository();
        }
        return instance;
    }

    @Override
    protected Class<Livre> getEntityType() {
        return Livre.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
