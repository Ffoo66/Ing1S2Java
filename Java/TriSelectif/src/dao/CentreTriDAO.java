package dao;
import model.*;
import java.sql.*;

public class CentreTriDAO {
    private Connection conn;

    public CentreTriDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(CentreTri centre, int adresseId) {
        String sql = "INSERT INTO CentreTri (nomCentre, adresse_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, centre.getNomC());
            stmt.setInt(2, adresseId);
            stmt.executeUpdate();

            // Récupérer l'ID généré
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int idCentre = rs.getInt(1);  // Récupérer l'ID généré
                centre.setIdCentre(idCentre); // Associer l'ID à l'objet CentreTri
            }
            System.out.println("Centre de tri ajouté.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Méthode pour récupérer un CentreTri par ID
    public CentreTri find(int idCentre) {
        String sql = "SELECT * FROM CentreTri WHERE idCentre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCentre);  // Recherche par ID du Centre
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nomCentre = rs.getString("nomCentre");
                int adresseId = rs.getInt("adresse_id");

                // Récupérer l'adresse associée à ce CentreTri
                Adresse adresse = new AdresseDAO(conn).find(adresseId);  // Recherche l'adresse correspondante avec l'ID

                // Créer et retourner un objet CentreTri
                return new CentreTri(nomCentre, adresse);  // Crée un CentreTri avec le nom et l'adresse
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Si pas trouvé
    }

}
