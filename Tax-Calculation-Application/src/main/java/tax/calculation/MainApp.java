package tax.calculation;

import tax.calculation.menu.PropertyMenu;
import tax.calculation.menu.VehicleMenu;
import tax.calculation.menu.MenuUtils;
import tax.calculation.service.PropertyService;
import tax.calculation.service.VehicleService;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("WELCOME TO TAX CALCULATION APP");
		System.out.println("Developer: LakshmiSagar J M");
		System.out.println("--------------------------------");
		System.out.println("Features: Calculate Property Tax, Vehicle Tax, and Total Tax.");
		System.out.println("PLEASE LOGIN TO CONTINUE");

		boolean loggedIn = false;
		for (int attempts = 3; attempts > 0; attempts--) {
			System.out.print("USERNAME: ");
			String username = sc.next();
			System.out.print("PASSWORD: ");
			String password = sc.next();

			if (username.equals("admin") && password.equals("admin123")) {
				loggedIn = true;
				System.out.println("\nLogin successful! Welcome, Admin.");
				break;
			} else {
				System.out.println("Invalid credentials! Attempts left: " + (attempts - 1));
			}
		}

		if (!loggedIn) {
			System.out.println("Too many failed attempts. Exiting...");
			sc.close();
			return;
		}

		PropertyService propertyService = new PropertyService();
		VehicleService vehicleService = new VehicleService();

		int choice;
		do {
			System.out.println("\nMAIN MENU");
			System.out.println("1. PROPERTY TAX");
			System.out.println("2. VEHICLE TAX");
			System.out.println("3. TOTAL TAX");
			System.out.println("4. EXIT");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1 -> PropertyMenu.showPropertyMenu(sc, propertyService);
			case 2 -> VehicleMenu.showVehicleMenu(sc, vehicleService);
			case 3 -> MenuUtils.showTotal(propertyService, vehicleService);
			case 4 -> System.out.println("THANK YOU! VISIT AGAIN.");
			default -> System.out.println("Invalid choice! Please try again.");
			}
		} while (choice != 4);

		sc.close();
	}
}
