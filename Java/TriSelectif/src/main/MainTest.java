package main;

import test.*;
import java.sql.*;

public class MainTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tri_selectif";
        String user = "root";			// À adapter
        String password = "cytech0001";	// À adapter

        try (Connection connect = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie!");

            // Appeler InsertTestDAO pour insérer des données
            System.out.println("Début du test d'insertion...");
            InsertTestData.main(new String[]{});

            // Appeler FindTestDAO pour tester les recherches
            System.out.println("Début du test de recherche...");
            FindTestDAO.main(new String[]{});

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
