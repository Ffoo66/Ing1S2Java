package test;
import dao.*;
import model.*;
import java.sql.*;
import java.util.UUID;

public class FindTestDAO {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tri_selectif";
        String user = "root";				// À adapter
        String password = "cytech0001";		// À adapter

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie !");

            AdresseDAO adresseDAO = new AdresseDAO(conn);
            MenageDAO menageDAO = new MenageDAO(conn);
            DepotDAO depotDAO = new DepotDAO(conn);
            CommerceDAO commerceDAO = new CommerceDAO(conn);
            ContratPartenariatDAO contratDAO = new ContratPartenariatDAO(conn);
            BacDAO bacDAO = new BacDAO(conn);
            BonReductionDAO bonDAO = new BonReductionDAO(conn);
            CentreTriDAO centreTriDAO = new CentreTriDAO(conn);

            // Adresse par ID
            System.out.println("Test récupération de l'adresse...");
            Adresse retrievedAdresse = adresseDAO.find(12);
            if (retrievedAdresse != null) {
                System.out.println("Adresse trouvée :");
                System.out.println("Numéro : " + retrievedAdresse.getNum());
                System.out.println("Nom de la rue : " + retrievedAdresse.getNomRue());
                System.out.println("Code Postal : " + retrievedAdresse.getCodeP());
                System.out.println("Ville : " + retrievedAdresse.getVille());
            }
            else {
                System.out.println("Adresse non trouvée.");
            }

            // Menage par nom
            System.out.println("Test récupération du Menage...");
            Menage retrievedMenage = menageDAO.find("userTest");
            if (retrievedMenage != null) {
                System.out.println("Ménage trouvé : " + retrievedMenage.getNom());
            } else {
                System.out.println("Ménage non trouvé.");
            }

            // Depot par ID
            System.out.println("Test récupération du Depot...");
            UUID idDepot = UUID.randomUUID();
            Depot retrievedDepot = depotDAO.find(idDepot);
            if (retrievedDepot != null) {
                System.out.println("Depot trouvé :");
                System.out.println("ID Depot: " + retrievedDepot.getIdDepot());
            }
            else {
                System.out.println("Depot non trouvé.");
            }

            // Commerce par ID
            System.out.println("Test récupération du Commerce...");
            UUID idCommerce = UUID.randomUUID();
            Commerce retrievedCommerce = commerceDAO.find(idCommerce);
            if (retrievedCommerce != null) {
                System.out.println("Commerce trouvé : " + retrievedCommerce.getNomCommerce());
            }
            else {
                System.out.println("Commerce non trouvé.");
            }

            // ContratPartenariat par ID Commerce et ID Centre
            System.out.println("Test récupération du ContratPartenariat...");
            UUID idCo = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
            int idCe = 1;
            ContratPartenariat retrievedContrat = contratDAO.find(idCo, idCe);
            if (retrievedContrat != null) {
                System.out.println("ContratPartenariat trouvé :");
                System.out.println("Centre: " + retrievedContrat.getCentrePartner().getNomC());
                System.out.println("Commerce: " + retrievedContrat.getCommercePartner().getNomCommerce());
            }
            else {
                System.out.println("ContratPartenariat non trouvé.");
            }

            // Bac par ID
            System.out.println("Test récupération du Bac...");
            UUID idBac = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
            Bac retrievedBac = bacDAO.find(idBac);
            if (retrievedBac != null) {
                System.out.println("Bac trouvé :");
                System.out.println("ID Bac: " + retrievedBac.getIdBac());
                System.out.println("Centre: " + retrievedBac.getCentreDeTri().getNomC());
                System.out.println("Couleur: " + retrievedBac.getCouleurBac());
                System.out.println("Capacité: " + retrievedBac.getCapacite());
                System.out.println("Contenu: " + retrievedBac.getContenu());
            }
            else {
                System.out.println("Bac non trouvé.");
            }


            // BonReduction par ID
            System.out.println("Test récupération du BonReduction...");
            UUID idBon = UUID.randomUUID();
            BonReduction retrievedBon = bonDAO.find(idBon);
            if (retrievedBon != null) {
                System.out.println("Bon de réduction trouvé :");
                System.out.println("Valeur du bon: " + retrievedBon.getValeur());
            }
            else {
                System.out.println("Bon de réduction non trouvé.");
            }

            // CentreTri par ID
            System.out.println("Test récupération du CentreTri...");
            int idCentre = 1;
            CentreTri retrievedCentre = centreTriDAO.find(idCentre);
            if (retrievedCentre != null) {
                System.out.println("CentreTri trouvé :");
                System.out.println("Nom du centre : " + retrievedCentre.getNomC());
                System.out.println("Adresse : " + retrievedCentre.getAdresseC().getNomRue());
            }
            else {
                System.out.println("CentreTri non trouvé.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}