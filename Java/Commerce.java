import java.time.LocalDate;
import java.util.ArrayList;

public class Commerce {
	private int idCommerce;
	private String nomCommerce;
	private Adresse adresseCommerce;
	private ArrayList<String> produitsAff;
	private ArrayList<BonReduction> listeBonsC;
	private ArrayList<ContratPartenariat> listePartenariats;
	
	public int getIdCommerce() {
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
	
	public ArrayList<BonReduction> getListeBons(){
		return this.listeBonsC;
	}
	
	public ArrayList<ContratPartenariat> getListePartner(){
		return this.listePartenariats;
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
		byte i = 0;
		for (i = 0; i < this.listeBonsC.size(); i++) {
			if (nBon.getIdBon() == (this.listeBonsC.get(i).getIdBon())) {
				return;
			}
		}
		this.listeBonsC.add(nBon);
	}
	
	public void ajoutContrat(CentreTri nCentre, LocalDate dateDP, LocalDate dateFP) {
		ContratPartenariat nContrat = new ContratPartenariat(nCentre, this, dateDP, dateFP);
		byte i = 0;
		for (i = 0; i < this.listePartenariats.size(); i++) {
			if (nContrat.getIdPartenariat() == this.listePartenariats.get(i).getIdPartenariat()) {
				this.listePartenariats.get(i).prolongPartner(dateDP, dateFP);
				return;
			}
		}
		this.listePartenariats.add(nContrat);
		//nCentre.getListePartenariats().add(nContrat);
	}
	
	public double getReduction(int points) {
		return points/10.0;
	}
	
	public String toString() {
		return "Commerce {\nId commerce : " + this.idCommerce + "\nNom commerce : " + this.nomCommerce
			+ "\nAdresse commerce : " + this.adresseCommerce + "\nProduits affectés : " + this.produitsAff
			+ "\nListe bons : " + this.listeBonsC + "\nListe contrats : " + this.listePartenariats + "\n}"
		;
	}

	public Commerce(int nId, String nNom, Adresse nAdresse, LocalDate nDateDP, LocalDate nDateFP) {
		if (nId > 0) {
			this.idCommerce = nId;
			this.nomCommerce = nNom;
			this.adresseCommerce = nAdresse;
			this.produitsAff = new ArrayList<String>();
			this.listeBonsC = new ArrayList<BonReduction>();
			this.listePartenariats = new ArrayList<ContratPartenariat>();
		}
	}
}
