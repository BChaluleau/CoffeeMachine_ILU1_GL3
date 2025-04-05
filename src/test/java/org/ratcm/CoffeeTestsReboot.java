package org.ratcm;

public class CoffeeTestsReboot {

	CoffeeMaker cm;

	public void setup() {
		cm = new CoffeeMaker();
		try {
			Recipe r1 = new Recipe();
			r1.setName("cafe sucré");
			r1.setPrice("10");
			r1.setAmtCoffee("2");
			r1.setAmtSugar("1");
			cm.addRecipe(r1);

			Recipe r2 = new Recipe();
			r2.setName("cafe très sucré");
			r2.setPrice("10");
			r2.setAmtCoffee("2");
			r2.setAmtSugar("666");
			cm.addRecipe(r2);

		} catch (Exception e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CoffeeTestsReboot test = new CoffeeTestsReboot();

		test.testInvalidRecipe();
		test.testValidReciepeNotEnoughMoney();
		test.testValidReciepeEnoughMoneyNotEnoughIngredients();
		test.testValidReciepeNotEnoughMoney();
		test.testValidReciepeEnoughMoneyEnoughIngredients();
		test.testMakeManyCoffeesUntilStockEmpities();
		System.out.println("  Tests OK");

	}

	private void testValidReciepeEnoughMoneyEnoughIngredients() {
		setup();
		int change = cm.makeCoffee(0, 100);
		assert change == 90;

	}

	private void testValidReciepeEnoughMoneyNotEnoughIngredients() {
		setup();
		int change = cm.makeCoffee(1, 100);
		assert change == 100;

	}

	private void testInvalidRecipe() {
		setup();
		int change = cm.makeCoffee(3, 100);
		assert change == 100;
	}

	private void testValidReciepeNotEnoughMoney() {
		setup();
		int change = cm.makeCoffee(0, 5);
		assert change == 5;
	}

	private void testMakeManyCoffeesUntilStockEmpities() {
		setup();
		for (int i = 0; i < 7; i++) {
			int change = cm.makeCoffee(0, 10);
			assert change == 0;
		}
		int change = cm.makeCoffee(0, 10);
		assert change == 10;
	}

}
