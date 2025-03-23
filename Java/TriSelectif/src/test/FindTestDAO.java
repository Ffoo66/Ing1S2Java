package test;

import dao.*;
import model.*;
import java.sql.*;
import java.util.UUID;

public class FindTestDAO {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tri_selectif";
        String user = "root"; // À adapter
        String password = "cytech0001"; // À adapter

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie!");

            // Création des DAO
            AdresseDAO adresseDAO = new AdresseDAO(conn);
            MenageDAO menageDAO = new MenageDAO(conn);
            DepotDAO depotDAO = new DepotDAO(conn);
            CommerceDAO commerceDAO = new CommerceDAO(conn);
            ContratPartenariatDAO contratDAO = new ContratPartenariatDAO(conn);
            BacDAO bacDAO = new BacDAO(conn);
            BonReductionDAO bonDAO = new BonReductionDAO(conn);
            CentreTriDAO centreTriDAO = new CentreTriDAO(conn);

            // 1. Test find() pour récupérer une Adresse par ID (ici, par exemple, ID d'adresse)
            System.out.println("Test récupération de l'adresse...");
            Adresse retrievedAdresse = adresseDAO.find(12);  // Remplacer par un ID valide
            if (retrievedAdresse != null) {
                System.out.println("Adresse trouvée :");
                System.out.println("Numéro : " + retrievedAdresse.getNum());
                System.out.println("Nom de la rue : " + retrievedAdresse.getNomRue());
                System.out.println("Code Postal : " + retrievedAdresse.getCodeP());
                System.out.println("Ville : " + retrievedAdresse.getVille());
            } else {
                System.out.println("Adresse non trouvée.");
            }

            // 2. Test find() pour récupérer un Menage par nom
            System.out.println("Test récupération du Menage...");
            Menage retrievedMenage = menageDAO.find("userTest");  // Recherche par nom
            if (retrievedMenage != null) {
                System.out.println("Ménage trouvé : " + retrievedMenage.getNom());
            } else {
                System.out.println("Ménage non trouvé.");
            }

            // 3. Test find() pour récupérer un Depot par ID
            System.out.println("Test récupération du Depot...");
            UUID idDepot = UUID.randomUUID();  // Remplacer par un ID valide
            Depot retrievedDepot = depotDAO.find(idDepot);  // Recherche par ID
            if (retrievedDepot != null) {
                System.out.println("Depot trouvé :");
                System.out.println("ID Depot: " + retrievedDepot.getIdDepot());
            } else {
                System.out.println("Depot non trouvé.");
            }

            // 4. Test find() pour récupérer un Commerce par nom
            System.out.println("Test récupération du Commerce...");
            Commerce retrievedCommerce = commerceDAO.find("Super U");  // Recherche par nom
            if (retrievedCommerce != null) {
                System.out.println("Commerce trouvé : " + retrievedCommerce.getNomCommerce());
            } else {
                System.out.println("Commerce non trouvé.");
            }

         // Test find() pour récupérer un ContratPartenariat par ID du Commerce et ID du Centre
            System.out.println("Test récupération du ContratPartenariat...");
            UUID idCommerce = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");  // Remplacer par un UUID valide pour le Commerce
            int idCentre = 1;  // Remplacer par un ID valide pour le Centre
            ContratPartenariat retrievedContrat = contratDAO.find(idCommerce, idCentre);  // Recherche par ID du Commerce et du Centre
            if (retrievedContrat != null) {
                System.out.println("ContratPartenariat trouvé :");
                System.out.println("Centre: " + retrievedContrat.getCentrePartner().getNomC());  // Accède aux informations du centre
                System.out.println("Commerce: " + retrievedContrat.getCommercePartner().getNomCommerce());  // Accède aux informations du commerce
            } else {
                System.out.println("ContratPartenariat non trouvé.");
            }



            // Test find() pour récupérer un Bac par ID
            System.out.println("Test récupération du Bac...");
            UUID idBac = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");  // Remplacer par un UUID valide pour le Bac
            Bac retrievedBac = bacDAO.find(idBac);  // Recherche par ID du Bac
            if (retrievedBac != null) {
                System.out.println("Bac trouvé :");
                System.out.println("ID Bac: " + retrievedBac.getIdBac());
                System.out.println("Centre: " + retrievedBac.getCentreDeTri().getNomC());
                System.out.println("Couleur: " + retrievedBac.getCouleurBac());
                System.out.println("Capacité: " + retrievedBac.getCapacite());
                System.out.println("Contenu: " + retrievedBac.getContenu());
            } else {
                System.out.println("Bac non trouvé.");
            }


            // 7. Test find() pour récupérer un BonReduction par ID
            System.out.println("Test récupération du BonReduction...");
            UUID idBon = UUID.randomUUID();  // Remplacer par un ID valide
            BonReduction retrievedBon = bonDAO.find(idBon);  // Recherche par ID
            if (retrievedBon != null) {
                System.out.println("Bon de réduction trouvé :");
                System.out.println("Valeur du bon: " + retrievedBon.getValeur());
            } else {
                System.out.println("Bon de réduction non trouvé.");
            }

            // Test find() pour récupérer un CentreTri par ID
            System.out.println("Test récupération du CentreTri...");
            //int idCentre = 1;  // Remplace par un ID valide pour le Centre
            CentreTri retrievedCentre = centreTriDAO.find(idCentre);  // Recherche par ID du CentreTri
            if (retrievedCentre != null) {
                System.out.println("CentreTri trouvé :");
                System.out.println("Nom du centre : " + retrievedCentre.getNomC());
                System.out.println("Adresse : " + retrievedCentre.getAdresseC().getNomRue());
            } else {
                System.out.println("CentreTri non trouvé.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
