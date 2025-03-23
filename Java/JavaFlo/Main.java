import java.time.*;
import java.util.*;

public class Main {
	public static void main (String args[]) {
		CentreTri ct = new CentreTri("Centre 1", new Adresse(30, "Rue Lemauvais", 95000, "Cergy"));
		ct.creerBac(Couleur.vert, 5000);
		ct.creerBac(Couleur.jaune, 5000);
		ct.creerBac(Couleur.bleu, 5000);
		ct.creerBac(Couleur.gris, 5000);
		ct.creerBac(Couleur.vert, 5000);
		ct.creerBac(Couleur.jaune, 5000);
		ct.creerBac(Couleur.bleu, 5000);
		ct.creerBac(Couleur.gris, 5000);
		
		Set<UUID> keys = ct.getMapBac().keySet();
		UUID keysArray[] = new UUID[keys.size()]; 
		keysArray = keys.toArray(keysArray);
		
		ct.placerBac(keysArray[0], new Adresse(10, "Avenue Dunull", 10000, "Troyes"));
		ct.placerBac(keysArray[1], new Adresse(1, "Rue Daim", 10000, "Troyes"));
		ct.placerBac(keysArray[2], new Adresse(2, "Avenue D'Oeufs", 10000, "Troyes"));
		ct.placerBac(keysArray[3], new Adresse(3, "Place de Troyes", 95000, "Cergy"));
		ct.placerBac(keysArray[4], new Adresse(4, "Rue Cathrine", 10000, "Troyes"));
		ct.placerBac(keysArray[5], new Adresse(5, "Avenue Saint Quentin", 10000, "Troyes"));
		ct.placerBac(keysArray[6], new Adresse(6, "Place de Médicis", 10000, "Troyes"));
		ct.placerBac(keysArray[7], new Adresse(7, "Rue Cassette", 10000, "Troyes"));
		
		Commerce cm1 = new Commerce("CY TECH", new Adresse(3, "Rue Lebon", 95000, "Cergy"), LocalDate.now(), LocalDate.now().plusMonths(2));
		Commerce cm2 = new Commerce("ESSEC", new Adresse(9, "Avenue Lemoyen", 95000, "Cergy"), LocalDate.now(), LocalDate.now().plusMonths(1));
		
		/*		
		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.supprimerBac(keysArray[3]);

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.retirerBac(keysArray[1]);

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.retirerRue(new Adresse(12, "Rue Troisième test", 10000, "Troyes"));

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		
		ct.placerBac(keysArray[4], new Adresse(12, "Rue Troisième test", 10000, "Troyes"));
		ct.placerBac(keysArray[5], new Adresse(12, "Rue Troisième test", 10000, "Troyes"));
		ct.retirerTout();

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(ct.getMapBac());
		*/
		
		ct.inscrire("VO", "VOFlorian2005", new Adresse(11, "Avenue du Général Saussier", 10000, "Troyes"));
		ct.inscrire("GOURNAY", "LucasG", new Adresse(4, "Rue Lebon", 95000, "Cergy"));

		System.out.println("\n\n\n-------------------------------------------------------------------------------\n\n\n");
		System.out.println(Menage.getMapMenage());
		
		
	}
}
