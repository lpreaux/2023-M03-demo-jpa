package fr.diginamic.banque.entities;

import fr.diginamic.jpa.ABaseEntity;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte extends ABaseEntity {
    public static Compte createNewCompte(String numero, double solde) {
        Compte compte = new Compte();
        compte.setNumero(numero);
        compte.setSolde(solde);
        return compte;
    }
    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "solde", nullable = false)
    private double solde;

    @ManyToMany
    @JoinTable(name = "client_comptes",
            joinColumns = @JoinColumn(name = "comptes_ID"),
            inverseJoinColumns = @JoinColumn(name = "client_ID"))
    private Set<Client> clients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "compte", orphanRemoval = true)
    private Set<Operation> operations = new LinkedHashSet<>();

    public Compte() {}

    public Compte(Integer id, String numero, double solde) {
        super(id);
        this.numero = numero;
        this.solde = solde;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removerClient(Client client) {
        clients.remove(client);
    }
}