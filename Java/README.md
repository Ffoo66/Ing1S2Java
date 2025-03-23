# Projet Java — Gestion intelligente du tri sélectif

## Table des matières

1. [À propos du projet](#à-propos-du-projet)
2. [Architecture et conception des classes](#architecture-et-conception-des-classes)
3. [Fonctionnalités principales](#fonctionnalités-principales)
4. [Organisation et stockage des données](#organisation-et-stockage-des-données)
5. [Arborescence des packages](#arborescence-des-packages)
6. [Technologies utilisées](#technologies-utilisées)
7. [Prise en main](#prise-en-main)
   - [Prérequis](#prérequis)
   - [Installation](#installation)
8. [Utilisation](#utilisation)
   - [Classes de test](#classes-de-test)
   - [Exécution de MainTest](#exécution-de-maintest)
9. [Membres du groupe](#membres-du-groupe)
10. [Chronologie du projet](#chronologie-du-projet)

---

## À propos du projet

Ce projet Java a pour objectif de simuler un système intelligent de tri sélectif, en modélisant un centre de tri, des ménages, des commerces partenaires et des bacs de tri.  
Les ménages reçoivent des points de fidélité en déposant correctement leurs déchets, qu’ils peuvent ensuite échanger contre des bons de réduction.

---

## Architecture et conception des classes

Le projet repose sur une modélisation orientée objet.  
Chaque classe Java représente une entité du système : 

- `CentreTri`
- `Bac`
- `Depot`
- `Menage`
- `BonReduction`
- `Commerce`
- `ContratPartenariat`
- `Adresse`
- Enums : `Couleur`, `Type`, `ResCat`

---

## Fonctionnalités principales

- Ajout de déchets dans un bac
- Vérification type/couleur
- Notification quand un bac est plein
- Attribution de points de fidélité
- Échange de points contre bons de réduction
- Contrats entre centres de tri et commerces
- Accès à l’historique des dépôts

---

## Organisation et stockage des données

- `HashMap<UUID, ...>` pour stocker les entités
- `HashMap<String, Menage>` pour gérer les comptes utilisateurs
- Données identifiées par `UUID`
- **Aucune persistance réelle pour le moment**
- Prévu : connexion future à une base MySQL via JDBC

---

## Arborescence des packages

```
Java/
├── Adresse.java
├── Bac.java
├── BonReduction.java
├── CentreTri.java
├── Commerce.java
├── ContratPartenariat.java
├── Couleur.java
├── Depot.java
├── Horaire.java
├── Menage.java
├── Poubelle.java
├── Type.java
├── ResCat.java
├── MainTest.java
├── README.md
```

---

## Technologies utilisées

- **Java 17+**
- API Java Time (`LocalDate`, `LocalTime`)
- Collections (`HashMap`, `ArrayList`)
- UUID
- JDBC (prévu pour la base de données MySQL)

---

## Prise en main

### Prérequis

- JDK installé (Java 17 ou supérieur)
- IDE Java (IntelliJ, Eclipse, VSCode, etc.)

### Installation

Cloner le projet :
```bash
git clone https://github.com/votre-repo/projet-tri-selectif.git
cd projet-tri-selectif/Java
```

Compiler les classes :
```bash
javac *.java
```

---

## Utilisation

### Classes de test

Chaque classe principale est accompagnée d'une classe de test.  
Aucune interface utilisateur, tout se fait via les données instanciées.

### Exécution de MainTest

```bash
java MainTest
```

Ce test centralise les appels aux autres classes pour vérifier le bon fonctionnement global.

---

## Membres du groupe

- Mariam
- Yasmine   
- Shaïma  
- Lucas  
- Vo Florian  

---

## Chronologie du projet

- **10/03/2024** : Début du projet, UML initial
- **15/03/2024** : Ajustement de l’UML (classe Poubelle discutée)
- **17/03/2024** : Début de l’implémentation Java
- **22/03/2024** : Intégration des fonctionnalités principales
- **23/03/2024** : Finalisation du dépôt Git + README
- **24/03/2024** : Rendu final

---

## Spécification du rendu

> Chaque classe a une classe de test associée.  
> Le projet est organisé selon plusieurs **packages** distincts.  
> Pas de menu utilisateur, uniquement des **jeux de données** pour tester les fonctionnalités.  
> Une classe `MainTest` permet d’exécuter tous les tests.  
> Préparation à l’utilisation de **MySQL** via **JDBC** pour la suite.
