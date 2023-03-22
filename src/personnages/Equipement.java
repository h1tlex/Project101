package personnages;

public enum Equipement {
	
    CASQUE("Casque"),
    BOUCLIER("Bouclier");

    private final String name;

    Equipement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
	@Override
	public String toString() {
		
		return "Equipment [ " + CASQUE + ", " + BOUCLIER + " ]";
	}
	
	public static void main(String[] args) {
		
	}
}
