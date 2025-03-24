package dao;
import model.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.UUID;

public class ContratPartenariatDAO {
    private Connection conn;

    public ContratPartenariatDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(ContratPartenariat cp) {
        String sql = "INSERT INTO ContratPartenariat (idCentreP, idCommerceP, estPartenaire, dateDebut, dateFin) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cp.getIdCentreP());
            stmt.setString(2, cp.getIdCommerceP().toString());
            stmt.setBoolean(3, cp.getEstPartner());
            stmt.setDate(4, Date.valueOf(cp.getDateDP()));
            stmt.setDate(5, Date.valueOf(cp.getDateFP()));
            stmt.executeUpdate();
            System.out.println("Contrat de partenariat ajouté.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Méthode pour récupérer un ContratPartenariat par ID du Commerce et ID du Centre
    public ContratPartenariat find(UUID idCommerce, int idCentre) {
        String sql = "SELECT * FROM ContratPartenariat WHERE idCommerceP = ? AND idCentreP = ?";  // Recherche par idCommerceP et idCentreP
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idCommerce.toString());  // Cherche par ID du Commerce (UUID)
            stmt.setInt(2, idCentre);  // Cherche par ID du Centre (int)
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Récupérer les informations du ContratPartenariat
                boolean estPartenaire = rs.getBoolean("estPartenaire");
                Date dateDebut = rs.getDate("dateDebut");
                Date dateFin = rs.getDate("dateFin");

                // Récupérer les informations du CentreTri associé
                int centreId = rs.getInt("idCentreP");
                String nomCentre = rs.getString("nomCentre");
                
                // Recherche de l'adresse du CentreTri (si nécessaire, tu devras ajouter une méthode pour obtenir l'adresse)
                // Exemple : adresseCentre = adresseDAO.find(adresseId);
                Adresse adresseCentre = new Adresse(centreId, "Nom Rue", 75000, "Ville");  // Cela dépend de ta structure d'adresse

                CentreTri centre = new CentreTri(nomCentre, adresseCentre);  // Créer l'objet CentreTri avec le nom et l'adresse

                // Récupérer le Commerce associé
                UUID commerceId = UUID.fromString(rs.getString("idCommerceP"));
                String nomCommerce = rs.getString("nomCommerce");
                Commerce commerce = new Commerce(nomCommerce, adresseCentre);  // Créer l'objet Commerce

                // Retourner un ContratPartenariat avec ces données
                return new ContratPartenariat(centre, commerce, dateDebut.toLocalDate(), dateFin.toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Si pas trouvé
    }
    
    public void delete(UUID idCommerce, int idCentre) {
        String sql = "DELETE FROM ContratPartenariat WHERE idCommerceP = ? AND idCentreP = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idCommerce.toString());  // Spécifie l'ID du Commerce (UUID)
            stmt.setInt(2, idCentre);  // Spécifie l'ID du Centre (int)
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contrat de partenariat supprimé avec succès.");
            } else {
                System.out.println("Aucun Contrat de partenariat trouvé avec ces identifiants.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
