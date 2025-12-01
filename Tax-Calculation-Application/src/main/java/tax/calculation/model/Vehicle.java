package tax.calculation.model;

import java.text.DecimalFormat;
import tax.calculation.service.TaxCalculator;

public class Vehicle implements TaxCalculator {
	private String registrationNo;
	private String brand;
	private double velocity;
	private int capacity;
	private int type;
	private double purchaseCost;
	private double taxAmount;

	public Vehicle(String registrationNo, String brand, double velocity, int capacity, int type, double purchaseCost) {
		this.registrationNo = registrationNo;
		this.brand = brand;
		this.velocity = velocity;
		this.capacity = capacity;
		this.type = type;
		this.purchaseCost = purchaseCost;
		this.taxAmount = 0.0;
	}

	@Override
	public void calculateTax() {
		double percentage = switch (type) {
		case 1 -> 0.10; // Petrol
		case 2 -> 0.11; // Diesel
		case 3 -> 0.12; // CNG/LPG
		default -> 0.0;
		};
		taxAmount = velocity + capacity + (purchaseCost * percentage);
	}

	@Override
	public double getTaxAmount() {
		return taxAmount;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void displayVehicle() {
		DecimalFormat df = new DecimalFormat("#.00");
		String typeName = (type == 1) ? "PETROL" : (type == 2) ? "DIESEL" : "CNG/LPG";
		System.out.printf("%-10s %-10s %-10.2f %-5d %-10s %-12.2f %-10s%n", registrationNo, brand, velocity, capacity,
				typeName, purchaseCost, df.format(taxAmount));
	}
}
