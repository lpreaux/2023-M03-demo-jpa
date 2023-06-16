package fr.diginamic;

import fr.diginamic.entities.Livre;
import fr.diginamic.jpa.repositories.LivreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJpa {
    private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);

    public static void main(String[] args) {
        LivreRepository livreRepository = LivreRepository.getInstance();

        LOG.info("=====TEST findAll=====");
        for (Livre livre : livreRepository.findAll()) {
            LOG.info("{}", livre);
        }

        LOG.info("=====TEST findById avec id=1=====");
        LOG.info("{}", livreRepository.findById(1));

        LOG.info("=====TEST findReferenceById avec id=1=====");
        LOG.info("{}", livreRepository.findReferenceById(1));

        LOG.info("=====TEST findByTitre avec titre='Germinal'=====");
        for (Livre livre : livreRepository.findByTitre("Germinal")) {
            LOG.info("{}", livre);
        }

        LOG.info("=====TEST findByAuteur avec auteur='Gaston Pouet'=====");
        LOG.info("{}", livreRepository.findByAuteur("Gaston Pouet"));

        LOG.info("=====TEST create====");
        Livre javaPourLesNuls = Livre.createNewLivre("Java pour les nuls", "Barry A. Burd");
        livreRepository.create(javaPourLesNuls);
        LOG.info("{}", javaPourLesNuls);

        LOG.info("=====TEST update=====");
        javaPourLesNuls.setTitre("Java pour les Nuls");
        livreRepository.update(javaPourLesNuls);
        LOG.info("{}", javaPourLesNuls);

        LOG.info("=====TEST delete=====");
        livreRepository.delete(javaPourLesNuls);
    }
}
