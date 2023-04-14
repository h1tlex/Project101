package personnages;

public class Chef {

	private int effetPotion = 1;
	private Village village;
	private int force;
	private String nom;

	public Chef(String nom, int force, Village village) {
		this.nom = nom;
		this.force = force;
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}

	private String prendreParole() {
		return "Le chef " + getNom() + " du village " + village.getNom() + " : ";
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void frapper(Romain romain) {
		System.out.println(getNom() + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup(getForce() / 3);
	}

}
