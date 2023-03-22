package personnages;

public class Romain {
	

	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		assert force > 0 : "Force must be positive";
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
		Romain Minus;
		
		Minus= new Romain ("Brudah",6);
		assert(Minus.force>0);

		System.out.println(Minus.nom);
		
	}
}

