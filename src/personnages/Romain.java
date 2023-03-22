package personnages;

public class Romain {
	

	private String nom;
	private int force;
	private Equipement equipement1;
	private Equipement equipement2;

	public Romain(String nom, int force, Equipement equipement1,Equipement equipement2) {
		this.nom = nom;
		assert force > 0 : "Force must be positive in constructor";
		this.force = force;
		this.equipement1 = equipement1;
		this.equipement2 = equipement2;


		
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
	
	public static void main(String[] args) {
		
		Romain Minus = new Romain ("Minus",6,Equipement.CASQUE,Equipement.BOUCLIER);
		assert(Minus.force>0);

		System.out.println("Romain: " + Minus.getNom() + ", Force: " + Minus.force + ", Equipement: " + Minus.equipement1 + " + " +Minus.equipement2);

		
	}
}

