package fr.diginamic.banque;

import fr.diginamic.banque.entities.*;
import fr.diginamic.banque.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestBanque {
    public static void main(String[] args) {
        BanqueRepository banqueRepository = BanqueRepository.getInstance();
        ClientRepository clientRepository = ClientRepository.getInstance();
        CompteRepository compteRepository = CompteRepository.getInstance();
        AssuranceVieRepository assuranceVieRepository = AssuranceVieRepository.getInstance();
        LivretARepository livretARepository = LivretARepository.getInstance();
        OperationRepository operationRepository = OperationRepository.getInstance();
        VirementRepository virementRepository = VirementRepository.getInstance();

        Banque banqueIse = Banque.createNewBanque("Ise");
        banqueRepository.create(banqueIse);

        Adresse adresse = Adresse.createNewAdresse(0, "impasse inconnu", 99999, "Null Part Ville");
        Client anneOnyme = Client.createNewClient("ONYME", "Anne", LocalDate.now(), banqueIse, adresse);
        Client johnSmith = Client.createNewClient("SMITH", "John", LocalDate.now(), banqueIse, adresse);
        clientRepository.create(anneOnyme);
        clientRepository.create(johnSmith);

        Compte compteCommun = Compte.createNewCompte("001", 1_000);
        compteCommun.addClient(anneOnyme);
        compteCommun.addClient(johnSmith);
        compteRepository.create(compteCommun);

        AssuranceVie assuranceVie = AssuranceVie.createNewAssuranceVie("002", 10_000, LocalDate.now().plusYears(3), 4.6);
        assuranceVie.addClient(anneOnyme);
        assuranceVieRepository.create(assuranceVie);

        LivretA livretA = LivretA.createNewLivretA("003", 4_500, 3.5);
        livretA.addClient(anneOnyme);
        livretARepository.create(livretA);

        Operation operation1 = Operation.createNewOperation(LocalDateTime.now().minusDays(1), 50, "Courses", compteCommun);
        Operation operation2 = Operation.createNewOperation(LocalDateTime.now(), 15, "Boucherie", compteCommun);
        operationRepository.create(operation1);
        operationRepository.create(operation2);

        Virement virement = Virement.createNewVirement(LocalDateTime.now(), 640, "Loyer", compteCommun, "proprio");
        virementRepository.create(virement);
    }
}
