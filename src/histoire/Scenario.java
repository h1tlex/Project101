package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
import personnages.Chef;

public class Scenario {

	public static void main(String[] args) {
		
	Gaulois asterix= new Gaulois("Asterix",8,19);
	Romain minus= new Romain("Minus",6);
	Druide Panoramix= new Druide ("Panoramix",5,10,3);
	Gaulois Obelix= new Gaulois ("Obelix",8,1);
	
	
	Panoramix.preparerPotion(Panoramix.getEffetPotionMin(),Panoramix.getEffetPotionMax());
	Panoramix.booster(Obelix,Panoramix);
	Obelix.parler("Par Bélénos, ce n'est pas juste !");
	Panoramix.booster(asterix,Panoramix);
	
	
	
	
	asterix.parler("Bonjour !");

	minus.parler("UN GAU... UN GAUGAU...");
	asterix.frapper(minus);
	asterix.frapper(minus);
	asterix.frapper(minus);
	
	}

}
