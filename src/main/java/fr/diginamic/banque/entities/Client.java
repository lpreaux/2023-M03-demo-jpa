package fr.diginamic.banque.entities;

import fr.diginamic.jpa.ABaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "client", uniqueConstraints = {
        @UniqueConstraint(name = "uc_client_nom_prenom", columnNames = {"nom", "prenom"})
})
public class Client extends ABaseEntity {
    public static Client createNewClient(String nom, String prenom, LocalDate dateNaissance, Banque banque, Adresse adresse) {
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setDateNaissance(dateNaissance);
        client.setBanque(banque);
        client.setAdresse(adresse);
        return client;
    }

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @ManyToOne
    @JoinColumn(name = "banque_id")
    private Banque banque;

    @Embedded
    private Adresse adresse;

    @ManyToMany
    @JoinTable(name = "client_comptes",
            joinColumns = @JoinColumn(name = "client_ID"),
            inverseJoinColumns = @JoinColumn(name = "comptes_ID"))
    private Set<Compte> comptes = new LinkedHashSet<>();

    public Client() {}

    public Client(Integer id, String nom, String prenom, LocalDate dateNaissance, Banque banque, Adresse adresse, Set<Compte> comptes) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.banque = banque;
        this.adresse = adresse;
        this.comptes = comptes;
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}