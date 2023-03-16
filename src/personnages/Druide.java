package personnages;
import java.util.Random;

public class Druide {
	
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax, int forcePotion) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.forcePotion = forcePotion;

		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}
	
	public int getforcePotion() {
		return forcePotion;
	}

	public void setforcePotion() {
		this.forcePotion=forcePotion;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public int preparerPotion(int effectPotionMin,int effectPotionMax) {
		
	    Random random = new Random();
	    int val = random.nextInt(effectPotionMax);
	    
	    while(val<effectPotionMin) {
	    	val=random.nextInt(effectPotionMax);
	    }
	    
	    if (val>=7) {
	    	parler("J'ai préparé une super potion de force " + val);
	    }
	    else {
	    	parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + val);
	    }
	    return val;
	}


	
	@Override
	public String toString() {
		
		return "Gaulois [nom=" + nom + ", force=" + effetPotionMin + ", effetPotion=" + effetPotionMax + "]";
	}
	
	public static void main(String[] args) {
		Druide Panoramix;
		Panoramix= new Druide ("Panoramix",5,10,3);
		Panoramix.preparerPotion(Panoramix.effetPotionMin,Panoramix.effetPotionMax);
		System.out.println(Panoramix);
		
	}
}
