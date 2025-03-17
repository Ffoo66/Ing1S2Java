
// classe menage
import java.util.ArrayList;
import java.util.List;

public class Menage {
    private String nom;
    private int pointsFidelite;
    private List<Depot> historiqueDepots;
    private String compte;
    private Adresse adresse;

    
    public Menage(String nom, String compte, Adresse adresse) {
        this.nom = nom;
        this.compte = compte;
        this.adresse = adresse;
        this.pointsFidelite = 0;
        this.historiqueDepots = new ArrayList<>();
    }

    // getters et setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPointsFidelite() { return pointsFidelite; }
    public void ajouterPoints(int points) { this.pointsFidelite += points; }
    public void retirerPoints(int points) { this.pointsFidelite -= points; }

    public String getCompte() { return compte; }
    public void setCompte(String compte) { this.compte = compte; }

    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }

  
    public void ajouterDepot(Depot depot) {
        historiqueDepots.add(depot);
        this.ajouterPoints(depot.getPointsGagnes());
    }

    
    public void consulterHistorique() {
        System.out.println("Historique des dépôts de " + nom + " :");
        for (Depot depot : historiqueDepots) {
            depot.afficherDepot();
        }
    }
}


// classe depot

import java.util.Date;

public class Depot {
    private Date date;
    private String typeDechet;
    private int quantite;
    private int pointsGagnes;

    
    public Depot(Date date, String typeDechet, int quantite, int pointsGagnes) {
        this.date = date;
        this.typeDechet = typeDechet;
        this.quantite = quantite;
        this.pointsGagnes = pointsGagnes;
    }

    // getters et setter
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getTypeDechet() { return typeDechet; }
    public void setTypeDechet(String typeDechet) { this.typeDechet = typeDechet; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public int getPointsGagnes() { return pointsGagnes; }
    public void setPointsGagnes(int pointsGagnes) { this.pointsGagnes = pointsGagnes; }

    // Afficher les infos du dépôt
    public void afficherDepot() {
        System.out.println("Dépôt du " + date + " : " + typeDechet + " - " + quantite + "kg - " + pointsGagnes + " points");
    }
}









