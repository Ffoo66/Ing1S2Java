package dao;

import model.Commerce;
import model.Adresse;
import java.sql.*;
import java.time.LocalDate;
import java.util.UUID;

public class CommerceDAO {
    private Connection conn;

    public CommerceDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(Commerce c, int adresseId) {
        String sql = "INSERT INTO Commerce (idCommerce, nomCommerce, adresse_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getIdCommerce().toString());
            stmt.setString(2, c.getNomCommerce());
            stmt.setInt(3, adresseId);
            stmt.executeUpdate();
            System.out.println("Commerce inséré.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Commerce find(String nomCommerce) {
        String sql = "SELECT * FROM Commerce WHERE nomCommerce = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomCommerce); // Utiliser nomCommerce pour rechercher
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Créer et retourner un objet Commerce avec les données récupérées
                return new Commerce(rs.getString("nomCommerce"), null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Si le commerce n'est pas trouvé
    }

    // Méthode pour récupérer une adresse par son id
    private Adresse getAdresseById(int adresseId) {
        Adresse adresse = null;
        String sql = "SELECT * FROM Adresse WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, adresseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                adresse = new Adresse(
                    rs.getInt("numero"),
                    rs.getString("nomRue"),
                    rs.getInt("codePostal"),
                    rs.getString("ville")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adresse;
    }
}
