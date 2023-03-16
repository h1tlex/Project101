package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
import personnages.Chef;

public class Scenario {

	public static void main(String[] args) {
		
	Gaulois asterix= new Gaulois("Asterix",8,19);
	Romain minus= new Romain("Minus",6);
	
	asterix.parler("Bonjour à tous");
	minus.parler("UN GAU... UN GAUGAU...");
	asterix.frapper(minus);
	asterix.frapper(minus);
	asterix.frapper(minus);
	
	}

}
