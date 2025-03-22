import java.time.LocalDate;
import java.time.LocalTime;

public class Depot {
	private int idDepot;
	private int poidsDepot;
	private String typeDepot;
	private boolean correct;
	private int pointsGagnes;
	private Menage utilDepot;
	private LocalDate dateDepot;
	private LocalTime horaireDepot;
	
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
	
	public LocalDate getDate() {
		return this.dateDepot;
	}
	
	public LocalTime getHoraire() {
		return this.horaireDepot;
	}
	
	public void modifPoints() {
		this.utilDepot.ajouterDepot(this);
	}
	
	public String toString() {
		return "Dépôt{\nId dépôt : " + this.idDepot + "\nPoids dépôt : " + this.poidsDepot + "\nType dépôt : "
			+ this.typeDepot + "\nCorrect : " + this.correct + "\nPoints gagnés : " + this.pointsGagnes
			+ "\nUtilisateur dépôt: " + this.utilDepot + "\nDate dépôt : " + this.dateDepot + "\nHoraire dépôt : "
			+ this.horaireDepot + "\n}"
		;
	}
	
	public Depot(int nId, int nPoids, String nType, boolean nCorrect, int nPts, Menage nUtil, LocalDate nDate, LocalTime nHoraire) {
		if (nId > 0 && nPoids > 0 && nType != "toutType") {
			this.idDepot = nId;
			this.poidsDepot = nPoids;
			this.typeDepot = nType;
			this.correct = nCorrect;
			this.pointsGagnes = nPts;
			this.utilDepot = nUtil;
			this.dateDepot = nDate;
			this.horaireDepot = nHoraire;
		}
	}
}









