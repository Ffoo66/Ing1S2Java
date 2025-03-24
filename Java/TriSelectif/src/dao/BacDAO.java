package dao;
import model.*;
import java.sql.*;
import java.util.UUID;

public class BacDAO {
    private Connection conn;

    public BacDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(Bac b, int centreId, int adresseId) {
        String sql = "INSERT INTO Bac (idBac, couleur, capacite, contenu, centre_id, adresse_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, b.getIdBac().toString());
            stmt.setString(2, b.getCouleurBac().name());
            stmt.setInt(3, b.getCapacite());
            stmt.setInt(4, b.getContenu());
            stmt.setInt(5, centreId);
            stmt.setInt(6, adresseId);
            stmt.executeUpdate();
            System.out.println("Bac inséré.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Bac find(UUID idBac) {
        String sql = "SELECT * FROM Bac WHERE idBac = ?";  // Recherche par ID du Bac
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idBac.toString());  // Recherche par ID du Bac
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Récupérer les informations du Bac
                String couleur = rs.getString("couleur");  // Assurez-vous que la colonne couleur est bien présente
                int capacite = rs.getInt("capacite");
                int contenu = rs.getInt("contenu");
                int centreId = rs.getInt("centre_id");  // Récupérer l'ID du CentreTri
                int adresseId = rs.getInt("adresse_id");  // Récupérer l'ID de l'Adresse associée au Bac

                // Créer l'objet CentreTri avec l'ID du Centre
                CentreTri centre = new CentreTriDAO(conn).find(centreId);  // Recherche du CentreTri par ID

                // Récupérer l'adresse associée à ce Bac
                Adresse adresse = new AdresseDAO(conn).find(adresseId);  // Recherche l'adresse correspondante avec l'ID

                // Convertir la couleur récupérée en valeur de l'énumération Couleur
                Couleur bacCouleur = Couleur.valueOf(couleur);  // Assurez-vous que la valeur correspond à un élément de l'énumération Couleur

                // Créer et retourner l'objet Bac
                Bac bac = new Bac(idBac, centre, bacCouleur, capacite);  // Utilisation du constructeur correct
                bac.setContenu(contenu);  // Initialiser le contenu du Bac

                return bac;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Si le Bac n'est pas trouvé
    }
    
    public void delete(UUID idBac) {
        String sql = "DELETE FROM Bac WHERE idBac = ?";  // Suppression du Bac par son ID
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idBac.toString());  // Spécifie l'ID du Bac à supprimer
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bac supprimé avec succès.");
            } else {
                System.out.println("Aucun Bac trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
