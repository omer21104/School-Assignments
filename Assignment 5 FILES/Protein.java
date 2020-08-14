package ingredients;

public class Protein extends Ingredient{
	// fields
	protected boolean isReplacement;
	
	// constructors
	public Protein() {
		isReplacement = false;
	}
	
	public Protein(String name, String measureUnit, int amount, boolean isReplacement) {
		super(name, measureUnit, amount);
		this.isReplacement = isReplacement;
	}
	
	// other methods
	public void action() {
		super.action("cook");
	}
	
	public void add() {
		if (isReplacement)
			System.out.printf("%d %s of %s replacement\n", amount, measureUnit, name);
		else
			System.out.printf("%d %s of %s\n", amount, measureUnit, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Protein other = (Protein) obj;
		if (isReplacement != other.isReplacement)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "isOrganic= " + isReplacement + "\n";
	}

}
