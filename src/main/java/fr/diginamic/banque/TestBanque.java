package fr.diginamic.banque;

import fr.diginamic.jpa.EntityManagerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBanque {
    private static final Logger logger = LoggerFactory.getLogger( TestBanque.class );

    public static void main(String[] args) {
        EntityManagerProvider.getEntityManager("banque");
    }
}
