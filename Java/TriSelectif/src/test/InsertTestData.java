package test;
import java.sql.*;
import java.util.UUID;

public class InsertTestData {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tri_selectif";
        String user = "root";				// À adapter
        String password = "cytech0001";		// À adapter

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie !");

            // Adresse
            String adresseSQL = "INSERT INTO Adresse (numero, nomRue, codePostal, ville) VALUES (?, ?, ?, ?)";
            PreparedStatement adresseStmt = conn.prepareStatement(adresseSQL, Statement.RETURN_GENERATED_KEYS);
            adresseStmt.setInt(1, 10);
            adresseStmt.setString(2, "Rue des Lilas");
            adresseStmt.setInt(3, 75000);
            adresseStmt.setString(4, "Paris");
            adresseStmt.executeUpdate();
            ResultSet adresseKeys = adresseStmt.getGeneratedKeys();
            adresseKeys.next();
            int adresseId = adresseKeys.getInt(1);

            // Centre de tri
            String centreSQL = "INSERT INTO CentreTri (idCentre, nomCentre, adresse_id) VALUES (?, ?, ?)";
            PreparedStatement centreStmt = conn.prepareStatement(centreSQL);
            centreStmt.setInt(1, 1);
            centreStmt.setString(2, "Centre Paris Est");
            centreStmt.setInt(3, adresseId);
            centreStmt.executeUpdate();

            // Bac
            String bacId = UUID.randomUUID().toString();
            String bacSQL = "INSERT INTO Bac (idBac, couleur, capacite, contenu, centre_id, adresse_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement bacStmt = conn.prepareStatement(bacSQL);
            bacStmt.setString(1, bacId);
            bacStmt.setString(2, "jaune");
            bacStmt.setInt(3, 10000);
            bacStmt.setInt(4, 0);
            bacStmt.setInt(5, 1);
            bacStmt.setInt(6, adresseId);
            bacStmt.executeUpdate();

            // Ménage
            String menageSQL = "INSERT INTO Menage (nomCompte, motDePasse, pointsFidelite, adresse_id) VALUES (?, ?, ?, ?)";
            PreparedStatement menageStmt = conn.prepareStatement(menageSQL);
            menageStmt.setString(1, "familleDupont");
            menageStmt.setString(2, "mdp123");
            menageStmt.setInt(3, 0);
            menageStmt.setInt(4, adresseId);
            menageStmt.executeUpdate();

            // Commerce
            String commerceId = UUID.randomUUID().toString();
            String commerceSQL = "INSERT INTO Commerce (idCommerce, nomCommerce, adresse_id) VALUES (?, ?, ?)";
            PreparedStatement commerceStmt = conn.prepareStatement(commerceSQL);
            commerceStmt.setString(1, commerceId);
            commerceStmt.setString(2, "Super U");
            commerceStmt.setInt(3, adresseId);
            commerceStmt.executeUpdate();

            // Contrat partenariat
            String contratSQL = "INSERT INTO ContratPartenariat (idCentreP, idCommerceP, estPartenaire, dateDebut, dateFin) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement contratStmt = conn.prepareStatement(contratSQL);
            contratStmt.setInt(1, 1);
            contratStmt.setString(2, commerceId);
            contratStmt.setBoolean(3, true);
            contratStmt.setDate(4, Date.valueOf("2025-01-01"));
            contratStmt.setDate(5, Date.valueOf("2025-12-31"));
            contratStmt.executeUpdate();

            // Bon de réduction
            String bonId = UUID.randomUUID().toString();
            String bonSQL = "INSERT INTO BonReduction (idBon, valeur, bonUtilise, commerce_id, menage_id, dateExpiration) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement bonStmt = conn.prepareStatement(bonSQL);
            bonStmt.setString(1, bonId);
            bonStmt.setDouble(2, 5.0);
            bonStmt.setBoolean(3, false);
            bonStmt.setString(4, commerceId);
            bonStmt.setString(5, "familleDupont");
            bonStmt.setDate(6, Date.valueOf("2025-06-01"));
            bonStmt.executeUpdate();

            // Dépôt
            String depotId = UUID.randomUUID().toString();
            String depotSQL = "INSERT INTO Depot (idDepot, poidsDepot, couleur, typeDechet, resultat, pointsGagnes, dateDepot, heureDepot, adresse_id, menage_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement depotStmt = conn.prepareStatement(depotSQL);
            depotStmt.setString(1, depotId);
            depotStmt.setInt(2, 2500);
            depotStmt.setString(3, "jaune");
            depotStmt.setString(4, "plastique");
            depotStmt.setString(5, "correct");
            depotStmt.setInt(6, 25);
            depotStmt.setDate(7, Date.valueOf("2025-03-23"));
            depotStmt.setTime(8, Time.valueOf("14:30:00"));
            depotStmt.setInt(9, adresseId);
            depotStmt.setString(10, "familleDupont");
            depotStmt.executeUpdate();

            System.out.println("Données insérées avec succès !");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}