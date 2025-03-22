import java.time.LocalDate;

public class BonReduction {
	private int idBon;
	private double valeur;
	private boolean bonUtilise;
	private Commerce commerceBon;
	private Menage menageBon;
	private LocalDate dateExpiration;
	
	public int getIdBon() {
		return this.idBon;
	}
	
	public double getValeur() {
		return this.valeur;
	}
	
	public boolean getBonUtilise() {
		return this.bonUtilise;
	}
	
	public Commerce getCommerceBon() {
		return this.commerceBon;
	}
	
	public Menage getMenageBon() {
		return this.menageBon;
	}
	
	public LocalDate getDateExp() {
		return this.dateExpiration;
	}
	
	public void utiliser() {
		this.bonUtilise = true;
	}

	public String toString() {
		return "BonReduction {\nId bon : " + this.idBon + "\nValeur : " + this.valeur + "\nBon utilisé : "
			+ this.bonUtilise + "\nCommerce bon : " + this.commerceBon + "\nMénage bon : " + this.menageBon
			+ "\nDate expiration : " + this.dateExpiration + "\n}"
		;
	}
	
	public BonReduction(int nId, double nValeur, Commerce nCommerce, Menage nMenage, LocalDate nDateExp) {
		if (nId > 0 && nValeur > 0 && !LocalDate.now().isAfter(nDateExp)) {
			this.idBon = nId;
			this.valeur = nValeur;
			this.bonUtilise = false;
			this.commerceBon = nCommerce;
			this.menageBon = nMenage;
			this.dateExpiration = nDateExp;
		}
	}
}
