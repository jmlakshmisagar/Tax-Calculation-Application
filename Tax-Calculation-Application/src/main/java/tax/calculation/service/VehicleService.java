package tax.calculation.service;

import tax.calculation.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    // Add a new vehicle
    public void addVehicle(String registrationNo, String brand, double velocity, int capacity, int type, double purchaseCost) {
        Vehicle vehicle = new Vehicle(registrationNo, brand, velocity, capacity, type, purchaseCost);
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully with Registration No: " + vehicle.getRegistrationNo());
    }

    // Calculate tax for a specific vehicle by registration number
    public void calculateTax(String registrationNo) {
        Vehicle vehicle = findVehicleByRegNo(registrationNo);
        if (vehicle != null) {
            vehicle.calculateTax();
            System.out.println("Vehicle tax for Registration No " + registrationNo + " is: " + vehicle.getTaxAmount());
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    // Display all vehicles
    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }
        System.out.printf("%-10s %-10s %-10s %-5s %-10s %-12s %-10s%n", 
                "REG.NO", "BRAND", "VELOCITY", "SEATS", "TYPE", "COST", "TAX");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicle();
        }
    }

    // Calculate total vehicle tax
    public double getTotalVehicleTax() {
        double total = 0.0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.getTaxAmount();
        }
        return total;
    }

    // Helper method to find vehicle by registration number
    private Vehicle findVehicleByRegNo(String regNo) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistrationNo().equals(regNo)) {
                return vehicle;
            }
        }
        return null;
    }

    // Get vehicle count
    public int getVehicleCount() {
        return vehicles.size();
    }
}
