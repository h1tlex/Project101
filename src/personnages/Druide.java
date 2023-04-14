package personnages;

import java.util.Random;

public class Druide {

	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;

		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}

	public int getEffetPotionMin() {
		return effetPotionMin;
	}

	public int getEffetPotionMax() {
		return effetPotionMax;
	}

	public int getforcePotion() {
		return forcePotion;
	}

	public void setForcePotion(int forcePotion) {
		this.forcePotion = forcePotion;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + ">");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {

		parler("Je vais aller préparer une petite potion...");

		Random random = new Random();
		int val = effetPotionMin + random.nextInt(effetPotionMax - effetPotionMin + 1);

		if (val >= 7) {
			parler("J'ai préparé une super potion de force " + val);
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + val);
		}
		// Creates forcePotion
		setForcePotion(val);
	
	}

	public void booster(Gaulois gaulois, Druide forcePotion) {

		if (gaulois.getNom() != "Obelix") {
			int effetPotion = gaulois.boirePotion(forcePotion);
			gaulois.setEffetPotion(effetPotion);
		} else {
			parler("Non, Obélix ! ... Tu n’auras pas de potion magique ! ");
		}
	}

	@Override
	public String toString() {

		return "Gaulois [nom=" + nom + ", force=" + getEffetPotionMin() + ", effetPotion=" + effetPotionMax + "]";
	}

	public static void main(String[] args) {
		Druide panoramix;
		Gaulois obelix;
		obelix = new Gaulois("Obelix", 8);
		panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
		panoramix.booster(obelix, panoramix);
		System.out.println(panoramix);

	}

}
