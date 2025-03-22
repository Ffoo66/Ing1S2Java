import java.util.ArrayList;
import java.util.Date;

public class Commerce {
    private String nomCommerce;
    private ArrayList<String> categoriesProduits;
    private ArrayList<ContratPartenariat> contrats;


    public Commerce(String nomCommerce) {
        this.nomCommerce = nomCommerce;
        this.categoriesProduits = new ArrayList<>();
        this.contrats = new ArrayList<>();
    }

    public String getNomCommerce() {
        return nomCommerce;
    }

    public ArrayList<String> getCategoriesProduits() {
        return categoriesProduits;
    }

    public ArrayList<ContratPartenariat> getContrats() {
        return contrats;
    }


    public void setNomCommerce(String nouveauNom) {
        if (nouveauNom != null && !nouveauNom.isEmpty()) {
            this.nomCommerce = nouveauNom;
        }
    }

    public void ajouterCategorie(String categorie) {
        if (!categoriesProduits.contains(categorie)) {
            categoriesProduits.add(categorie);
        }
    }

    public void ajouterContrat(ContratPartenariat c) {
        contrats.add(c);
    }

    
    public void afficherContratsActifs() {
        Date today = new Date();
        System.out.println("Contrats actifs pour " + nomCommerce + " :");
        for (ContratPartenariat c : contrats) {
            if (c.getDateDebut().before(today) && c.getDateFin().after(today)) {
                System.out.println(c);
            }
        }
    }


    public String toString() {
        return "Commerce: " + nomCommerce + "\nCatégories: " + categoriesProduits + "\nContrats: " + contrats;
    }
}
