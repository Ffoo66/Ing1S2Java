public class Bac {
    private String idBac;
    private Couleur couleur;
    private int capacite; // en kg
    private int poids;    // poids actuel (en kg)
    private Poubelle poubelle; //  c'est laréférence à la poubelle qui contient ce bac

    // Constructeur
    public Bac(String idBac, Couleur couleur, int capacite) {
        this.idBac = idBac;
        this.couleur = couleur;
        this.capacite = capacite;
        this.poids = 0;
    }

    //  les getters et setters
    public String getIdBac() { return idBac; }
    public void setIdBac(String idBac) { this.idBac = idBac; }

    public Couleur getCouleur() { return couleur; }
    public void setCouleur(Couleur couleur) { this.couleur = couleur; }

    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }

    public int getPoids() { return poids; }

    public Poubelle getPoubelle() { return poubelle; }
    public void setPoubelle(Poubelle poubelle) { this.poubelle = poubelle; }

    // Ajouter du déchet (si possible)
    public boolean ajouterDechet(int poidsAjoute, Type typeDechet) {
        if (poids + poidsAjoute <= capacite) {
            this.poids += poidsAjoute;
            System.out.println("Déchet ajouté au bac " + idBac);
            return true;
        } else {
            System.out.println("Bac " + idBac + " plein !");
            return false;
        }
    }

    // pour vider le bac
    public void vider() {
        this.poids = 0;
        System.out.println("Bac " + idBac + " vidé.");
    }
}
