package personnages;

public class Romain {
	

	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[] {Equipement.EMPTY,Equipement.EMPTY};
	private int nbEquipement = 0;


	
	
	public Romain(String nom, int force ) {
		
		this.nom = nom;
		assert force > 0 : "Force must be positive in constructor";
		this.force = force;

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

	

	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// Pre-condition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculerResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		if(force>0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			}
		// post condition la force a diminu�e
		assert force < oldForce;
		return equipementEjecte;
			}

	
	
	private int calculerResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] =equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
				}
			}
			return equipementEjecte;
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
	
	public Equipement[] sEquiper(Equipement[] inventory, Equipement item) {
		switch (inventoryScan(inventory)) {
			case 0: //full inventory
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1: // casque/none
				switch (itemType(item)) {
					case 0: // item is casque
						System.out.println("Le soldat " + nom + " possède déjà un casque !");
						return inventory;
					default: // item is bouclier
						inventory[1]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un bouclier !");		
						return inventory;
				}
			case 2: // bouclier/none
				switch (itemType(item)) {
					case 0: // item is casque
						inventory[1]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un casque !");	
						return inventory;
					default: // item is bouclier
						System.out.println("Le soldat " + nom + " possède déjà un bouclier !");
						return inventory;
				}
			case 3: // none/casque
				switch (itemType(item)) {
					case 0: // item is casque
						System.out.println("Le soldat " + nom + " possède déjà un casque !");
						return inventory;
					default: // item is bouclier
						inventory[0]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un bouclier !");		
						return inventory;
				}
			case 4: // none/bouclier
				switch (itemType(item)) {
					case 0: // item is casque
						inventory[0]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un casque !");	
						return inventory;
					default: // item is bouclier
						System.out.println("Le soldat " + nom + " possède déjà un bouclier !");
						return inventory;
				}
			default: //empty inventory
				switch (itemType(item)) {
					case 0: // item is casque
						inventory[0]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un casque !");	
						return inventory;
					default: // item is bouclier
						inventory[0]=item;
						nbEquipement++;
						System.out.println("Le soldat " + nom + " s’équipe avec un bouclier !");		
						return inventory;
			}
		}
		return inventory;
	}
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain ("Minus",6);
		assert(minus.force>0);
		
		minus.sEquiper(minus.equipement,Equipement.CASQUE);
		minus.sEquiper(minus.equipement,Equipement.CASQUE);
		minus.sEquiper(minus.equipement,Equipement.BOUCLIER);
		minus.sEquiper(minus.equipement,Equipement.BOUCLIER);

		


		System.out.println("Romain: " + minus.getNom() + ", Force: " + minus.force + ", INVENTORY: " + minus.equipement[0] + " + " +minus.equipement[1]);

		
	}
}

