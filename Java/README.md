# Projet Java – Gestion intelligente du tri sélectif

## Table des matières

- [À propos du projet](#à-propos-du-projet)
- [Architecture orientée objet](#architecture-orientée-objet)
- [Fonctionnalités principales](#fonctionnalités-principales)
- [Organisation des données](#organisation-des-données)
- [Technologies utilisées](#technologies-utilisées)
- [Prise en main](#prise-en-main)
  - [Prérequis](#prérequis)
  - [Installation](#installation)
  - [Structure des tests](#structure-des-tests)
- [Membres du groupe](#membres-du-groupe)
- [Chronologie du projet](#chronologie-du-projet)

---

## À propos du projet

Ce projet Java a pour objectif de simuler un système intelligent de tri sélectif en modélisant un centre de tri, des ménages, des commerces partenaires, et un système de fidélité basé sur les dépôts de déchets.  
Les ménages reçoivent des points de fidélité en déposant correctement leurs déchets, points qu’ils peuvent ensuite échanger contre des bons de réduction dans les commerces partenaires.

---

## Architecture orientée objet

Le projet suit une approche orientée objet, avec les principales classes suivantes :

- `CentreTri` : gère les bacs, les dépôts, les notifications et les statistiques  
- `Bac` : unité de tri physique capable de vérifier le type de déchet, d’attribuer les points, et de se vider  
- `Depot` : représente un dépôt de déchet, avec date, type, poids, utilisateur, etc.  
- `Menage` : utilisateur inscrit au système, cumulant des points à chaque dépôt  
- `BonReduction` : généré en échange de points, utilisable dans un commerce  
- `Commerce` : commerce partenaire acceptant les bons de réduction  
- `ContratPartenariat` : lie un centre de tri à un commerce pour une durée donnée  
- `Adresse` : utilisée pour localiser les ménages, bacs et commerces  
- `Couleur`, `Type`, `ResCat` : énumérations décrivant les couleurs de bac, types de déchet et résultats de dépôt  

La classe `Poubelle` a été abandonnée au profit d’une simplification directe via `Bac`.

---

## Fonctionnalités principales

- Dépôt de déchets avec vérification du bac approprié
- Attribution de points de fidélité selon la justesse du dépôt
- Visualisation des statistiques par rue, type, couleur, période, etc.
- Échange des points contre des bons de réduction
- Partenariat entre centre de tri et commerce via contrat
- Notification des bacs pleins
- Possibilité de déplacer ou vider les bacs

---

## Organisation des données

Les objets sont stockés principalement à l’aide de `HashMap`, identifiés par des UUID (pour les bacs, dépôts, bons).  
Les adresses sont comparées par rue, ville et numéro pour permettre des regroupements simples.

---

## Technologies utilisées

- Java 17
- API standard Java (`java.util`, `java.time`, etc.)
- Stockage en mémoire 
- Tests via classes Java spécifiques
- IDE : VSCode ou IntelliJ

---

## Prise en main

### Prérequis

- Java JDK 17 ou supérieur
- Un IDE Java (Eclipse, IntelliJ, VSCode, etc.)

---

## Utilisation

### Structure des tests

Chaque classe fonctionnelle est accompagnée d'une classe de test dédiée.  
Une classe `MainTest` permet d'exécuter automatiquement l’ensemble des tests et d’afficher leur validité.

---

## Membres du groupe

- Mariam KARDALLAS
- Yasmine MOUTAOUAFIQ
- Shaïma OUADAH
- Lucas GOURNAY
- Florian VO

---

## Chronologie du projet

- **10/03/2024** : Début du projet, UML initial
- **15/03/2024** : Ajustement de l’UML (classe Poubelle discutée)
- **17/03/2024** : Début de l’implémentation Java
- **22/03/2024** : Intégration des fonctionnalités principales
- **23/03/2024** : Finalisation du dépôt Git + README
- **24/03/2024** : Rendu 2
