// submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
package runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.*;
import ingredients.*;

public class Runner {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean unhealthySalad;
        Ingredient[] salad = null;

        // make sure salad created is healthy
        do
        {
            unhealthySalad = false;
            try
            {
                salad = createSalad();
                checkHealthiness(salad);
            }
            catch (UnhealthyException e)
            {
                System.out.println("Unhealthy salad!! try again.");
                unhealthySalad = true;
            }
        } while (unhealthySalad); // keep trying until salad is healthy
        

        // add the vegetables
        System.out.println("Ingredients list: ");
        for (Ingredient ingredient : salad)
            ingredient.add();

        System.out.println();

        // print instructions
        System.out.println("Instructions: ");
        for (Ingredient ingredient : salad)
            ingredient.action();
    }
    
    // assisting methods
    public static Ingredient[] createSalad() {
        // return an array of Ingredient
        System.out.print("Enter number of ingredients for your salad, between 2-5:");
        int size = 0;
        boolean invalidSize;
        do
        {
            invalidSize  = false;
            try
            {
                size = input.nextInt();
                if (size < 2 || size > 5)
                {
                    System.out.println("Invalid salad size, enter number between 2-5");
                    invalidSize = true;
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Invalid charachter, please enter a number between 2-5");
                invalidSize = true;
                input.next(); // clear buffer
            }
        } while (invalidSize);
        // salad size received successfully

        Ingredient[] salad = new Ingredient[size];

        // initialize all the salad ingredients
        for (int i = 0; i < salad.length; i++) {
            try 
            {
                salad[i] = createIngredient();
                System.out.println("Successfully created ingredient: ");
                System.out.println(salad[i]);
            } 
            catch (InvalidInputException e) 
            {
                System.out.println(e.getMessage());
            }
        }
        return salad;
    }

    public static void printMenu() {
        System.out.println("Select ingredient type: ");
        System.out.println("1. vegetable");
        System.out.println("2. spice");
        System.out.println("3. protein");
    }

    public static Ingredient createIngredient() throws InvalidInputException {
    	// select a type of ingredient to add
    	// validate each field using a while loop
    	// return an instance of that ingredient in the end

        String name = "", measureUnit = "";
        int amount = 0;
        int type = 0;
        boolean variant;
        
        // boolean flag for each field and type of ingredient
        boolean invalidType = true;
        boolean invalidAmount = true;
        boolean invalidName = true;
        boolean invalidMeasureUnit = true;
        
        do
        {
        	try
        	{
        		// validate type selection
        		while (invalidType)
        		{
        			printMenu();
        			type = input.nextInt();
        			input.nextLine();
        			if (type < 1 || type > 3)
        			{
        				System.out.println("invalid type option selected, try again");
        				continue;
        			}
        			invalidType = false;
        		}
        		
        		// validate name input
        		while (invalidName)
        		{
        			System.out.print("Enter name of ingredient: ");
        	        name = input.nextLine();
        	        while (name.equals(""))
        	        {
        	        	System.out.println("Name cant be blank, please enter a valid name: ");
        	        	name = input.nextLine();
        	        }
        	        invalidName = false;
        		}
        		
        		// validate measurement unit input
        		while (invalidMeasureUnit)
        		{
        			System.out.print("Enter measurement unit of ingredient: ");
    		        measureUnit = input.nextLine();
    		        while (measureUnit.equals(""))
    		        {
    		        	System.out.print("Measure unit cant be blank, please enter a valid measure unit: ");
    		        	measureUnit = input.nextLine();
    		        }
    		        invalidMeasureUnit = false;
        		}
        		
        		// validate amount input
        		while (invalidAmount)
        		{
                	System.out.print("Enter amount of ingredient: ");
                	amount = input.nextInt();
                	if (amount <= 0)
                	{
                		System.out.println("Invalid amount, try again");
                		continue;
                	}
                	invalidAmount = false;
        		}
        	}
        	catch (InputMismatchException e)
        	{
        		System.out.println("Bad input, try again");
        		input.nextLine();
        	}
        	
        } while (invalidType || invalidAmount || invalidName || invalidMeasureUnit ); // keep looping while there are any invalid fields
        
        // return an ingredient based on selection
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
			variant = (choice == 'y' || choice == 'Y') ? true : false;
			// return the complete object
			return new Spice(name, measureUnit, amount, variant);
		case 3:
			// protein
			System.out.println("is it a replacement? y/n");
			choice = input.next().charAt(0);
			variant = (choice == 'y' || choice == 'Y') ? true : false;
			// return the complete object
			return new Protein(name, measureUnit, amount, variant);
		
		default:
			return null;
		}
    	
    }

    public static void checkHealthiness(Ingredient[] salad) throws UnhealthyException
    {
        boolean oneVeg = false;
        boolean oneProtein = false;

        // loop through the salad and mark and Protein and Vegetable objects
        for (Ingredient ingredient : salad)
        {
            if (ingredient instanceof Vegetable)
                oneVeg = true;
            if (ingredient instanceof Protein)
                oneProtein = true;
        }
        if (oneProtein && oneVeg)
        	return;
        else
        	throw new UnhealthyException();
    }
}
