package model;
import java.time.*;
import java.util.*;

public class Commerce {
	private UUID idCommerce;
	private String nomCommerce;
	private Adresse adresseCommerce;
	private HashMap<UUID, BonReduction>mapBonsC;
	private HashMap<Integer, ContratPartenariat> mapPartenariats;
	private static HashMap<UUID, Commerce> mapCommerce = new HashMap<UUID, Commerce>();
	
	public UUID getIdCommerce() {
		return this.idCommerce;
	}
	
	public String getNomCommerce() {
		return this.nomCommerce;
	}
	
	public Adresse getAdCommerce() {
		return this.adresseCommerce;
	}
	
	public HashMap<UUID, BonReduction> getMapBons(){
		return this.mapBonsC;
	}
	
	public HashMap<Integer, ContratPartenariat> getMapPartenariats(){
		return this.mapPartenariats;
	}
	
	public static HashMap<UUID, Commerce> getMapCommerce(){
		return mapCommerce;
	}
	
	public void setNomCommerce(String nNom) {
		if (nNom != "") {
			this.nomCommerce = nNom;
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
	
	public double getReduction(int idCentre, int points, String produit) {
		if (this.mapPartenariats.containsKey(idCentre)) {
			if (this.mapPartenariats.get(idCentre).getProduitsAff().containsKey(produit)) {
				return Math.floor(100 * (points/1000.0)
					* this.mapPartenariats.get(idCentre).getProduitsAff().get(produit)) / 10
				;
			}
		}
		return 0;
	}
	
	public String toString() {
		return "Commerce {\n\tId commerce : " + this.idCommerce + "\n\tNom commerce : " + this.nomCommerce
			+ "\n\tAdresse commerce : " + this.adresseCommerce + "\n}\n"
		;
	}

	public Commerce(String nNom, Adresse nAdresse) {
        UUID id = UUID.randomUUID();
        while (mapCommerce.containsKey(id)) {
            id = UUID.randomUUID();
        }
        this.idCommerce = id;
		this.nomCommerce = nNom;
		this.adresseCommerce = nAdresse;
		this.mapBonsC = new HashMap<UUID, BonReduction>();
		this.mapPartenariats = new HashMap<Integer, ContratPartenariat>();
		mapCommerce.put(this.idCommerce, this);
	}
}
