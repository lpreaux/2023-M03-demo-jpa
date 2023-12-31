package fr.diginamic.banque.entities;

import fr.diginamic.jpa.ABaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "banque")
public class Banque extends ABaseEntity {
    public static Banque createNewBanque(String nom) {
        Banque banque = new Banque();
        banque.setNom(nom);
        return banque;
    }

    @Column(name = "nom", unique = true, nullable = false)
    private String nom;

    @OneToMany(mappedBy = "banque", orphanRemoval = true)
    private Set<Client> clients = new LinkedHashSet<>();

    public Banque() {}

    public Banque(Integer id, String nom) {
        super(id);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}