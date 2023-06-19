package fr.diginamic.banque.repositories;

import fr.diginamic.banque.entities.Client;
import fr.diginamic.jpa.ARepository;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientRepository extends ARepository<Client> {
    private static ClientRepository instance;
    private static final Logger LOG = LoggerFactory.getLogger( ClientRepository.class );

    public static ClientRepository getInstance() {
        if (null == instance) {
            instance = new ClientRepository();
        }
        return instance;
    }
    private final EntityManager em = EntityManagerProvider.getEntityManager("banque");

    private ClientRepository() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Client> getEntityType() {
        return Client.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
