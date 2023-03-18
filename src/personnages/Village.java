package personnages;

public class Village {

	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	private	Gaulois villageois[]= new Gaulois [nbVillageoisMaximum];
	
	
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
	
	public Gaulois[] ajouterHabitant(Gaulois gaulois) {
		
		for(int i=0;i<nbVillageois;i++) {
			if(villageois[i] == null) {
				villageois[i] = new Gaulois(gaulois.getNom(),gaulois.getForce(),gaulois.getEffetPotion());
			}
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
	
	public static void main(String[] args) {
		
		int nbVillageoisMaximum=10;
		Gaulois villageois[]=new Gaulois [nbVillageoisMaximum];
	
	    Village village = new Village();
	    Gaulois habitant = village.trouverHabitant(0);
	    System.out.println(habitant);
		
	}
	
}