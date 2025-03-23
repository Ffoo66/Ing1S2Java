import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Depot {
	private UUID idDepot;
	private int poidsDepot;
	private Couleur colDepot;
	private Type typeDepot;
	private ResCat correct;
	private Adresse adresseDepot;
	private int pointsGagnes;
	private Menage utilDepot;
	private LocalDate dateDepot;
	private LocalTime horaireDepot;
	
	public UUID getIdDepot() {
		return this.idDepot;
	}
	
	public int getPoidsDepot() {
		return this.poidsDepot;
	}
	
	public Couleur getCouleurDepot() {
		return this.colDepot;
	}
	
	public Type getTypeDepot() {
		return this.typeDepot;
	}
	
	public ResCat getCorrect() {
		return this.correct;
	}
	
	public Adresse getAdresseDepot() {
		return this.adresseDepot;
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
		return "Dépôt{\nId dépôt : " + this.idDepot + "\nPoids dépôt : " + this.poidsDepot + "\nCouleur dépôt : "
			+ this.colDepot + "\nType dépôt : " + this.typeDepot + "\nCorrect : " + this.correct + "\nAdresse dépôt : "
			+ this.adresseDepot + "\nPoints gagnés : " + this.pointsGagnes + "\nUtilisateur dépôt: "
			+ this.utilDepot + "\nDate dépôt : " + this.dateDepot + "\nHoraire dépôt : " + this.horaireDepot + "\n}"
		;
	}
	
	public Depot(UUID nId, int nPoids, Couleur nCol, Type nType, Adresse nAdresse, ResCat nCorrect, int nPts,
	Menage nUtil, LocalDate nDate, LocalTime nHoraire) {
		if (nPoids > 0 && nCol != Couleur.toutCol && nType != Type.toutType && nCorrect != ResCat.total
		&& nAdresse != null) {
			this.idDepot = nId;
			this.poidsDepot = nPoids;
			this.colDepot = nCol;
			this.typeDepot = nType;
			this.adresseDepot = nAdresse;
			this.correct = nCorrect;
			this.pointsGagnes = nPts;
			this.utilDepot = nUtil;
			this.dateDepot = nDate;
			this.horaireDepot = nHoraire;
		}
	}
}