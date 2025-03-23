CREATE DATABASE IF NOT EXISTS tri_selectif;
USE tri_selectif;

-- ============================
-- TABLE Adresse
-- ============================
CREATE TABLE Adresse (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    nomRue VARCHAR(100),
    codePostal INT,
    ville VARCHAR(100)
);

-- ============================
-- TABLE Centre de tri
-- ============================
CREATE TABLE CentreTri (
    idCentre INT AUTO_INCREMENT PRIMARY KEY,  -- Ajout de AUTO_INCREMENT à idCentre
    nomCentre VARCHAR(100),
    adresse_id INT,
    FOREIGN KEY (adresse_id) REFERENCES Adresse(id)
);

-- ============================
-- TABLE Bac
-- ============================
CREATE TABLE Bac (
    idBac CHAR(36) PRIMARY KEY,
    couleur ENUM('vert', 'jaune', 'bleu', 'gris', 'toutCol'),
    capacite INT,
    contenu INT,
    centre_id INT,
    adresse_id INT,
    FOREIGN KEY (centre_id) REFERENCES CentreTri(idCentre),
    FOREIGN KEY (adresse_id) REFERENCES Adresse(id)
);

-- ============================
-- TABLE Menage
-- ============================
CREATE TABLE Menage (
    nomCompte VARCHAR(50) PRIMARY KEY,
    motDePasse VARCHAR(100),
    pointsFidelite INT,
    adresse_id INT,
    FOREIGN KEY (adresse_id) REFERENCES Adresse(id)
);

-- ============================
-- TABLE Commerce
-- ============================
CREATE TABLE Commerce (
    idCommerce CHAR(36) PRIMARY KEY,
    nomCommerce VARCHAR(100),
    adresse_id INT,
    FOREIGN KEY (adresse_id) REFERENCES Adresse(id)
);

-- ============================
-- TABLE ContratPartenariat
-- ============================
CREATE TABLE ContratPartenariat (
    idCentreP INT,
    idCommerceP CHAR(36),
    estPartenaire BOOLEAN,
    dateDebut DATE,
    dateFin DATE,
    PRIMARY KEY (idCentreP, idCommerceP),
    FOREIGN KEY (idCentreP) REFERENCES CentreTri(idCentre),
    FOREIGN KEY (idCommerceP) REFERENCES Commerce(idCommerce)
);

-- ============================
-- TABLE BonReduction
-- ============================
CREATE TABLE BonReduction (
    idBon CHAR(36) PRIMARY KEY,
    valeur DOUBLE,
    bonUtilise BOOLEAN,
    commerce_id CHAR(36),
    menage_id VARCHAR(50),
    dateExpiration DATE,
    FOREIGN KEY (commerce_id) REFERENCES Commerce(idCommerce),
    FOREIGN KEY (menage_id) REFERENCES Menage(nomCompte)
);

-- ============================
-- TABLE Depot
-- ============================
CREATE TABLE Depot (
    idDepot CHAR(36) PRIMARY KEY,
    poidsDepot INT,
    couleur ENUM('vert', 'jaune', 'bleu', 'gris', 'toutCol'),
    typeDechet ENUM('verre', 'carton', 'plastique', 'metal', 'papier', 'autre', 'toutType'),
    resultat ENUM('correct', 'incorrect', 'total'),
    pointsGagnes INT,
    dateDepot DATE,
    heureDepot TIME,
    adresse_id INT,
    menage_id VARCHAR(50),
    FOREIGN KEY (adresse_id) REFERENCES Adresse(id) ON DELETE CASCADE,
    FOREIGN KEY (menage_id) REFERENCES Menage(nomCompte) ON DELETE CASCADE
);

