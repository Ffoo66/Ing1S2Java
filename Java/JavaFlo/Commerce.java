import java.time.LocalDate;
import java.util.*;

public class Commerce {
	private UUID idCommerce;
	private String nomCommerce;
	private Adresse adresseCommerce;
	private ArrayList<String> produitsAff;
	private HashMap<UUID, BonReduction>mapBonsC;
	private HashMap<Integer, ContratPartenariat> mapPartenariats;
	
	public UUID getIdCommerce() {
		return this.idCommerce;
	}
	
	public String getNomCommerce() {
		return this.nomCommerce;
	}
	
	public Adresse getAdCommerce() {
		return this.adresseCommerce;
	}
	
	public ArrayList<String> getProduitsAff(){
		return this.produitsAff;
	}
	
	public HashMap<UUID, BonReduction> getMapBons(){
		return this.mapBonsC;
	}
	
	public HashMap<Integer, ContratPartenariat> getMapPartner(){
		return this.mapPartenariats;
	}
	
	public void setNomCommerce(String nNom) {
		if (nNom != "") {
			this.nomCommerce = nNom;
		}
	}
	
	public void ajoutProduitAff(String nProduit) {
		byte i = 0;
		for (i = 0; i < this.produitsAff.size(); i++) {
			if (nProduit.toLowerCase().equals(this.produitsAff.get(i))) {
				return;
			}
		}
		this.produitsAff.add(nProduit.toLowerCase());
	}
	
	public void supProduitAff(String nProduit) {
		byte i = 0;
		for (i = 0; i < this.produitsAff.size(); i++) {
			if (nProduit.toLowerCase().equals(this.produitsAff.get(i))) {
				this.produitsAff.remove(i);
			}
		}
	}
	
	public void ajoutBon(BonReduction nBon) {
		this.mapBonsC.put(nBon.getIdBon(), nBon);
	}
	
	public void ajoutContrat(CentreTri nCentre, LocalDate dateDP, LocalDate dateFP) {
		ContratPartenariat nContrat = new ContratPartenariat(nCentre, this, dateDP, dateFP);
		if (this.mapPartenariats.containsKey(nContrat.getIdCentreP())) {
			this.mapPartenariats.get(nContrat.getIdCentreP()).prolongPartner(dateDP, dateFP);
			return;
		}
		this.mapPartenariats.put(nContrat.getIdCentreP(), nContrat);
		nCentre.getMapPartenaire().put(this.idCommerce , nContrat);
	}
	
	public double getReduction(int points) {
		return points/10.0;
	}
	
	public String toString() {
		return "Commerce {\nId commerce : " + this.idCommerce + "\nNom commerce : " + this.nomCommerce
			+ "\nAdresse commerce : " + this.adresseCommerce + "\nProduits affectés : " + this.produitsAff
			+ "\nMap bons : " + this.mapBonsC + "\nMap contrats : " + this.mapPartenariats + "\n}"
		;
	}

	public Commerce(UUID nId, String nNom, Adresse nAdresse, LocalDate nDateDP, LocalDate nDateFP) {
		this.idCommerce = nId;
		this.nomCommerce = nNom;
		this.adresseCommerce = nAdresse;
		this.produitsAff = new ArrayList<String>();
		this.mapBonsC = new HashMap<UUID, BonReduction>();
		this.mapPartenariats = new HashMap<Integer, ContratPartenariat>();
	}
}
