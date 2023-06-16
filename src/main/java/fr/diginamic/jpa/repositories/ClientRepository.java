package fr.diginamic.jpa.repositories;

import fr.diginamic.entities.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientRepository extends ARepository<Client> {
    private static ClientRepository instance;
    private static final Logger LOG = LoggerFactory.getLogger(ClientRepository.class);

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
