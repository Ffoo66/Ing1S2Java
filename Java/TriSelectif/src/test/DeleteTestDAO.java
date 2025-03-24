package test;

import dao.*;
import java.sql.*;
import java.util.UUID;

public class DeleteTestDAO {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tri_selectif";
        String user = "root"; // À adapter
        String password = "cytech0001"; // À adapter

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie!");

            // Création des DAO
            MenageDAO menageDAO = new MenageDAO(conn);
            DepotDAO depotDAO = new DepotDAO(conn);
            CommerceDAO commerceDAO = new CommerceDAO(conn);
            ContratPartenariatDAO contratPartenariatDAO = new ContratPartenariatDAO(conn);
            BacDAO bacDAO = new BacDAO(conn);
            CentreTriDAO centreTriDAO = new CentreTriDAO(conn);
            AdresseDAO adresseDAO = new AdresseDAO(conn);

            // Utilisation des identifiants générés dans InsertTestData
            // Adresse
            int adresseId = 1;  // Correspond à l'ID d'adresse généré dans InsertTestData

            // Centre de tri
            int idCentre = 1;  // ID de CentreTri dans InsertTestData

            // Bac
            UUID bacId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");  // ID généré dans InsertTestData

            // Ménage
            String nomCompte = "familleDupont";  // Nom de compte du Ménage dans InsertTestData

            // Commerce
            UUID commerceId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");  // ID généré dans InsertTestData

            // ContratPartenariat
            // ContratPartenariat utilise les ids du Commerce et du CentreTri
            UUID idContratCommerce = commerceId;
            int idContratCentre = idCentre;

            // Dépôt
            UUID idDepot = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");  // ID généré dans InsertTestData

            // Suppression du Ménage
            System.out.println("\nTest de suppression du Ménage...");
            menageDAO.delete(nomCompte);  // Appel de la méthode delete() pour le Ménage

            // Suppression du Bac
            System.out.println("\nTest de suppression du Bac...");
            bacDAO.delete(bacId);  // Appel de la méthode delete() pour le Bac

            // Suppression du Depot
            System.out.println("\nTest de suppression du Depot...");
            depotDAO.delete(idDepot);  // Appel de la méthode delete() pour le Depot

            // Suppression du Commerce
            System.out.println("\nTest de suppression du Commerce...");
            commerceDAO.delete(commerceId);  // Appel de la méthode delete() pour le Commerce

            // Suppression du ContratPartenariat
            System.out.println("\nTest de suppression du ContratPartenariat...");
            contratPartenariatDAO.delete(idContratCommerce, idContratCentre);  // Appel de la méthode delete() pour le ContratPartenariat

            // Suppression du CentreTri
            System.out.println("\nTest de suppression du CentreTri...");
            centreTriDAO.delete(idCentre);  // Appel de la méthode delete() pour le CentreTri

            // Suppression de l'Adresse
            System.out.println("\nTest de suppression de l'Adresse...");
            adresseDAO.delete(adresseId);  // Appel de la méthode delete() pour l'Adresse

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
