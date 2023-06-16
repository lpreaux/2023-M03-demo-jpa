package fr.diginamic.jpa.repositories;

import fr.diginamic.entities.Livre;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LivreRepository extends ARepository<Livre> {
    private static final String FIND_BY_TITRE = "SELECT l FROM Livre l WHERE titre=:titre";
    private static final String FIND_BY_AUTEUR = "SELECT l FROM Livre l WHERE auteur=:auteur";
    private static LivreRepository instance;

    public static LivreRepository getInstance() {
        if (null == instance) {
            instance = new LivreRepository();
        }
        return instance;
    }

    private final Logger LOG = LoggerFactory.getLogger(LivreRepository.class);

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
        List<Livre> livres = doWithEm(em -> {
            TypedQuery<Livre> query = em.createQuery(FIND_BY_TITRE, Livre.class);
            query.setParameter("titre", titre);
            return query.getResultList();
        });
        livres.forEach(Livre::trackNotNew);
        return livres;
    }

    public List<Livre> findByAuteur(String auteur) {
        List<Livre> livres = doWithEm(em -> {
            TypedQuery<Livre> query = em.createQuery(FIND_BY_AUTEUR, Livre.class);
            query.setParameter("auteur", auteur);
            return query.getResultList();
        });
        livres.forEach(Livre::trackNotNew);
        return livres;
    }
}
