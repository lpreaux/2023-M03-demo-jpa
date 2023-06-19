package fr.diginamic.banque.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte {
    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "taux", nullable = false)
    private double taux;

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