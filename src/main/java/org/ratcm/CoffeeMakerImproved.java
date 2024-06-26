package org.ratcm;

import org.ratcm.exceptions.InventoryException;

public class CoffeeMakerImproved {
	/** Array of recipes in coffee maker */
	private static RecipeBook recipeBook;
	/** Inventory of the coffee maker */
	private static Inventory inventory;

	/**
	 * Constructor for the coffee maker
	 *
	 */
	public CoffeeMakerImproved() {
		recipeBook = new RecipeBook();
		inventory = new Inventory();
	}

	/**
	 * Returns true if the recipe is added to the list of recipes in the CoffeeMaker
	 * and false otherwise.
	 * 
	 * @param r
	 * @return boolean
	 */
	public boolean addRecipe(Recipe r) {
		return recipeBook.addRecipe(r);
	}

	/**
	 * Returns the name of the successfully deleted recipe or null if the recipe
	 * cannot be deleted.
	 * 
	 * @param recipeToDelete
	 * @return String
	 */
	public String deleteRecipe(int recipeToDelete) {
		return recipeBook.deleteRecipe(recipeToDelete);
	}

	/**
	 * Returns the name of the successfully edited recipe or null if the recipe
	 * cannot be edited.
	 * 
	 * @param recipeToEdit
	 * @param r
	 * @return String
	 */
	public String editRecipe(int recipeToEdit, Recipe r) {
		return recipeBook.editRecipe(recipeToEdit, r);
	}

	/**
	 * Returns true if inventory was successfully added
	 * 
	 * @param amtCoffee
	 * @param amtMilk
	 * @param amtSugar
	 * @param amtChocolate
	 * @return boolean
	 */
	public void addInventory(String amtCoffee, String amtMilk, String amtSugar, String amtChocolate)
			throws InventoryException {
		inventory.addCoffee(amtCoffee);
		inventory.addMilk(amtMilk);
		inventory.addSugar(amtSugar);
		inventory.addChocolate(amtChocolate);
	}

	/**
	 * Returns the inventory of the coffee maker
	 * 
	 * @return Inventory
	 */
	public String checkInventory() {
		return inventory.toString();
	}

	/**
	 * Returns the change of a user's beverage purchase, or the user's money if the
	 * beverage cannot be made
	 * 
	 * @param recipeNb
	 * @param amtPaid
	 * @return int
	 */
	public int makeCoffee(int recipeNb, int amtPaid) {
		int change = 0;

		final Recipe recipeToPurchase = getRecipes()[recipeNb];
		final int beveragePrice = recipeToPurchase != null ? recipeToPurchase.getPrice() : null;
		if ((recipeToPurchase != null) && (beveragePrice <= amtPaid) && (inventory.useIngredients(recipeToPurchase))) {
			change = amtPaid - beveragePrice;
		} else {
			change = amtPaid;
		}

		return change;
	}

	/**
	 * Returns the list of Recipes in the RecipeBook.
	 * 
	 * @return Recipe []
	 */
	public Recipe[] getRecipes() {
		return recipeBook.getRecipes();
	}
}
