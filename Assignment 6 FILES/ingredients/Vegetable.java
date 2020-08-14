// submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
package ingredients;

import exceptions.InvalidInputException;

public class Vegetable extends Ingredient {
    // fields
    protected boolean isOrganic;

    // constructors
    public Vegetable() {
        amount = 0;
        isOrganic = false;
    }

    public Vegetable(String name, String measureUnit, int amount, boolean isOrganic) throws InvalidInputException {
        super(name, measureUnit, amount); // InvalidInputException can be thrown from here
        this.isOrganic = isOrganic;
    }

    // other methods
    public void action() {
        System.out.println("Chop the " + name);
    }

    public void add() {
        if (isOrganic)
            System.out.printf("%d %s of organic %s\n", amount, measureUnit, name);
        else
            System.out.printf("%d %s of %s\n", amount, measureUnit, name);
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
