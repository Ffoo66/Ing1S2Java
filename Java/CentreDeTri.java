import java.util.*;

public class CentreDeTri {
    private String idCentre;
    private String nomCentre;
    private Adresse adresseCentre;

    private Map<String, Poubelle> mapPoubelle;
    private Map<String, Boolean> mapPoubPleine;
    private Map<Integer, Depot> historiqueDepot;
    private Map<Integer, Menage> mapMenage;

    // Constructeur
    public CentreDeTri(String idCentre, String nomCentre, Adresse adresseCentre) {
        this.idCentre = idCentre;
        this.nomCentre = nomCentre;
        this.adresseCentre = adresseCentre;
        this.mapPoubelle = new HashMap<>();
        this.mapPoubPleine = new HashMap<>();
        this.historiqueDepot = new HashMap<>();
        this.mapMenage = new HashMap<>();
    }

    // Getters & Setters
    public String getIdCentre() {
        return idCentre;
    }

    public String getNomC() {
        return nomCentre;
    }

    public void setNomC(String nNomC) {
        this.nomCentre = nNomC;
    }

    public Adresse getAdresseC() {
        return adresseCentre;
    }

    public Map<String, Poubelle> getMapPoubelle() {
        return mapPoubelle;
    }

    public Map<String, Boolean> getMapPoubPleine() {
        return mapPoubPleine;
    }

    public boolean getPoubPleine(String idPoub) {
        return mapPoubPleine.getOrDefault(idPoub, false);
    }

    public Poubelle getPoubelle(String idPoub) {
        return mapPoubelle.get(idPoub);
    }

    public Map<Integer, Menage> getMapMenage() {
        return mapMenage;
    }

    public Menage getMenage(int idMenage) {
        return mapMenage.get(idMenage);
    }

    public Depot getDepot(int idDepot) {
        return historiqueDepot.get(idDepot);
    }

    // Méthodes principales

    public boolean creerPoubelle(Couleur col, int capacite) {
        String id = UUID.randomUUID().toString();
        if (mapPoubelle.containsKey(id)) return false;

        Poubelle p = new Poubelle(id, col, capacite);
        mapPoubelle.put(id, p);
        mapPoubPleine.put(id, false);
        return true;
    }

    public void supprimerPoubelle(String idPoub) {
        mapPoubelle.remove(idPoub);
        mapPoubPleine.remove(idPoub);
    }

    public void placerPoubelle(String idPoub, Rue r) {
        Poubelle p = mapPoubelle.get(idPoub);
        if (p != null) {
            p.setRue(r);
        }
    }

    public void retirerPoubelle(String idPoub) {
        Poubelle p = mapPoubelle.get(idPoub);
        if (p != null) {
            p.setRue(null);
        }
    }

    public void retirerRue(Rue r) {
        for (Poubelle p : mapPoubelle.values()) {
            if (r.equals(p.getRue())) {
                p.setRue(null);
            }
        }
    }

    public void retirerTout() {
        for (Poubelle p : mapPoubelle.values()) {
            p.setRue(null);
        }
    }

    public void majPoubelle(String idPoub) {
        Poubelle p = mapPoubelle.get(idPoub);
        if (p != null) {
            boolean pleine = p.getContenu() >= p.getCapacite();
            mapPoubPleine.put(idPoub, pleine);
        }
    }

    public void ajoutDepot(Depot d) {
        historiqueDepot.put(d.getId(), d);
    }

    public int getRes(Couleur col, Type t, int heureD, int heureF, Date dateD, Date dateF, Rue r, ResCat cat) {
        int resultat = 0;

        for (Depot d : historiqueDepot.values()) {
            boolean couleurOK = d.getCouleur().equals(col);
            boolean typeOK = d.getType().equals(t);
            boolean heureOK = d.getHeure() >= heureD && d.getHeure() <= heureF;
            boolean dateOK = !d.getDate().before(dateD) && !d.getDate().after(dateF);
            boolean rueOK = d.getRue().equals(r);
            boolean catOK = d.getCategorie().equals(cat);

            if (couleurOK && typeOK && heureOK && dateOK && rueOK && catOK) {
                resultat++;
            }
        }

        return resultat;
    }

    public void collecter() {
        for (Poubelle p : mapPoubelle.values()) {
            p.vider(); // méthode à créer dans Poubelle
            mapPoubPleine.put(p.getId(), false);
        }
    }

    public void inscrire(Menage m) {
        mapMenage.put(m.getId(), m);
    }
}
