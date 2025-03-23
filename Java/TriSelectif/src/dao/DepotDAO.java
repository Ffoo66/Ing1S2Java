package dao;
import model.Depot;
import java.sql.*;
import java.util.UUID;

public class DepotDAO {
    private Connection conn;

    public DepotDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(Depot d, int adresseId) {
        String sql = "INSERT INTO Depot (idDepot, poidsDepot, couleur, typeDechet, resultat, pointsGagnes, dateDepot, heureDepot, adresse_id, menage_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, d.getIdDepot().toString());
            stmt.setInt(2, d.getPoidsDepot());
            stmt.setString(3, d.getCouleurDepot().name());
            stmt.setString(4, d.getTypeDepot().name());
            stmt.setString(5, d.getCorrect().name());
            stmt.setInt(6, d.getPtsGagnes());
            stmt.setDate(7, Date.valueOf(d.getDate()));
            stmt.setTime(8, Time.valueOf(d.getHoraire()));
            stmt.setInt(9, adresseId);
            stmt.setString(10, d.getUtilDepot().getNom());
            stmt.executeUpdate();
            System.out.println("Dépôt inséré.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Depot find(UUID idDepot) {
        String sql = "SELECT * FROM Depot WHERE idDepot = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idDepot.toString());  // Utiliser idDepot (UUID) pour rechercher
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Créer et retourner un objet Depot avec les données récupérées
                return new Depot(UUID.fromString(rs.getString("idDepot")),  // Assurez-vous d'utiliser les bonnes colonnes pour la création de l'objet Depot
                                 rs.getInt("poidsDepot"), 
                                 null, 
                                 null, 
                                 null,
                                 null,
                                 rs.getInt("pointsGagnes"),
                                 null,
                                 rs.getDate("dateDepot").toLocalDate(),
                                 rs.getTime("heureDepot").toLocalTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Si le dépôt n'est pas trouvé
    }
    
 // Exemple de suppression dans DepotDAO
    public void deleteByMenage(String menageNomCompte) {
        String sql = "DELETE FROM Depot WHERE menage_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, menageNomCompte); // Utiliser le nom du compte pour référencer le ménage
            stmt.executeUpdate();
            System.out.println("Dépôts associés au ménage supprimés.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
