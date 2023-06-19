package fr.diginamic.banque.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte {
    public static AssuranceVie createNewAssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        AssuranceVie assuranceVie = new AssuranceVie();
        assuranceVie.setNumero(numero);
        assuranceVie.setSolde(solde);
        assuranceVie.setDateFin(dateFin);
        assuranceVie.setTaux(taux);
        return assuranceVie;
    }
    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "taux", nullable = false)
    private double taux;

    public AssuranceVie() {}

    public AssuranceVie(Integer id, String numero, double solde, LocalDate dateFin, double taux) {
        super(id, numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}