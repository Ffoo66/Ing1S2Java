import java.time.LocalDate;

public class ContratPartenariat {
	private int idPartenariat;
	private CentreTri centrePartner;
	private Commerce commercePartner;
	private boolean estPartenaire;
	private LocalDate dateDebutPartner;
	private LocalDate dateFinPartner;
	
	public int getIdPartenariat() {
		return this.idPartenariat;
	}
	
	public CentreTri getCentrePartner() {
		return this.centrePartner;
	}
	
	public Commerce getCommercePartner() {
		return this.commercePartner;
	}
	
	public boolean getEstPartner() {
		return this.estPartenaire;
	}
	
	public LocalDate getDateDP() {
		return this.dateDebutPartner;
	}
	
	public LocalDate getDateFP() {
		return this.dateFinPartner;
	}
	
	public void prolongPartner(LocalDate dateDP, LocalDate dateFP) {
		if (this.dateFinPartner.isBefore(dateFP) && LocalDate.now().isBefore(dateFP) && dateDP.isBefore(dateFP)) {
			if (this.dateFinPartner.isBefore(LocalDate.now()) || this.dateFinPartner.isEqual(LocalDate.now())) {
				this.dateDebutPartner = dateDP;
				this.dateFinPartner = dateFP;
				if (LocalDate.now().isAfter(this.dateDebutPartner)) {
					this.estPartenaire = true;
				}
			}
			else if (this.dateFinPartner.isAfter(dateDP) || this.dateFinPartner.isEqual(dateDP)) {
				this.dateFinPartner = dateFP;
				this.estPartenaire = true;
			}
			else {
				System.out.println("Contrat actuel non terminé");
			}
		}
		else {
			System.out.println("Dates invalides");
		}
	}

	public String toString() {
		return "ContratPartenariat {\nId partenariat : " + this.idPartenariat + "\nCentre partenaire : " + this.centrePartner
			+ "\nCommerce partenaire : " + this.commercePartner + "\nEst partenaire : " + this.estPartenaire
			+ "\nDate début partenariat : " + this.dateDebutPartner + "\nDate fin partenariat : " + this.dateFinPartner
			+ "\n}"
		;
	}

	public ContratPartenariat(CentreTri nCentre, Commerce nCommerce, LocalDate nDateDP, LocalDate nDateFP) {
		this.idPartenariat = Integer.valueOf(String.valueOf(nCentre.getIdCentre()) + String.valueOf(nCommerce.getIdCommerce()));
		this.centrePartner = nCentre;
		this.commercePartner = nCommerce;
		this.dateDebutPartner = nDateDP;
		this.dateFinPartner = nDateFP;
		if (LocalDate.now().isAfter(this.dateDebutPartner) && LocalDate.now().isBefore(this.dateFinPartner)) {
			this.estPartenaire = true;
		}
		else {
			this.estPartenaire = false;
		}
	}
}
