package org.ratcm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ratcm.exceptions.RecipeException;

public class SomeTests {

	CoffeeMaker maker;

	public static void main(String[] args) {
		SomeTests test = new SomeTests();
		// faire une tasse de café
		test.testMakeCoffee();
		// faire une boisson sans suffisamment d'argent
		test.testMakeCoffeeWithoutEnoughMoney();
		// faire deux chocolats d'affilée
		test.testMakeTwoChocolates();
		// faire une boisson sans suffisamment de stock
		test.testMakeChocolatesUntilEmpty();
		// faire plusieurs cafés épuise le stock de départ
		test.testMakeMultipleCoffeeEmptiesStock();

		System.out.println("Tests terminés...");
	}

	private void testMakeCoffee() {
		// GIVEN a new coffee machine that make coffee for 50c
		setupCoffeeMachine();
		// WHEN I buy a coffee with 1$
		int change = maker.makeCoffee(0, 100);
		// THEN I get 50c has change
		assertEquals(50, change);
		// AND the coffee machine has less coffee
		assert (maker.checkInventory().contains("Coffee: 13"));
		System.out.println("	testMakeCoffee OK");

	}

	private void testMakeCoffeeWithoutEnoughMoney() {
		// GIVEN a new coffee machine that make coffee for 50c
		setupCoffeeMachine();
		// WHEN I buy a coffee with 25c
		int change = maker.makeCoffee(0, 25);
		// THEN I get 25 has change
		assertEquals(25, change);
		System.out.println("	testMakeCoffeeWithoutEnoughMoney OK");

	}

	private void testMakeTwoChocolates() {
		// GIVEN a new coffee machine that make chocolates for 50c
		setupCoffeeMachine();
		// WHEN I buy three chocolates with just enough money
		int change = 0;
		change = maker.makeCoffee(1, 50);
		change = maker.makeCoffee(1, 50);
		change = maker.makeCoffee(1, 50);

		// THEN I get 0c has change
		assertEquals(0, change);
		System.out.println("	testMakeTwoChocolates OK");

	}

	private void testMakeChocolatesUntilEmpty() {
		// GIVEN a new coffee machine that make chocolates for 50c
		setupCoffeeMachine();
		int change = 0;
		// WHEN I buy 100 chocolates with 50c
		for (int i = 0; i < 100; i++) {
			change = maker.makeCoffee(1, 50);
		}

		// THEN I get 50c has change
		assertEquals(50, change);
		System.out.println("	testMakeCoffeeWithoutEnoughChocolate OK");

	}

	private void testMakeMultipleCoffeeEmptiesStock() {
		// GIVEN a new coffee machine that make chocolates for 50c
		setupCoffeeMachine();
		int change = 0;
		// WHEN I buy 100 chocolates with 50c
		for (int i = 0; i < 100; i++) {
			change = maker.makeCoffee(0, 50);
		}

		// THEN the coffee stock is empty
		assertEquals("Coffee: 1\n" + "Milk: 15\n" + "Sugar: 15\n" + "Chocolate: 15\n", maker.checkInventory());
		System.out.println("	testMakeMultipleCoffeeEmptiesStock OK");
	}

	private void setupCoffeeMachine() {

		maker = new CoffeeMaker();
		try {
			Recipe r1 = new Recipe();
			r1.setName("coffee");
			r1.setAmtCoffee("2");
			r1.setAmtChocolate("0");
			r1.setAmtSugar("0");
			r1.setAmtMilk("0");
			r1.setPrice("50");
			maker.addRecipe(r1);

			Recipe r2 = new Recipe();
			r2.setName("chocolate");
			r2.setAmtCoffee("0");
			r2.setAmtChocolate("5");
			r2.setAmtSugar("0");
			r2.setAmtMilk("0");
			r2.setPrice("50");
			maker.addRecipe(r2);
		} catch (RecipeException e) {
			e.printStackTrace();
			System.out.println("Unable to initialize CoffeeMaker");
		}

	}

}
