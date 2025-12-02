package tax.calculation.service;

import tax.calculation.model.Vehicle;
import tax.calculation.util.ConsoleTable;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(String registrationNo, String brand, double velocity,
                           int capacity, int type, double purchaseCost) {

        Vehicle vehicle = new Vehicle(registrationNo, brand, velocity, capacity, type, purchaseCost);
        vehicle.calculateTax();
        vehicles.add(vehicle);

        System.out.println(
                "Vehicle added successfully with Reg No: " + registrationNo +
                " | Tax: " + vehicle.getTaxAmount());
    }

    public void calculateTax(String registrationNo) {
        Vehicle vehicle = findVehicleByRegNo(registrationNo);

        if (vehicle != null) {
            vehicle.calculateTax();
            System.out.println("Vehicle tax for Reg No " + registrationNo + " is: " + vehicle.getTaxAmount());
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        ConsoleTable table = new ConsoleTable(
                "REG.NO", "BRAND", "VELOCITY", "SEATS", "TYPE", "COST", "TAX"
        );

        for (Vehicle v : vehicles) {
            table.addRow(v.toTableRow());
        }

        table.printTable();
    }

    public double getTotalVehicleTax() {
        return vehicles.stream().mapToDouble(Vehicle::getTaxAmount).sum();
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    private Vehicle findVehicleByRegNo(String regNo) {
        return vehicles.stream()
                .filter(v -> v.getRegistrationNo().equals(regNo))
                .findFirst()
                .orElse(null);
    }
}
