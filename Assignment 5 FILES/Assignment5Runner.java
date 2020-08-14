package runner;

import java.util.Scanner;

import ingredients.*;
public class Assignment5Runner {
	
public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Ingredient[] salad = createSalad();
		
		// add the vegetables
		System.out.println("Ingredients list: ");
		for (Ingredient ingredient : salad)
		{
			if (ingredient instanceof Vegetable)
				((Vegetable) ingredient).add();
			else if (ingredient instanceof Spice)
				((Spice) ingredient).add();
			else if (ingredient instanceof Protein)
				((Protein) ingredient).add();
		}
		System.out.println();
		
		// print instructions
		System.out.println("Instructions: ");
		for (Ingredient ingredient : salad)
			if (ingredient instanceof Vegetable)
				((Vegetable) ingredient).action();
			else if (ingredient instanceof Spice)
				((Spice) ingredient).action();
			else if (ingredient instanceof Protein)
				((Protein) ingredient).action();
	}
	
	public static Ingredient[] createSalad() {
		System.out.print("Enter number of ingredients for your salad:");
		int size = input.nextInt();
		Ingredient[] salad = new Ingredient[size];
		
		// initialize all the salad ingredients
		for (int i = 0; i < salad.length; i++) 
			salad[i] = createIngredient();
		
		return salad;
	}
	
	public static Ingredient createIngredient() {
		String name, measureUnit;
		int amount, type;
		boolean variant;
		System.out.println("Select ingredient type: ");
		System.out.println("1. vegetable");
		System.out.println("2. spice");
		System.out.println("3. protein");
		type = input.nextInt();
		input.nextLine();
		System.out.print("Enter name of ingredient: ");
		name = input.nextLine();
		System.out.print("Enter measurement unit of ingredient: ");
		measureUnit = input.nextLine();
		System.out.print("Enter amount of ingredient: ");
		amount = input.nextInt();
		
		// create an instace of an object according to type
		char choice;
		switch (type) {
		case 1:
			// vegetable
			System.out.println("is it organic? y/n");
			choice = input.next().charAt(0);
			variant = (choice == 'y') ? true : false;
			// return the complete object
			return new Vegetable(name, measureUnit, amount, variant);
		case 2:
			// spice
			System.out.println("is it spicy? y/n");
			choice = input.next().charAt(0);
			variant = (choice == 'y') ? true : false;
			// return the complete object
			return new Spice(name, measureUnit, amount, variant);
		case 3:
			// spice
			System.out.println("is it a replacement? y/n");
			choice = input.next().charAt(0);
			variant = (choice == 'y') ? true : false;
			// return the complete object
			return new Protein(name, measureUnit, amount, variant);

		default:
			return new Ingredient();
		}
		
		
		
	}

}
