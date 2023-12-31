package fr.diginamic.bibliotheque.repositories;

import fr.diginamic.bibliotheque.entities.Client;
import fr.diginamic.jpa.ARepository;
import fr.diginamic.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientRepository extends ARepository<Client> {
    private static ClientRepository instance;
    private static final Logger LOG = LoggerFactory.getLogger(ClientRepository.class);
    private final EntityManager em = EntityManagerProvider.getEntityManager("demo-jpa");

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public static ClientRepository getInstance() {
        if (null == instance) {
            instance = new ClientRepository();
        }
        return instance;
    }

    private ClientRepository() {}



    @Override
    protected Class<Client> getEntityType() {
        return Client.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
