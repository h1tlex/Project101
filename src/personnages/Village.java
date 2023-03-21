package personnages;

import java.util.Iterator;

public class Village {

	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum=10;
	private	Gaulois villageois[] = new Gaulois[nbVillageoisMaximum];
	
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum= nbVillageoisMaximum;
		}
	
	public Village(){}

	
	public void setChef(Chef chef) {
		this.chef=chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getVillageois(int i) {
		return villageois[i];
	}
	
	public Gaulois[] ajouterHabitant(Gaulois gaulois) {
		
		
		if (nbVillageois<nbVillageoisMaximum) {
	
			for(int i=0;i<nbVillageoisMaximum;i++) {
				if(villageois[i] == null) {
					villageois[i] = new Gaulois(gaulois.getNom(),gaulois.getForce(),gaulois.getEffetPotion());
					nbVillageois++;
					System.out.println("Le villageois " + gaulois.getNom() + " à était ajouté à la liste du village!");
	                break; // exit the loop once the new villager has been added

				}
			}
		} else {
			System.out.println("Le villageois " + gaulois.getNom() + " n'a pas était ajouté à la liste du village!");
		}
	
		return villageois;
	}
	
	public Gaulois trouverHabitant(int indexHabitant) { 
		for(int i=0; i<nbVillageois;i++) {
			if (i==indexHabitant) {
	            Gaulois gaulois = villageois[i];
	            return gaulois;
			}
		}
		System.out.println("Cet habitant n'existe pas.");
		return null;
	}
	
	public void printVillageois() {
	    for (int i = 0; i < nbVillageois; i++) {
	        System.out.println(villageois[i]);
	    }
	}
	
	@Override
	public String toString() {
		
		return "Villageois [nom=" + nom + ", nbVillageois=" + nbVillageois + ", nbVillageoisMaximum=" + nbVillageoisMaximum + "]";
	}
	
	
	public static void main(String[] args) {
		
		int nbVillageoisMaximum=10;
		Gaulois villageois[]=new Gaulois [nbVillageoisMaximum];
		int nbVillageois=0;
	    Village village = new Village();
	    
	    Gaulois habitant1 = new Gaulois("Asterix",10,2);
	    village.ajouterHabitant(habitant1);
	    
	    Gaulois habitant2 = new Gaulois("Obelix",12,3);
	    village.ajouterHabitant(habitant2);
	    
	    village.printVillageois();
	    
	    System.out.println("\n test trouver habitant :");
	    for(int i=0; i<nbVillageoisMaximum;i++) {
	    	System.out.println(village.trouverHabitant(i));
		}
		
	}
	
}