import java.util.ArrayList;
import java.time.LocalDate;

public class Menage {
	private int idMenage;
	private String nomCompte;
	private String motDePasse;
	private int pointsFidelite;
	private ArrayList<Depot> historiqueDepotsM;
	private Adresse adresseMenage;
	private ArrayList<BonReduction> listeBonsM;
	
	public int getIdMenage() {
		return this.idMenage;
	}
	
	public String getNom() {
		return this.nomCompte;
	}
	
	public String getMDP() {
		return this.motDePasse;
	}
	
	public int getPoints() {
		return this.pointsFidelite;
	}
	
	public ArrayList<Depot> getHistorique(){
		return this.historiqueDepotsM;
	}
	
	public Adresse getAdresse() {
		return this.adresseMenage;
	}
	
	public ArrayList<BonReduction> getListeBons(){
		return this.listeBonsM;
	}
	
	public void setNomCompte(String nNom) {
		if (nNom != "") {
			this.nomCompte = nNom;
		}
	}
	
	public void setMDP(String nMDP) {
		if (nMDP != "") {
			this.motDePasse = nMDP;
		}
	}
	
	public void addPoints(int points) {
		this.pointsFidelite += points;
	}
	
	public void ajouterDepot(Depot nDepot) {
		this.historiqueDepotsM.add(nDepot);
		this.addPoints(nDepot.getPtsGagnes());
	}
	
	public void setAdresse(Adresse nAdresse) {
		this.adresseMenage = nAdresse;
	}
	
	public void consulterHistorique() {
		System.out.println("Historique des dépôts de " + nomCompte + " :\n");
		for (Depot depot : this.historiqueDepotsM) {
			System.out.println("\n" + depot);
		}
	}
	
	public void echangerPts(int points, Commerce commerce) {
		if (points <= this.pointsFidelite) {
			double val = commerce.getReduction(points);
			BonReduction nBon = new BonReduction(commerce.getListeBons().size(), val, commerce, this, LocalDate.now().plusMonths(1));
			this.pointsFidelite -= points;
			this.listeBonsM.add(nBon);
			commerce.getListeBons().add(nBon);
		}
	}
	
	public boolean utiliserBon(BonReduction bon) {
		if(bon.getBonUtilise()) {
			return false;
		}
		else {
			bon.utiliser();
			return true;
		}
	}

	public String toString() {
		return "Menage {\nId ménage : " + this.idMenage + "\nNom compte : " + this.nomCompte + "\nMot de passe : "
			+ this.motDePasse + "\nPoints fidélité : " + this.pointsFidelite + "\nHistorique dépôts : "
			+ this.historiqueDepotsM + "\nAdresse ménage : " + this.adresseMenage + "\n}"
		;
	}
	
	public Menage(int nId, String nCompte, String nMDP, Adresse nAdresse) {
		if (nId > 0) {
			this.idMenage = nId;
			this.nomCompte = nCompte;
			this.motDePasse = nMDP;
			this.pointsFidelite = 0;
			this.historiqueDepotsM = new ArrayList<Depot>();
			this.adresseMenage = nAdresse;
		}
	}
}