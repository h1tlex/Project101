package personnages;

public enum Equipement {
	
    CASQUE("Casque"),
    BOUCLIER("Bouclier");

    private String name;

    Equipement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
	@Override
	public String toString() {
		
		return "Equipment [ " + name + " ]";
	}
	
	public static void main(String[] args) {
	    System.out.println(Equipement.CASQUE); // prints "Equipment [ Casque ]"
	    System.out.println(Equipement.BOUCLIER); // prints "Equipment [ Bouclier ]"
	}
}
