package org.ratcm;

import org.ratcm.exceptions.RecipeException;

public class CoffeeMakerGivenWhenThen {

	CoffeeMaker cm = null;
	int change;

	public CoffeeMaker givenANewCoffeMaker() throws RecipeException {
		cm = new CoffeeMaker();
		Recipe coffeeRecipe = new Recipe();
		coffeeRecipe.setName("CAFE");
		coffeeRecipe.setAmtCoffee("1");
		coffeeRecipe.setAmtSugar("1");
		coffeeRecipe.setPrice("75");
		cm.addRecipe(coffeeRecipe);

		Recipe sugarFreeRecipe = new Recipe();
		sugarFreeRecipe.setName("SANS SUCRE");
		sugarFreeRecipe.setAmtCoffee("1");
		sugarFreeRecipe.setPrice("50");
		cm.addRecipe(sugarFreeRecipe);

		return cm;
	}

	public void whenACoffeeIsOrderedWith100cents() {
		change = cm.makeCoffee(0, 100);
	}

	public void thenChangeIsEqualTo25() {
		assert (change == 25);
		System.out.println("\tTest OK");
	}

	public static void main(String[] args) {
		System.out.println("Début des tests");
		CoffeeMakerGivenWhenThen gwt = new CoffeeMakerGivenWhenThen();
		gwt.testOrderCoffeeWith100cents();
		System.out.println("Tests OK !");

	}

	private void testOrderCoffeeWith100cents() {
		try {
			givenANewCoffeMaker();
			whenACoffeeIsOrderedWith100cents();
			thenChangeIsEqualTo25();
		} catch (RecipeException e) {
			e.printStackTrace();
			System.out.println("Test failed");
		}
	}

}
