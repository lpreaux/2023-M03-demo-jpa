package fr.diginamic.bibliotheque.entities;

import fr.diginamic.exception.DataException;
import fr.diginamic.jpa.ABaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends ABaseEntity {
    public static Client createNewClient(String nom, String prenom) throws DataException {
        if (null == nom || null == prenom) {
            throw new DataException("Cannot create a Client with a 'nom' or a 'prenom' null");
        }
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        return client;
    }
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts = new LinkedHashSet<>();

    public Client() {}

    public Client(Integer id, String nom, String prenom) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public void addEmprunt(Emprunt emprunt) {
        emprunts.add(emprunt);
    }

    public void removeEmprunt(Emprunt emprunt) {
        emprunts.remove(emprunt);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}