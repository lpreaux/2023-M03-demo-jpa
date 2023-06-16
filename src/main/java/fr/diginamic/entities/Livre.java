package fr.diginamic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre extends ABaseEntity {
    public static Livre createNewLivre(String titre, String auteur) {
        Livre livre = new Livre();
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        return livre;
    }

    @Column(name = "TITRE", nullable = false)
    private String titre;

    @Column(name = "AUTEUR", nullable = false, length = 50)
    private String auteur;

    public Livre() {}

    public Livre(Integer id, String titre, String auteur) {
        super(id);
        this.titre = titre;
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Livre{");
        sb.append("id=").append(getId()).append('\'');
        sb.append(", titre='").append(titre).append('\'');
        sb.append(", auteur='").append(auteur).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

}