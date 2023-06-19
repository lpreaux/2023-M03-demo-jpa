package fr.diginamic.bibliotheque.repositories;

import fr.diginamic.bibliotheque.entities.Client;
import fr.diginamic.bibliotheque.entities.Emprunt;
import fr.diginamic.jpa.ARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmpruntRepository extends ARepository<Emprunt> {
    private static final String FIND_BY_CLIENT = "SELECT e FROM Emprunt e WHERE client=:client";
    private static EmpruntRepository instance;
    private static final Logger LOG = LoggerFactory.getLogger(EmpruntRepository.class);

    public static EmpruntRepository getInstance() {
        if (null == instance) {
            instance = new EmpruntRepository();
        }
        return instance;
    }

    private EmpruntRepository() {}

    @Override
    protected Class<Emprunt> getEntityType() {
        return Emprunt.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    public List<Emprunt> findByClient(Client client) {
        return doWithEm(em -> em.createQuery(FIND_BY_CLIENT, Emprunt.class)
                .setParameter("client", client)
                .getResultList());
    }
}
