// submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
package ingredients;

import exceptions.InvalidInputException;

public abstract class Ingredient {
    // fields
    protected String name, measureUnit;
    protected int amount;

    // constructors
    public Ingredient() {
        name = "";
        measureUnit = "";
        amount = 0;
    }

    public Ingredient(String name, String measureUnit, int amount) throws InvalidInputException {
        setName(name);
        setMeasureUnit(measureUnit);
        setAmount(amount);
    }

    // set
    protected void setAmount(int amount) throws InvalidInputException {
        if (amount > 0)
            this.amount = amount;
        else
            throw new InvalidInputException("Error, negative amount: " + amount);
    }
    
    protected void setName(String name) throws InvalidInputException {
    	if (name == "" || name == null)
    		throw new InvalidInputException("Error in name selection");
    	// else, name is valid
    	this.name = name;
    }
    
    protected void setMeasureUnit(String measureUnit) throws InvalidInputException {
    	if (measureUnit == "" || measureUnit == null)
    		throw new InvalidInputException("Error in measure unit selection");
    	// else, name is valid
    	this.measureUnit = measureUnit;
    }

    // abstract add and action methods
    public abstract void action();

    public abstract void add();

    @Override
    public String toString() {
        return "name= " + name + ", measureUnit= " + measureUnit + ", amount= " + amount + "\n";
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
