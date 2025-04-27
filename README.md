# Projet Java - Tri Sélectif Intelligent

## Contexte
Le projet consiste à développer une application de gestion du tri sélectif intelligent.  
Les ménages peuvent déposer leurs déchets dans des bacs connectés et se voient attribuer des points de fidélité en fonction de la conformité du tri. Ces points sont ensuite échangeables contre des bons de réduction auprès de commerces partenaires.

Promotion : ING1 GM – 2024–2025  
École : CY Tech  
Module : Projet Java  
Date de rendu : 28 avril 2025

## Objectifs
- Simuler un système de tri sélectif assisté par des bacs intelligents.
- Permettre aux utilisateurs de gagner des points de fidélité lors des dépôts corrects.
- Mettre en place un échange de points contre des bons de réduction.
- Gérer les centres de tri, les bacs, les ménages et les commerces partenaires.

## Technologies utilisées
- Java 21 (OpenJDK)
- JavaFX 21 pour l’interface graphique
- MySQL pour la base de données
- JDBC pour la communication avec la base de données
- IDE : IntelliJ IDEA

## Structure du projet

```TriSelectif/
├── src/
│   ├── model/                (classes métiers : Menage, Depot, CentreTri, etc.)
│   ├── dao/                  (accès base de données)
│   ├── controller/           (contrôleurs JavaFX)
│   └── main/                 (classe principale)
├── resources/
│   ├── fxml/                 (interfaces utilisateur FXML)
│   ├── css/                  (feuilles de style CSS)
├── lib/
│   └── mysql-connector-j-9.2.0.jar
├── sql/
│   └── tri_selectif_schema.sql
├── TriSelectif.iml
├── README.md
```

## Base de données

La base de données est initialisée à partir du script `tri_selectif_schema.sql`.  
Les principales tables sont :
- Adresse
- Menage
- Depot
- CentreTri
- Commerce
- BonReduction
- ContratPartenariat

La connexion JDBC est configurée dans la classe `Main.java`.

## Fonctionnalités principales
- Inscription et authentification des ménages.
- Dépôt de déchets dans des bacs connectés.
- Attribution automatique de points de fidélité.
- Consultation du solde de points et de l’historique des dépôts.
- Échange de points contre des bons de réduction.
- Gestion des commerces partenaires et des contrats.
- Gestion des bacs et consultation de statistiques par le centre de tri.

## Instructions de lancement
1. Cloner le projet ou extraire l'archive.
2. Importer le projet dans IntelliJ IDEA.
3. Exécuter le script SQL pour créer la base de données.
4. Modifier les paramètres de connexion dans `Main.java` si nécessaire.
5. Lancer l'application en exécutant la classe principale `Main.java`.
6. Utiliser les interfaces pour s'inscrire et interagir avec l'application.


## Remarques
- Le connecteur JDBC (`mysql-connector-j-9.2.0.jar`) doit être ajouté au projet.
- Le projet utilise JavaFX pour toutes les interfaces utilisateurs.
- Aucun serveur externe n'est requis pour l’exécution de l’application.

## Date de rendu
28 avril 2025

