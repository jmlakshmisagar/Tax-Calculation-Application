
package tax.calculation.model;

import java.text.DecimalFormat;
import tax.calculation.service.TaxCalculator;

public class Vehicle implements TaxCalculator {
	private String registrationNo;
	private String brand;
	private double velocity;
	private int capacity;
	private int type; // 1 = Petrol, 2 = Diesel, 3 = CNG/LPG
	private double purchaseCost;
	private double taxAmount;

	// Constructor
	public Vehicle(String registrationNo, String brand, double velocity, int capacity, int type, double purchaseCost) {
		this.registrationNo = registrationNo;
		this.brand = brand;
		this.velocity = velocity;
		this.capacity = capacity;
		this.type = type;
		this.purchaseCost = purchaseCost;
		this.taxAmount = 0.0;
	}

	// Implement calculateTax() from TaxCalculator
	@Override
	public void calculateTax() {
		double percentage;
		switch (type) {
		case 1:
			percentage = 0.10;
			break; // Petrol
		case 2:
			percentage = 0.11;
			break; // Diesel
		case 3:
			percentage = 0.12;
			break; // CNG/LPG
		default:
			percentage = 0.0;
			break;
		}
		taxAmount = velocity + capacity + (purchaseCost * percentage);
	}

	// Implement getTaxAmount() from TaxCalculator
	@Override
	public double getTaxAmount() {
		return taxAmount;
	}

	// Getters
	public String getRegistrationNo() {
		return registrationNo;
	}

	public String getBrand() {
		return brand;
	}

	public double getVelocity() {
		return velocity;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getType() {
		return type;
	}

	public double getPurchaseCost() {
		return purchaseCost;
	}

	// Display vehicle details
	public void displayVehicle() {
		DecimalFormat df = new DecimalFormat("#.00");
		String typeName = (type == 1) ? "PETROL" : (type == 2) ? "DIESEL" : "CNG/LPG";
		System.out.printf("%-10s %-10s %-10.2f %-5d %-10s %-12.2f %-10s%n", registrationNo, brand, velocity, capacity,
				typeName, purchaseCost, df.format(taxAmount));
	}
}
