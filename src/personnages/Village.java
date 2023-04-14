package personnages;

import java.util.Iterator;

public class Village {

	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	private Gaulois villageois[];

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		villageois = new Gaulois[nbVillageoisMaximum];
	}



	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getVillageois(int i) {
		return villageois[i];
	}

	public void ajouterHabitant(Gaulois gaulois) {

		if (nbVillageois < nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
		else {
			System.out.println("Pas assez de place dans le village");
		}

	}

	public Gaulois trouverHabitant(int indexHabitant) {
		for (int i = 0; i < nbVillageois; i++) {
			if (i == indexHabitant) {
				Gaulois gaulois = villageois[i];
				return gaulois;
			}
		}
		System.out.println("Cet habitant n'existe pas.");
		return null;
	}

	public void afficherVillageois() {

		System.out.println("Les membres du village:");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("-" + villageois[i].getNom());
		}
	}

	@Override
	public String toString() {

		return "Villageois [nom=" + nom + ", nbVillageois=" + nbVillageois + ", nbVillageoisMaximum="
				+ nbVillageoisMaximum + "]";
	}

	public static void main(String[] args) {

		Village village = new Village("village", 30);


		Chef Abraracourcix = new Chef("Abraracourcix", 6, village);

		Gaulois habitant1 = new Gaulois("Asterix", 10);
		village.ajouterHabitant(habitant1);
		Gaulois habitant2 = new Gaulois("Obelix", 25);
		village.ajouterHabitant(habitant2);

		village.afficherVillageois();

		Gaulois gaulois = village.trouverHabitant(30);
		System.out.println(gaulois);

//	    System.out.println("\n test trouver habitant :");
//	    for(int i=0; i<village.nbVillageoisMaximum;i++) {
//	    	System.out.println(village.trouverHabitant(i));
//		}

	}

}