package test;
import dao.*;
import java.sql.*;
import java.util.UUID;

public class DeleteTestDAO {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tri_selectif";
        String user = "root";				// À adapter
        String password = "cytech0001";		// À adapter

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie !");

            MenageDAO menageDAO = new MenageDAO(conn);
            DepotDAO depotDAO = new DepotDAO(conn);
            CommerceDAO commerceDAO = new CommerceDAO(conn);
            ContratPartenariatDAO contratPartenariatDAO = new ContratPartenariatDAO(conn);
            BacDAO bacDAO = new BacDAO(conn);
            CentreTriDAO centreTriDAO = new CentreTriDAO(conn);
            AdresseDAO adresseDAO = new AdresseDAO(conn);
            
            
            // Utilisation des identifiants générés dans InsertTestDAO
            int adresseId = 1;
            
            int idCentre = 1;
            
            UUID bacId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
            
            String nomCompte = "familleDupont";
            
            UUID commerceId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
            
            UUID idContratCommerce = commerceId;
            int idContratCentre = idCentre;

            UUID idDepot = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
            
            
            // Suppression
            System.out.println("\nTest de suppression de Ménage...");
            menageDAO.delete(nomCompte);

            System.out.println("\nTest de suppression de Bac...");
            bacDAO.delete(bacId);
            
            System.out.println("\nTest de suppression de Depot...");
            depotDAO.delete(idDepot);

            System.out.println("\nTest de suppression de Commerce...");
            commerceDAO.delete(commerceId);

            System.out.println("\nTest de suppression de ContratPartenariat...");
            contratPartenariatDAO.delete(idContratCommerce, idContratCentre);
            
            System.out.println("\nTest de suppression de CentreTri...");
            centreTriDAO.delete(idCentre);

            System.out.println("\nTest de suppression de Adresse...");
            adresseDAO.delete(adresseId);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}