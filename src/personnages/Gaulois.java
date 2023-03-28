package personnages;

public class Gaulois {

	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public int getEffetPotion() {
		return effetPotion;
	}

	public void setEffetPotion(int effetPotion) {
		this.effetPotion = effetPotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + ">");
	}

	private String prendreParole() {

		return "Le gaulois " + nom + " : ";
	}



	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] tropheesGagnes = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesGagnes != null && i < tropheesGagnes.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesGagnes[i];
		}
	}

	public int boirePotion(Druide forcePotion) {
		effetPotion = forcePotion.getforcePotion();
		if (effetPotion >= 3)
			parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée");
		else
			parler("L'effet de cette potion est seulement " + effetPotion);
		return effetPotion;
	}

//	La méthode toString permet de transformer l’achage de l’objet sous
//	sa forme nomDuPaquage.nomDeLaCLasse@adresseMemoire en chaine de
//	caractère correspondant à l’état de l’objet.

	@Override
	public String toString() {

		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Asterix", 8);
		Druide localPanoramix = new Druide("Panoramix", 5, 10);

		asterix.effetPotion = asterix.boirePotion(localPanoramix);

		System.out.println(asterix);

	}
}
