import java.util.Date;

public class Depot {
	private int idDepot;
	private int poidsDepot;
	private String typeDepot;
	private boolean correct;
	private int pointsGagnes;
	private Menage utilDepot;
	private Date dateDepot;
	
	public int getIdDepot() {
		return this.idDepot;
	}
	
	public int getPoidsDepot() {
		return this.poidsDepot;
	}
	
	public String getTypeDepot() {
		return this.typeDepot;
	}
	
	public boolean getCorrect() {
		return this.correct;
	}
	
	public int getPtsGagnes() {
		return this.pointsGagnes;
	}
	
	public Menage getUtilDepot() {
		return this.utilDepot;
	}
	
	public Date getDate() {
		return this.dateDepot;
	}
	
	public void modifPoints() {
		this.utilDepot.ajouterDepot(this);
	}
	
	public String toString() {
		return "Dépôt{\nId dépôt : " + this.idDepot + "\nPoids dépôt : " + this.poidsDepot + "\nType dépôt : "
			+ this.typeDepot + "\nCorrect : " + this.correct + "\nPoints gagnés : " + this.pointsGagnes
			+ "\nUtilisateur dépôt: " + this.utilDepot + "\nDate dépôt : " + this.dateDepot + "\n}"
		;
	}
	
	public Depot(int nId, int nPoids, String nType, boolean nCorrect, int nPts, Menage nUtil, Date nDate) {
		if (nId > 0 && nPoids > 0 && nType != "toutType") {
			this.idDepot = nId;
			this.poidsDepot = nPoids;
			this.typeDepot = nType;
			this.correct = nCorrect;
			this.pointsGagnes = nPts;
			this.utilDepot = nUtil;
			this.dateDepot = nDate;
		}
	}
}









