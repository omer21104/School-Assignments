// submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
package ingredients;

import exceptions.InvalidInputException;

public class Spice extends Ingredient{
    protected boolean isSpicy;

    public Spice() {
        isSpicy = false;
    }

    public Spice(String name, String measureUnit, int amount, boolean isSpicy) throws InvalidInputException {
        super(name, measureUnit, amount); // InvalidInputException can be thrown from here
        this.isSpicy = isSpicy;
    }

    // other methods
    public void action() {
        System.out.println("Add the " + name);
    }

    public void add() {
        if (isSpicy)
            System.out.printf("%d %s of spicy %s\n" , amount, measureUnit, name);
        else
            System.out.printf("%d %s of %s\n" , amount, measureUnit, name);
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
