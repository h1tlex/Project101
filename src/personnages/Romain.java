package personnages;

public class Romain {
	

	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;
	private Equipement equipement1;
	private Equipement equipement2;


	
	
	public Romain(String nom, int force, Equipement[] equipement, Equipement equipement1, Equipement equipement2) {
		
		this.nom = nom;
		assert force > 0 : "Force must be positive in constructor";
		this.force = force;
		this.equipement=equipement;
		this.equipement1=equipement1;
		this.equipement2=equipement2;
	}

	
	public String getNom() {
		return nom;
	}

	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}

	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	
	public void recevoirCoup(int forceCoup) {
		
		assert force > 0 : "Pre-condition force must be positive";
		int currentForce= force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aîe");
		} else {
			parler("J'abandonne...");
		}
		assert currentForce > force : "Post-condition, force value";
	}
	
	
	public int itemType(Equipement item) {
		//check what is item
		switch (item) {
			case CASQUE:
				return 0; // if method return 0 -- item is casque
			default:
				return 1; // if method return 1 -- item is bouclier

			
		}

	}
	
	public int inventoryScan(Equipement[] inventory) {
		switch (inventory[0]) {
		
			case CASQUE:
				switch (inventory[1]) {
					case BOUCLIER:
						System.out.println("inventory full");
						return 0;
					default:
						System.out.println("Casque / None");
						return 1;
				}

			case BOUCLIER:
				switch (inventory[1]) {
					case CASQUE:
						System.out.println("inventory full");
						return 1;
					default:
						System.out.println("Bouclier / None");
						return 2;
				}
			
			default:
				switch (inventory[1]) {
					case CASQUE:
						System.out.println("None / Casque");
						return 3;
					case BOUCLIER:
						System.out.println("None / Bouclier");
						return 4;
					default:
						System.out.println("inventory empty");
						return 5;
				}
			
			}
	}
	
	public void sEquiper(Equipement[] inventory, Equipement item) {
		switch (inventoryScan(inventory)) {
			case 0: //full inventory
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1: // casque/none
				switch (itemType(item)) {
					case 0: // item is casque
						System.out.println("Le soldat " + nom + " possède déjà un casque !");
						break;
					default: // item is bouclier
						inventory[1]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un bouclier !");		
						break;
				}
			case 2: // bouclier/none
				switch (itemType(item)) {
					case 0: // item is casque
						inventory[1]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un casque !");	
						break;
					default: // item is bouclier
						System.out.println("Le soldat " + nom + " possède déjà un bouclier !");
						break;	
				}
			case 3: // none/casque
				switch (itemType(item)) {
					case 0: // item is casque
						System.out.println("Le soldat " + nom + " possède déjà un casque !");
						break;
					default: // item is bouclier
						inventory[0]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un bouclier !");		
						break;
				}
			case 4: // none/bouclier
				switch (itemType(item)) {
					case 0: // item is casque
						inventory[0]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un casque !");	
						break;
					default: // item is bouclier
						System.out.println("Le soldat " + nom + " possède déjà un bouclier !");
						break;	
				}
			default: //empty inventory
				switch (itemType(item)) {
					case 0: // item is casque
						inventory[0]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un casque !");	
						break;
					default: // item is bouclier
						inventory[0]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un bouclier !");		
						break;
			}
				
		}
	}
	
	public static void main(String[] args) {
		
		Romain Minus = new Romain ("Minus",6,equipement,Equipement.CASQUE,Equipement.BOUCLIER);
		assert(Minus.force>0);

		System.out.println("Romain: " + Minus.getNom() + ", Force: " + Minus.force + ", Equipement: " + Minus.equipement1 + " + " +Minus.equipement2);

		
	}
}

