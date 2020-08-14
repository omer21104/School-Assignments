package ingredients;

public class Vegetable extends Ingredient {
	// fields
	protected int amount;
	protected boolean isOrganic;
	
	// constructors
	public Vegetable() {
		amount = 0;
		isOrganic = false;
	}
	
	public Vegetable(String name, String measureUnit, int amount, boolean isOrganic) {
		super(name, measureUnit, amount);
		this.isOrganic = isOrganic;
	}
	
	// other methods
	public void action() {
		super.action("Chop");
	}
	
	public void add() {
		super.add(isOrganic, "organic");
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "isOrganic= " + isOrganic + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vegetable other = (Vegetable) obj;
		if (amount != other.amount)
			return false;
		if (isOrganic != other.isOrganic)
			return false;
		return true;
	}
	
	
}
