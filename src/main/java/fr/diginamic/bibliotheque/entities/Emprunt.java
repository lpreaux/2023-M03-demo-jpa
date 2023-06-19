package fr.diginamic.bibliotheque.entities;

import fr.diginamic.jpa.ABaseEntity;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "emprunt")
public class Emprunt extends ABaseEntity {
    @Column(name = "DATE_DEBUT", nullable = false)
    private Instant dateDebut;

    @Column(name = "DATE_FIN")
    private Instant dateFin;

    @Column(name = "DELAI")
    private Integer delai;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client client;

    @ManyToMany(mappedBy = "emprunts")
    private Set<Livre> livres = new LinkedHashSet<>();

    public Instant getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Instant dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Instant getDateFin() {
        return dateFin;
    }

    public void setDateFin(Instant dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt{");
        sb.append("id=").append(id);
        sb.append(", dateDebut=").append(dateDebut);
        sb.append(", dateFin=").append(dateFin);
        sb.append(", delai=").append(delai);
        sb.append('}');
        return sb.toString();
    }
}