package personnages;

import java.util.Iterator;

public class Village {

	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum=30;
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
		
		Chef ajouterChef=new Chef(gaulois.getNom(), gaulois.getForce(),gaulois.getEffetPotion(),this);
		Gaulois ajouterGaulois= new Gaulois(gaulois.getNom(), gaulois.getForce(), gaulois.getEffetPotion());
		
		if (nbVillageois<nbVillageoisMaximum) {
	 
			if (gaulois instanceof Chef) {
				for(int i=0;i<nbVillageoisMaximum;i++) {
					if(villageois[i] == null) {
	                villageois[i] = ajouterChef;
					nbVillageois++;
					System.out.println("Le Chef " + gaulois.getNom() + " à était ajouté à la liste du village!");
	                break; // exit the loop once the new chef has been added
					}
				}
			}
            else { //Gaulois
            	
            	
				for(int i=0;i<nbVillageoisMaximum;i++) {
					if(villageois[i] == null) {
	                villageois[i] = ajouterGaulois;
					nbVillageois++;
					System.out.println("Le Gaulois " + gaulois.getNom() + " à était ajouté à la liste du village!");
	                break; // exit the loop once the new gaulois has been added
					}
				}
            }
		}
			
		 else {
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
	
	public void afficherVillageois() {
		
		System.out.println("Les Chefs du village:");
	    for (int i = 0; i < nbVillageois; i++) {
	    	if (villageois[i] instanceof Chef) {
		        System.out.println("-" + villageois[i].getNom());
			}
	    }
	    
		System.out.println("Les membres du village:");
	    for(int i = 0; i < nbVillageois; i++) {
	    	if (!(villageois[i] instanceof Chef)) {
		        System.out.println("-" + villageois[i].getNom());
			}
	    	
	    }
	}
	
	@Override
	public String toString() {
		
		return "Villageois [nom=" + nom + ", nbVillageois=" + nbVillageois + ", nbVillageoisMaximum=" + nbVillageoisMaximum + "]";
	}
	
	
	public static void main(String[] args) {
		
		Gaulois villageDesIrreductibles[] = new Gaulois[30];
		
	    Village village = new Village();
	    

		Chef Abraracourcix = new Chef("Abraracourcix",6,1,village);
	    village.ajouterHabitant(Abraracourcix);
		
	    Gaulois habitant1 = new Gaulois("Asterix",10,2);
	    village.ajouterHabitant(habitant1);
	    Gaulois habitant2 = new Gaulois("Obelix",25,3);
	    village.ajouterHabitant(habitant2);
	    
	    village.afficherVillageois();
	    
	    Gaulois gaulois = village.trouverHabitant(30);

	    
//	    System.out.println("\n test trouver habitant :");
//	    for(int i=0; i<village.nbVillageoisMaximum;i++) {
//	    	System.out.println(village.trouverHabitant(i));
//		}
		
	}
	
}