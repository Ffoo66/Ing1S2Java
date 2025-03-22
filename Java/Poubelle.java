import java.util.ArrayList;
import java.util.List;

public class Poubelle {
    private String idPoubelle;
    private Adresse adresse;
    private CentreDeTri centreDeTri;
    private List<Bac> listeBacs;

    // Constructeur
    public Poubelle(String idPoubelle, Adresse adresse, CentreDeTri centreDeTri) {
        this.idPoubelle = idPoubelle;
        this.adresse = adresse;
        this.centreDeTri = centreDeTri;
        this.listeBacs = new ArrayList<>();
    }

    // les getters et et les setters
    public String getIdPoubelle() { return idPoubelle; }
    public void setIdPoubelle(String idPoubelle) { this.idPoubelle = idPoubelle; }

    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }

    public CentreDeTri getCentreDeTri() { return centreDeTri; }
    public void setCentreDeTri(CentreDeTri centreDeTri) { this.centreDeTri = centreDeTri; }

    public List<Bac> getListeBacs() { return listeBacs; }

    // pour ajouter un bac à la poubelle
    public void ajouterBac(Bac bac) {
        listeBacs.add(bac);
    }

    // Afficher le contenu des bacs
    public void afficherBacs() {
        System.out.println("Contenu de la poubelle " + idPoubelle + " :");
        for (Bac bac : listeBacs) {
            System.out.println("- Bac couleur : " + bac.getCouleur() + " | Poids : " + bac.getPoids() + "/" + bac.getCapacite());
        }
    }
}
