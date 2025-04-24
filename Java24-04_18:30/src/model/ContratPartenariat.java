package model;
import java.time.*;
import java.util.*;

public class ContratPartenariat {
	private int idCentreP;
	private UUID idCommerceP;
	private CentreTri centrePartner;
	private Commerce commercePartner;
	private boolean estPartenaire;
	private LocalDate dateDebutPartner;
	private LocalDate dateFinPartner;
	private HashMap<String, Double> produitsAff;
	
	public int getIdCentreP() {
		return this.idCentreP;
	}
	
	public UUID getIdCommerceP() {
		return this.idCommerceP;
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
	
	public HashMap<String, Double> getProduitsAff(){
		return this.produitsAff;
	}
	
	public double getReducProduit(String produit) {
		return this.produitsAff.get(produit);
	}
	
	public void ajoutProduitAff(String nProduit, double coeff) {
		this.produitsAff.put(nProduit.toLowerCase(), coeff);
	}
	
	public void supProduitAff(String nProduit) {
		this.produitsAff.remove(nProduit);
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
		return "ContratPartenariat {\n\tCentre partenaire : " + this.centrePartner.getIdCentre()
			+ "\n\tCommerce partenaire : " + this.commercePartner.getIdCommerce() + "\n\tEst partenaire : "
			+ this.estPartenaire + "\n\tDate début partenariat : " + this.dateDebutPartner
			+ "\n\tDate fin partenariat : " + this.dateFinPartner + "\n\tProduits affectés : "
			+ this.produitsAff + "\n}\n"
		;
	}

	public ContratPartenariat(CentreTri nCentre, Commerce nCommerce, LocalDate nDateDP, LocalDate nDateFP) {
		this.idCentreP = nCentre.getIdCentre();
		this.idCommerceP = nCommerce.getIdCommerce();
		this.centrePartner = nCentre;
		this.commercePartner = nCommerce;
		this.dateDebutPartner = nDateDP;
		this.dateFinPartner = nDateFP;
		this.produitsAff = new HashMap<String, Double>();
		if (LocalDate.now().isAfter(this.dateDebutPartner) && LocalDate.now().isBefore(this.dateFinPartner)) {
			this.estPartenaire = true;
		}
		else {
			this.estPartenaire = false;
		}
	}
}
