package ingredients;

public class Ingredient {
	// fields
	protected String name, measureUnit;
	protected int amount;

	// constructors
	public Ingredient() {
		name = "";
		measureUnit = "";
		amount = 0;
	}
	
	public Ingredient(String name, String measureUnit, int amount) {
		this.name = name;
		this.measureUnit = measureUnit;
		setAmount(amount);
	}
	
	// set
	protected void setAmount(int amount) {
		this.amount = amount > 0 ? amount : 0;
	}

	// other methods
	public void action(String action) {
		System.out.printf("%s the %ss\n", action, name);
	}
	
	public void add(boolean condition, String description) {
		if (condition)
			System.out.printf("%d %s of %s %s\n", amount, measureUnit, description, name);
		else
			System.out.printf("%d %s of %s\n", amount, measureUnit, name);
	}
	
	@Override
	public String toString() {
		return "name= " + name + ", measureUnit= " + measureUnit + "amount= " + amount + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (measureUnit == null) {
			if (other.measureUnit != null)
				return false;
		} else if (!measureUnit.equals(other.measureUnit))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
