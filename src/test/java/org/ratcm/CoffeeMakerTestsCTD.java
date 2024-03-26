package org.ratcm;

public class CoffeeMakerTestsCTD {

	CoffeeMaker maker;

	public static void main(String[] args) {
		CoffeeMakerTestsCTD tests = new CoffeeMakerTestsCTD();
		System.out.println("Lancement des tests...");
		// test 1 : buy a coffee with enough money
		tests.testBuyCoffeeWithEnoughMoney();
		// test 2 : buy a coffee with not enough money
		tests.testBuyCoffeeWithoutEnoughNotMoney();
		// test 3 : buy a coffee and there is less coffee
		// tests.testBuyCoffeeEmptiesInventory();
		// test 4 : buy a coffee with an empty coffee machine
		tests.testBuyCoffeeWithAnEmptyCoffeeMachine();
		System.out.println("...tests OK");

	}

	private void setUpCoffeeMachineWithACoffeeRecipe() {
		maker = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setName("coffee");
		// TODO: change setAmtChocolate parameters to int
		try {
			r1.setAmtChocolate("0");
			r1.setAmtCoffee("2");
			r1.setAmtMilk("0");
			r1.setAmtSugar("0");
			r1.setPrice("100");
			maker.addRecipe(r1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Reciepe creation failed");
		}
	}

	private void testBuyCoffeeWithEnoughMoney() {
		// GIVEN : a new coffee machine that sells coffee for 100c
		setUpCoffeeMachineWithACoffeeRecipe();
		// WHEN : I buy a coffee with 500c
		int change = maker.makeCoffee(0, 500);
		// THEN : My change is 4$
		assert (change == 400);
		System.out.println("test 1 OK");

	}

	private void testBuyCoffeeWithoutEnoughNotMoney() {
		// GIVEN : a new coffee machine that sells coffee for 100c
		setUpCoffeeMachineWithACoffeeRecipe();
		// WHEN : I buy a coffee with 50c
		int change = maker.makeCoffee(0, 50);
		// THEN : My change is 50c
		assert (change == 50);
		System.out.println("test 2 OK");
	}

	private void testBuyCoffeeWithAnEmptyCoffeeMachine() {
		// GIVEN : a new coffee machine that sells coffee for 100c
		setUpCoffeeMachineWithACoffeeRecipe();
		// WHEN : I buy lors of coffee with 100c
		int change = 0;
		for (int i = 0; i < 100; i++) {
			change = maker.makeCoffee(0, 100);
		}
		// THEN : My change is 100c
		System.out.println(maker.checkInventory());
		assert (change == 100);
		System.out.println("test 2 OK");
	}

}
