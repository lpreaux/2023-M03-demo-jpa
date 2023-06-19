package fr.diginamic.banque.entities;

import fr.diginamic.jpa.ABaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("O")
public class Operation extends ABaseEntity {
    public static Operation createNewOperation(LocalDateTime date, double montant, String motif, Compte compte) {
        Operation operation = new Operation();
        operation.setDate(date);
        operation.setMontant(montant);
        operation.setMotif(motif);
        operation.setCompte(compte);
        return operation;
    }
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "montant", nullable = false)
    private double montant;

    @Column(name = "motif", nullable = false)
    private String motif;

    @ManyToOne(optional = false)
    @JoinColumn(name = "compte_id", nullable = false)
    private Compte compte;

    public Operation() {}

    public Operation(Integer id, LocalDateTime date, double montant, String motif, Compte compte) {
        super(id);
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}