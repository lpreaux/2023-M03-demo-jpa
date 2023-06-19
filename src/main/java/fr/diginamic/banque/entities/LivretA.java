package fr.diginamic.banque.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte {
    public static LivretA createNewLivretA(String numero, double solde, double taux) {
        LivretA livretA = new LivretA();
        livretA.setNumero(numero);
        livretA.setSolde(solde);
        livretA.setTaux(taux);
        return livretA;
    }

    @Column(name = "taux", nullable = false)
    private double taux;

    public LivretA() {}

    public LivretA(Integer id, String numero, double solde, double taux) {
        super(id, numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}