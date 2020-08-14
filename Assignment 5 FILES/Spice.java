package ingredients;

public class Spice extends Ingredient{
	protected boolean isSpicy;

	public Spice() {
		isSpicy = false;
	}
	
	public Spice(String name, String measureUnit, int amount, boolean isSpicy) {
		super(name, measureUnit, amount);
		this.isSpicy = isSpicy;
	}
	
	// other methods
	public void action() {
		super.action("Add");
	}
	
	public void add() {
		super.add(isSpicy, "spicy");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spice other = (Spice) obj;
		if (isSpicy != other.isSpicy)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "isSpicy= " + isSpicy + "\n";
	}
	
}
