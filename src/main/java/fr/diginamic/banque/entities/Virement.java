package fr.diginamic.banque.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {
    public static Virement createNewVirement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire) {
        Virement virement = new Virement();
        virement.setDate(date);
        virement.setMontant(montant);
        virement.setMotif(motif);
        virement.setCompte(compte);
        virement.setBeneficiaire(beneficiaire);
        return virement;
    }
    @Column(name = "beneficiaire")
    private String beneficiaire;

    public Virement() {}

    public Virement(Integer id, LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire) {
        super(id, date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}