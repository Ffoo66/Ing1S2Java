package model;
import java.time.*;
import java.util.*;

public class CentreTri {
    private int idCentre;
    private String nomCentre;
    private Adresse adresseCentre;
    private String motDePasseCentre;

    private HashMap<UUID, Bac> mapBac;
    private HashMap<UUID, Depot> historiqueDepot;
    private HashMap<UUID, ContratPartenariat> mapPartenaire;
    
	private static HashMap<Integer, CentreTri> mapCentre = new HashMap<Integer, CentreTri>();
	private static int compteCentre;
    
    public int getIdCentre() {
        return this.idCentre;
    }

    public String getNomC() {
        return this.nomCentre;
    }

    public Adresse getAdresseC() {
        return this.adresseCentre;
    }
	
	public String getMDP() {
		return this.motDePasseCentre;
	}

    public HashMap<UUID, Bac> getMapBac() {
        return this.mapBac;
    }

    public Bac getBac(UUID idBac) {
        return this.mapBac.get(idBac);
    }

    public HashMap<UUID, Depot> getMapDepot() {
        return this.historiqueDepot;
    }

    public Depot getDepot(UUID idDepot) {
        return this.historiqueDepot.get(idDepot);
    }

    public HashMap<UUID, ContratPartenariat> getMapPartenaire() {
        return this.mapPartenaire;
    }

    public ContratPartenariat getPartenaire(UUID idPartenaire) {
        return this.mapPartenaire.get(idPartenaire);
    }
    
    public static HashMap<Integer, CentreTri> getMapCentre(){
    	return mapCentre;
    }
    
    public static int getCompteCentre() {
    	return compteCentre;
    }
    
    public void setIdCentre(int nId) {
    	if (nId >= 0 && !mapCentre.containsKey(nId)) {
    		this.idCentre = nId;
    	}
    }
    
    public void setNomC(String nNomC) {
        this.nomCentre = nNomC;
    }
	
	public void setMDP(String nMDP) {
		if (nMDP != "") {
			this.motDePasseCentre = nMDP;
		}
	}

    public void creerBac(Couleur col, int capacite) {
        UUID id = UUID.randomUUID();
        while (mapBac.containsKey(id)) {
            id = UUID.randomUUID();
        }
        
        Bac p = new Bac(id, this, col, capacite);
        mapBac.put(id, p);
    }

    public void supprimerBac(UUID idBac) {
        mapBac.remove(idBac);
    }

    public void placerBac(UUID idBac, Adresse a) {
    	Bac p = mapBac.get(idBac);
        if (p != null) {
            p.setAdresseBac(a);
        }
    }

    public void retirerBac(UUID idBac) {
    	Bac p = mapBac.get(idBac);
        if (p != null) {
            p.setAdresseBac(this.adresseCentre);
            p.getAdresseBac().setNum(0);
        }
    }

    public void retirerRue(Adresse a) {
        for (Bac p : mapBac.values()) {
            if (a.rueEquals(p.getAdresseBac())) {
                p.setAdresseBac(this.adresseCentre);
                p.getAdresseBac().setNum(0);
            }
        }
    }

    public void retirerTout() {
        for (Bac p : mapBac.values()) {
            p.setAdresseBac(this.adresseCentre);
            p.getAdresseBac().setNum(0);
        }
    }

    public ArrayList<Depot> getRes(Couleur col, Type t, LocalTime heureD, LocalTime heureF, LocalDate dateD, LocalDate dateF,
    Adresse a, ResCat cat) {
        ArrayList<Depot> resultat = new ArrayList<Depot>();
        boolean couleurOK;
        boolean typeOK;
        boolean heureOK;
        boolean dateOK;
        boolean rueOK;
        boolean catOK;
        for (Depot d : historiqueDepot.values()) {
            couleurOK = (col == Couleur.toutCol || d.getCouleurDepot().equals(col));
            typeOK = (t == Type.toutType || d.getTypeDepot().equals(t));
            heureOK = (!d.getHoraire().isBefore(heureD) && !d.getHoraire().isAfter(heureF)) ||
            	((!d.getHoraire().isBefore(heureD) || !d.getHoraire().isAfter(heureF)) && heureD.isAfter(heureF))
            ;
            dateOK = (dateD.isAfter(dateF) || (!d.getDate().isBefore(dateD) && !d.getDate().isAfter(dateF)));
            rueOK = (a == null || d.getAdresseDepot().rueEquals(a));
            catOK = (cat == ResCat.total || d.getCorrect().equals(cat));
            if (couleurOK && typeOK && heureOK && dateOK && rueOK && catOK) {
                resultat.add(d);
            }
        }
        return resultat;
    }

    public void collecter() {
        for (Bac b : mapBac.values()) {
        	if (b.getAdresseBac().getNum() <= 0) {
	            b.vider();
        	}
        }
    }

    public void inscrire(String nCompte, String nMDP, Adresse nAdresse) {
        if (Menage.getMapMenage().containsKey(nCompte)) {
            System.out.println("Identifiant déjà existant");
            return;
        }
    	Menage m = new Menage(nCompte, nMDP, nAdresse);
        Menage.getMapMenage().put(m.getNom(), m);
    }
    
    public CentreTri identifierCentre(int nId, String nMDP) {
    	if (CentreTri.getMapCentre().containsKey(nId)) {
    		if (CentreTri.getMapCentre().get(nId).getMDP().equals(nMDP)) {
    			return CentreTri.getMapCentre().get(nId);
    		}
    		else {
    			System.out.println("Mot de passe incorrect");
    			return null;
    		}
    	}
    	else {
    		System.out.println("Identifiant inconnu");
    		return null;
    	}
    }
    
	public String toString() {
		return "CentreTri {\n\tId centre : " + this.idCentre + "\n\tNom centre : " + this.nomCentre
			+ "\n\tAdresse centre : " + this.adresseCentre + "\n\tMDP centre : " + this.motDePasseCentre + "\n}\n"
		;
	}

	public CentreTri(String nomCentre, Adresse adresseCentre, String nMDP) {
    	if (nomCentre != "" && adresseCentre !=  null) {
    		while (mapCentre.containsKey(compteCentre)) {
    			compteCentre++;
    		}
	        this.idCentre = compteCentre;
	        compteCentre++;
	        this.nomCentre = nomCentre;
	        this.adresseCentre = adresseCentre;
	        this.motDePasseCentre = nMDP;
	        this.mapBac = new HashMap<UUID, Bac>();
	        this.historiqueDepot = new HashMap<UUID, Depot>();
	        this.mapPartenaire = new HashMap<UUID, ContratPartenariat>();
	        mapCentre.put(this.idCentre, this);
    	}
    }
}
