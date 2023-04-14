package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {

		this.nom = nom;
		assert force > 0 : "Force must be positive in constructor";
		this.force = force;

	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
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
		if (force > 0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculerResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) == true) {
					System.out.println("Equipement bouclier");
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
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement item) {
		switch (nbEquipement) {
		case 0: {
			equipement[0] = item;
			nbEquipement++;
			break;
		}
		case 1: {
			if (equipement[0] == item) {
				System.out.println("I already have this item");
			} else {
				equipement[1] = item;
				nbEquipement++;
			}
			break;
		}
		case 2: {
			System.out.println("I already have this item");
		}
		}

	}

	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		assert (minus.force > 0);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);

		System.out.println("Romain: " + minus.getNom() + ", Force: " + minus.force + ", INVENTORY: "
				+ minus.equipement[0] + " + " + minus.equipement[1]);

	}

}
