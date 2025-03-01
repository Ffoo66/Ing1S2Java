CREATE DATABASE TriSelectif;
USE TriSelectif;

-- Table Menage (Utilisateurs)
CREATE TABLE Menage (
    idMenage INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    motDePasseHash VARCHAR(255) NOT NULL,
    pointsFidelite INT DEFAULT 0
);

-- Table Poubelle (Poubelles connectées)
CREATE TABLE Poubelle (
    idPoubelle INT PRIMARY KEY AUTO_INCREMENT,
    type ENUM('vert', 'jaune', 'bleu', 'gris') NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    estPleine BOOLEAN DEFAULT FALSE
);

-- Table Depot (Historique des dépôts de déchets)
CREATE TABLE Depot (
    idDepot INT PRIMARY KEY AUTO_INCREMENT,
    idMenage INT NOT NULL,
    idPoubelle INT NOT NULL,
    dateDepot DATETIME DEFAULT CURRENT_TIMESTAMP,
    poidsTotal FLOAT NOT NULL,
    score INT NOT NULL,
    FOREIGN KEY (idMenage) REFERENCES Menage(idMenage),
    FOREIGN KEY (idPoubelle) REFERENCES Poubelle(idPoubelle)
);

-- Table StatistiquesDepot (Stockage des statistiques analytiques sur les heures de dépôt)
CREATE TABLE StatistiquesDepot (
    idStat INT PRIMARY KEY AUTO_INCREMENT,
    heureDepot INT CHECK (heureDepot >= 0 AND heureDepot < 24),
    jourDepot INT CHECK (jourDepot >= 1 AND jourDepot <= 7),
    moisDepot INT CHECK (moisDepot >= 1 AND moisDepot <= 12),
    anneeDepot INT CHECK (anneeDepot > 2000),
    nombreDepots INT NOT NULL
);



