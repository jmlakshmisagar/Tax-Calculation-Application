package tax.calculation.menu;

import tax.calculation.exception.InvalidInputException;
import tax.calculation.service.PropertyService;
import tax.calculation.util.InputValidator;

import java.util.Scanner;

public class PropertyMenu {
	public static void showPropertyMenu(Scanner sc, PropertyService propertyService) {
		int option;
		do {
			System.out.println("\nPROPERTY TAX MENU");
			System.out.println("1. ADD PROPERTY DETAILS");
			System.out.println("2. CALCULATE PROPERTY TAX");
			System.out.println("3. DISPLAY ALL PROPERTIES");
			System.out.println("4. BACK TO MAIN MENU");
			System.out.print("Enter your choice: ");
			option = sc.nextInt();

			try {
				switch (option) {
				case 1 -> {
					System.out.print("Enter Built-up Area: ");
					double area = sc.nextDouble();
					if (!InputValidator.isPositiveDouble(area)) {
						throw new InvalidInputException("Built-up area must be positive!");
					}

					System.out.print("Enter Base Value: ");
					double baseValue = sc.nextDouble();
					if (!InputValidator.isPositiveDouble(baseValue)) {
						throw new InvalidInputException("Base value must be positive!");
					}

					System.out.print("Enter Age of Property: ");
					int age = sc.nextInt();
					if (!InputValidator.isPositiveInt(age)) {
						throw new InvalidInputException("Age must be positive!");
					}

					System.out.print("Is property in city? (Y/N): ");
					String cityInput = sc.next();
					if (!InputValidator.isValidCityInput(cityInput)) {
						throw new InvalidInputException("City input must be Y or N!");
					}
					boolean isCity = cityInput.equalsIgnoreCase("Y");

					propertyService.addProperty(area, baseValue, age, isCity);
				}
				case 2 -> {
					System.out.print("Enter Property ID to calculate tax: ");
					int id = sc.nextInt();
					if (!InputValidator.isPositiveInt(id)) {
						throw new InvalidInputException("Property ID must be positive!");
					}
					propertyService.calculateTax(id);
				}
				case 3 -> propertyService.displayAllProperties();
				case 4 -> System.out.println("Returning to Main Menu...");
				default -> System.out.println("Invalid choice! Try again.");
				}
			} catch (InvalidInputException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (option != 4);
	}
}
