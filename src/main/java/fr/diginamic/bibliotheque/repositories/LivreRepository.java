package fr.diginamic.bibliotheque.repositories;

import fr.diginamic.bibliotheque.entities.Livre;
import fr.diginamic.jpa.ARepository;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LivreRepository extends ARepository<Livre> {
    private static final String FIND_BY_TITRE = "SELECT l FROM Livre l WHERE titre=:titre";
    private static final String FIND_BY_AUTEUR = "SELECT l FROM Livre l WHERE auteur=:auteur";
    private static LivreRepository instance;
    private static final Logger LOG = LoggerFactory.getLogger(LivreRepository.class);

    public static LivreRepository getInstance() {
        if (null == instance) {
            instance = new LivreRepository();
        }
        return instance;
    }

    private LivreRepository() {}

    @Override
    protected Class<Livre> getEntityType() {
        return Livre.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    public List<Livre> findByTitre(String titre) {
        return doWithEm(em -> {
            TypedQuery<Livre> query = em.createQuery(FIND_BY_TITRE, Livre.class);
            query.setParameter("titre", titre);
            return query.getResultList();
        });
    }

    public List<Livre> findByAuteur(String auteur) {
        return doWithEm(em -> {
            TypedQuery<Livre> query = em.createQuery(FIND_BY_AUTEUR, Livre.class);
            query.setParameter("auteur", auteur);
            return query.getResultList();
        });
    }
}
