# Démo JPA — formation Diginamic

> Dépôt pédagogique conservé comme support de cours. Il ne s'agit pas d'une application destinée à la production.

Exercices Java réalisés en 2023 pour découvrir Jakarta Persistence et Hibernate à travers deux domaines : une bibliothèque et une banque.

## Notions travaillées

- mapping d'entités et de relations JPA ;
- héritage d'entités pour les comptes et opérations bancaires ;
- repositories génériques et spécialisés ;
- cycle de vie d'un `EntityManager` ;
- persistance dans MariaDB.

## Exécution

Le projet utilise Java 19 et Maven. Configurez votre base locale dans les ressources du projet, puis :

```bash
mvn compile
```

Les classes `TestBibliotheque` et `TestBanque` servent de points d'entrée pédagogiques.
