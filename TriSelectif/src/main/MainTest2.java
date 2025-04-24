package main;
import model.*;
import java.time.*;
import java.util.*;

public class MainTest2 {
	public static void main (String args[]) {
		
		CentreTri ct = new CentreTri("Centre 1", new Adresse(30, "Rue Lemauvais", 95000, "Cergy"));
		ct.creerBac(Couleur.gris, 5000);
		ct.creerBac(Couleur.gris, 5000);
		ct.creerBac(Couleur.gris, 5000);
		ct.creerBac(Couleur.gris, 5000);
		ct.creerBac(Couleur.gris, 5000);
		ct.creerBac(Couleur.gris, 5000);
		ct.creerBac(Couleur.gris, 5000);
		ct.creerBac(Couleur.gris, 5000);
		
		ArrayList<Bac> bacArray = new ArrayList<Bac>(ct.getMapBac().values());
		
		ct.placerBac(bacArray.get(0).getIdBac(), new Adresse(10, "Rue Daim", 10000, "Troyes"));
		ct.placerBac(bacArray.get(1).getIdBac(), new Adresse(1, "Rue Daim", 10000, "Troyes"));
		ct.placerBac(bacArray.get(2).getIdBac(), new Adresse(2, "Avenue D'Oeufs", 10000, "Troyes"));
		ct.placerBac(bacArray.get(3).getIdBac(), new Adresse(3, "Place de Troyes", 95000, "Cergy"));
		ct.placerBac(bacArray.get(4).getIdBac(), new Adresse(4, "Rue Cathrine", 10000, "Troyes"));
		ct.placerBac(bacArray.get(5).getIdBac(), new Adresse(5, "Avenue Saint Quentin", 10000, "Troyes"));
		ct.placerBac(bacArray.get(6).getIdBac(), new Adresse(6, "Place de Médicis", 10000, "Troyes"));
		ct.placerBac(bacArray.get(7).getIdBac(), new Adresse(7, "Rue Cassette", 10000, "Troyes"));
		
		
		Commerce cm1 = new Commerce("CY TECH", new Adresse(3, "Rue Lebon", 95000, "Cergy"));
		
		cm1.ajoutContrat(ct, LocalDate.now(), LocalDate.now().plusMonths(2));
		cm1.getMapPartenariats().get(ct.getIdCentre()).ajoutProduitAff("Viande", 2);
		cm1.getMapPartenariats().get(ct.getIdCentre()).ajoutProduitAff("Intelligence", 5);
		cm1.getMapPartenariats().get(ct.getIdCentre()).ajoutProduitAff("Intelligence", 10);
		cm1.getMapPartenariats().get(ct.getIdCentre()).ajoutProduitAff("Ordinateur", 50);
		
		
		
		Commerce cm2 = new Commerce("ESSEC", new Adresse(9, "Avenue Lemoyen", 95000, "Cergy"));
		
		cm2.ajoutContrat(ct, LocalDate.now(), LocalDate.now().plusMonths(1));
		cm2.getMapPartenariats().get(ct.getIdCentre()).ajoutProduitAff("Viande", 2);
		cm2.getMapPartenariats().get(ct.getIdCentre()).ajoutProduitAff("Viande", 3);
		cm2.getMapPartenariats().get(ct.getIdCentre()).ajoutProduitAff("Argent", 5);
		cm2.getMapPartenariats().get(ct.getIdCentre()).ajoutProduitAff("Projet", 50);

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(cm1.getMapPartenariats().get(ct.getIdCentre()).getProduitsAff());
		System.out.println(cm2.getMapPartenariats().get(ct.getIdCentre()).getProduitsAff());
		
		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		
		
		/*		
		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.supprimerBac(bacArray.get(7).getIdBac());

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.retirerBac(bacArray.get(7).getIdBac());

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.retirerRue(new Adresse(12, "Rue Daim", 10000, "Troyes"));

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.placerBac(bacArray.get(3).getIdBac(), new Adresse(12, "Avenue D'Oeufs", 10000, "Troyes"));
		ct.placerBac(bacArray.get(4).getIdBac(), new Adresse(12, "Avenue D'Oeufs", 10000, "Troyes"));
		ct.retirerTout();

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		*/
		
		ct.inscrire("VO", "VOFlorian2005", new Adresse(11, "Avenue du Général Saussier", 10000, "Troyes"));
		ct.inscrire("VO", "voflorian", new Adresse(9, "Rue Jean Moulin", 10000, "Troyes"));
		ct.inscrire("GOURNAY", "LucasG", new Adresse(4, "Rue Lebon", 95000, "Cergy"));
		
		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(Menage.getMapMenage());
		
		Menage m1 = bacArray.get(0).identifierMenage("VO", "voflorian2005");
		
		Menage m2 = bacArray.get(0).identifierMenage("GOURNAY", "LucasG");

		Menage m3 = bacArray.get(0).identifierMenage("VO", "VOFlorian2005");
		
		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		
		bacArray.get(0).ajouterDechet(500, Type.autre, m2);
		bacArray.get(0).ajouterDechet(3500, Type.autre, m3);
		

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(bacArray.get(0));
		System.out.println(ct.getMapDepot());
		System.out.println(Menage.getMapMenage());
		
		
		bacArray.get(1).ajouterDechet(100, Type.autre, m2);
		bacArray.get(2).ajouterDechet(200, Type.autre, m3);
		bacArray.get(3).ajouterDechet(300, Type.autre, m2);
		bacArray.get(4).ajouterDechet(400, Type.autre, m3);
		bacArray.get(5).ajouterDechet(500, Type.autre, m2);
		bacArray.get(6).ajouterDechet(600, Type.carton, m3);
		bacArray.get(1).ajouterDechet(100, Type.verre, m2);
		bacArray.get(2).ajouterDechet(200, Type.verre, m3);
		bacArray.get(3).ajouterDechet(300, Type.plastique, m2);
		bacArray.get(4).ajouterDechet(400, Type.papier, m3);
		bacArray.get(5).ajouterDechet(500, Type.metal, m2);
		bacArray.get(6).ajouterDechet(600, Type.metal, m3);
		

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getRes(Couleur.toutCol, Type.metal, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 59),
		LocalDate.now().minusDays(1), LocalDate.now().plusDays(2), null, ResCat.total));

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getRes(Couleur.toutCol, Type.toutType, LocalTime.of(0, 0, 0), LocalTime.of(23, 59, 59),
		LocalDate.now(), LocalDate.now().plusDays(2), null, ResCat.incorrect));
		

		ct.retirerRue(new Adresse(12, "Rue Daim", 10000, "Troyes"));

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.collecter();

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		bacArray.get(1).ajouterDechet(100, Type.autre, m2);
		bacArray.get(2).ajouterDechet(200, Type.autre, m3);
		bacArray.get(3).ajouterDechet(300, Type.autre, m2);
		bacArray.get(4).ajouterDechet(400, Type.autre, m3);
		bacArray.get(5).ajouterDechet(500, Type.autre, m2);
		bacArray.get(1).ajouterDechet(100, Type.autre, m2);
		bacArray.get(2).ajouterDechet(200, Type.autre, m3);
		bacArray.get(3).ajouterDechet(300, Type.autre, m2);
		bacArray.get(4).ajouterDechet(400, Type.autre, m3);
		bacArray.get(5).ajouterDechet(500, Type.autre, m2);
		
		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(Menage.getMapMenage());
		
		m2.echangerPts(m2.getPoints(), cm2, "Viande");
		m3.echangerPts(m3.getPoints(), cm1, "Ordinateur");
		
		ArrayList<BonReduction> bonArray = new ArrayList<BonReduction>(m2.getMapBons().values());
		
		m2.utiliserBon(bonArray.get(0));
		
		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(m2.getMapBons());
		System.out.println(m3.getMapBons());
		
		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(Menage.getMapMenage());
	}
}
