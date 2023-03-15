package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion;
	
	
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
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
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
		asterix= new Gaulois ("Asterix",8,2);
		System.out.println(asterix);
		
	}
}




