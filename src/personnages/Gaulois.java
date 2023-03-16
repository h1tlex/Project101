package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion=1;
	
	
	public Gaulois(String nom, int force, int effetPotion) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
	}

	public String getNom() {
		return nom;
	}
	
	public int getEffetPotion() {
		return effetPotion;
	}
	
	public void setEffetPotion(int effetPotion) {
		this.effetPotion=effetPotion;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + ">");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup((force / 3)*effetPotion);
	}

	public int boirePotion(Druide forcePotion) {
		effetPotion=forcePotion.getforcePotion();
		if(effetPotion>=3)
			parler("Merci Druide, je sens que ma force est "+ effetPotion +" fois décuplée");
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
		asterix= new Gaulois ("Asterix",8,1);
		Druide Panoramix= new Druide ("Panoramix",5,10,3);

		asterix.effetPotion=asterix.boirePotion(Panoramix);

		System.out.println(asterix);
		
	}
}




