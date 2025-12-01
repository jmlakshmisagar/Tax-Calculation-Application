package tax.calculation.menu;

import tax.calculation.exception.InvalidInputException;
import tax.calculation.service.VehicleService;
import tax.calculation.util.InputValidator;

import java.util.Scanner;

public class VehicleMenu {
	public static void showVehicleMenu(Scanner sc, VehicleService vehicleService) {
		int option;
		do {
			System.out.println("\nVEHICLE TAX MENU");
			System.out.println("1. ADD VEHICLE DETAILS");
			System.out.println("2. CALCULATE VEHICLE TAX");
			System.out.println("3. DISPLAY ALL VEHICLES");
			System.out.println("4. BACK TO MAIN MENU");
			System.out.print("Enter your choice: ");
			option = sc.nextInt();

			try {
				switch (option) {
				case 1 -> {
					System.out.print("Enter Registration No (4 digits): ");
					String regNo = sc.next();
					if (!InputValidator.isValidRegistrationNumber(regNo)) {
						throw new InvalidInputException("Registration number must be 4 digits and not 0000!");
					}

					System.out.print("Enter Brand: ");
					String brand = sc.next();

					System.out.print("Enter Maximum Velocity: ");
					double velocity = sc.nextDouble();
					if (!InputValidator.isValidVelocity(velocity)) {
						throw new InvalidInputException("Velocity must be between 120 and 300 kmph!");
					}

					System.out.print("Enter Capacity (Seats): ");
					int capacity = sc.nextInt();
					if (!InputValidator.isValidCapacity(capacity)) {
						throw new InvalidInputException("Capacity must be between 2 and 50 seats!");
					}

					System.out.println("Choose Vehicle Type: 1. PETROL  2. DIESEL  3. CNG/LPG");
					int type = sc.nextInt();
					if (!InputValidator.isValidVehicleType(type)) {
						throw new InvalidInputException("Vehicle type must be 1, 2, or 3!");
					}

					System.out.print("Enter Purchase Cost: ");
					double cost = sc.nextDouble();
					if (!InputValidator.isValidPurchaseCost(cost)) {
						throw new InvalidInputException("Purchase cost must be between 50,000 and 10,00,000!");
					}

					vehicleService.addVehicle(regNo, brand, velocity, capacity, type, cost);
				}
				case 2 -> {
					System.out.print("Enter Registration No to calculate tax: ");
					String reg = sc.next();
					if (!InputValidator.isValidRegistrationNumber(reg)) {
						throw new InvalidInputException("Registration number must be 4 digits and not 0000!");
					}
					vehicleService.calculateTax(reg);
				}
				case 3 -> vehicleService.displayAllVehicles();
				case 4 -> System.out.println("Returning to Main Menu...");
				default -> System.out.println("Invalid choice! Try again.");
				}
			} catch (InvalidInputException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (option != 4);
	}
}
