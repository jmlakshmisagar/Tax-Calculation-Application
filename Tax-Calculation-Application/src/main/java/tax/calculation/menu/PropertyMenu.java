
package tax.calculation.menu;

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

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Built-up Area: ");
                    double area = sc.nextDouble();
                    if (!InputValidator.isPositiveDouble(area)) {
                        System.out.println("Invalid area! Must be positive.");
                        break;
                    }

                    System.out.print("Enter Base Value: ");
                    double baseValue = sc.nextDouble();
                    if (!InputValidator.isPositiveDouble(baseValue)) {
                        System.out.println("Invalid base value! Must be positive.");
                        break;
                    }

                    System.out.print("Enter Age of Property: ");
                    int age = sc.nextInt();
                    if (!InputValidator.isPositiveInt(age)) {
                        System.out.println("Invalid age! Must be positive.");
                        break;
                    }

                    System.out.print("Is property in city? (Y/N): ");
                    String cityInput = sc.next();
                    if (!InputValidator.isValidCityInput(cityInput)) {
                        System.out.println("Invalid input! Enter Y or N.");
                        break;
                    }
                    boolean isCity = cityInput.equalsIgnoreCase("Y");

                    propertyService.addProperty(area, baseValue, age, isCity);
                }
                case 2 -> {
                    System.out.print("Enter Property ID to calculate tax: ");
                    int id = sc.nextInt();
                    if (!InputValidator.isPositiveInt(id)) {
                        System.out.println("Invalid ID! Must be positive.");
                        break;
                    }
                    propertyService.calculateTax(id);
                }
                case 3 -> propertyService.displayAllProperties();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (option != 4);
    }
}
