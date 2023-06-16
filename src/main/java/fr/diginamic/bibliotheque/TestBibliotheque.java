package fr.diginamic.bibliotheque;

import fr.diginamic.bibliotheque.entities.Client;
import fr.diginamic.bibliotheque.entities.Emprunt;
import fr.diginamic.bibliotheque.entities.Livre;
import fr.diginamic.bibliotheque.repositories.ClientRepository;
import fr.diginamic.bibliotheque.repositories.EmpruntRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestBibliotheque {
    private static final Logger LOG = LoggerFactory.getLogger(TestBibliotheque.class);
    public static void main(String[] args) {
        EmpruntRepository empruntRepository = EmpruntRepository.getInstance();
        LOG.info("=====TEST findById d'un emprunt1 avec id=1=====");
        Emprunt emprunt1 = empruntRepository.findReferenceById(1);
        LOG.info("{}", emprunt1);
        LOG.info("L'emprunt1 réalisé par : {}", emprunt1.getClient());
        LOG.info("L'emprunt1 concerne les livres suivant :");
        for (Livre livre : emprunt1.getLivres()) {
            LOG.info("{}", livre);
        }

        ClientRepository clientRepository = ClientRepository.getInstance();
        LOG.info("=====TEST findByClient des emprunts d'un client avec id=3=====");
        Client client3 = clientRepository.findReferenceById(3);
        List<Emprunt> empruntsFromClient3 = empruntRepository.findByClient(client3);
        LOG.info("Le client avec l'id {} a réalisé {} emprunt(s):", client3.getId(), empruntsFromClient3.size());
        for (Emprunt emprunt : empruntsFromClient3) {
            LOG.info("{}", emprunt);
            LOG.info("L'emprunt avec l'id {} concerne les livres suivant :", emprunt.getId());
            for (Livre livre : emprunt.getLivres()) {
                LOG.info("{}", livre);
            }
        }
    }
}
