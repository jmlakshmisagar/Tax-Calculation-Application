
package tax.calculation.menu;

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

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Registration No (4 digits): ");
                    String regNo = sc.next();
                    if (!InputValidator.isValidRegistrationNumber(regNo)) {
                        System.out.println("Invalid registration number! Must be 4 digits and not 0000.");
                        break;
                    }

                    System.out.print("Enter Brand: ");
                    String brand = sc.next();

                    System.out.print("Enter Maximum Velocity: ");
                    double velocity = sc.nextDouble();
                    if (!InputValidator.isValidVelocity(velocity)) {
                        System.out.println("Invalid velocity! Must be between 120 and 300 kmph.");
                        break;
                    }

                    System.out.print("Enter Capacity (Seats): ");
                    int capacity = sc.nextInt();
                    if (!InputValidator.isValidCapacity(capacity)) {
                        System.out.println("Invalid capacity! Must be between 2 and 50 seats.");
                        break;
                    }

                    System.out.println("Choose Vehicle Type: 1. PETROL  2. DIESEL  3. CNG/LPG");
                    int type = sc.nextInt();
                    if (!InputValidator.isValidVehicleType(type)) {
                        System.out.println("Invalid type! Must be 1, 2, or 3.");
                        break;
                    }

                    System.out.print("Enter Purchase Cost: ");
                    double cost = sc.nextDouble();
                    if (!InputValidator.isValidPurchaseCost(cost)) {
                        System.out.println("Invalid cost! Must be between 50,000 and 10,00,000.");
                        break;
                    }

                    vehicleService.addVehicle(regNo, brand, velocity, capacity, type, cost);
                }
                case 2 -> {
                    System.out.print("Enter Registration No to calculate tax: ");
                    String reg = sc.next();
                    if (!InputValidator.isValidRegistrationNumber(reg)) {
                        System.out.println("Invalid registration number! Must be 4 digits and not 0000.");
                        break;
                    }
                    vehicleService.calculateTax(reg);
                }
                case 3 -> vehicleService.displayAllVehicles();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (option != 4);
    }
}
