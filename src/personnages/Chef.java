package personnages;

public class Chef extends Gaulois {
	
	private int effetPotion = 1;
	private Village village;

	public Chef(String nom, int force,int effetPotion, Village village) {
		super(nom,force,effetPotion);
		this.village = village;
	}


	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}

	private String prendreParole() {
		return "Le chef " + getNom() + " du village " + village.getNom() + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(getNom() + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup(getForce() / 3);
	}
	

}
