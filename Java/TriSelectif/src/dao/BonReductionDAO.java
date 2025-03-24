package dao;

import model.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.UUID;

public class BonReductionDAO {
    private Connection conn;

    public BonReductionDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(BonReduction b) throws SQLException {
        if (b.getIdBon() == null) {
            b.setIdBon(UUID.randomUUID());  // Générer un UUID si l'ID est null
        }

        // Vérifie que Commerce n'est pas null
        if (b.getCommerceBon() == null) {
            throw new SQLException("Commerce est null, impossible de créer le bon de réduction");
        }

        String sql = "INSERT INTO BonReduction (idBon, valeur, bonUtilise, commerce_id, menage_id, dateExpiration) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, b.getIdBon().toString());  // Utilisation de getIdBon().toString() pour convertir le UUID en String
            stmt.setDouble(2, b.getValeur());
            stmt.setBoolean(3, b.getBonUtilise());
            stmt.setString(4, b.getCommerceBon().getIdCommerce().toString());  // Commerce ID
            stmt.setString(5, b.getMenageBon().getNom());  // Menage username
            stmt.setDate(6, Date.valueOf(b.getDateExp()));  // Date d'expiration
            stmt.executeUpdate();
            System.out.println("Bon de réduction ajouté.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer un BonReduction par son ID
    public BonReduction find(UUID idBon) {
        String sql = "SELECT * FROM BonReduction WHERE idBon = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idBon.toString());  // Utiliser idBon pour rechercher
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Créer les objets nécessaires
                UUID idCommerce = UUID.fromString(rs.getString("commerce_id"));
                UUID idMenage = UUID.fromString(rs.getString("menage_id"));
                String nomCommerce = rs.getString("nomCommerce"); // Exemple d'alias pour nom du commerce
                String nomMenage = rs.getString("nomCompte"); // Exemple d'alias pour nom du ménage
                double valeur = rs.getDouble("valeur");
                boolean bonUtilise = rs.getBoolean("bonUtilise");
                LocalDate dateExpiration = rs.getDate("dateExpiration").toLocalDate();

                // Récupérer Commerce et Menage via leurs ID
                Commerce commerce = new Commerce(nomCommerce, null); // Exemple d'initialisation
                Menage menage = new Menage(nomMenage, null, null);  // Exemple d'initialisation

                // Créer et retourner le BonReduction avec toutes les informations
                return new BonReduction(valeur, commerce, menage, dateExpiration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Si le bon de réduction n'est pas trouvé
    }
    
    public void delete(UUID idBon) {
        String sql = "DELETE FROM BonReduction WHERE idBon = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idBon.toString());  // Spécifie l'ID du Bon de réduction à supprimer
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bon de réduction supprimé avec succès.");
            } else {
                System.out.println("Aucun Bon de réduction trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
