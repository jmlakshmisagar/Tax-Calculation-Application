package tax.calculation.model;

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
		case 1 -> 0.10;
		case 2 -> 0.11;
		case 3 -> 0.12;
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

	/**
	 * Returns a row for ConsoleTable
	 */
	public String[] toTableRow() {

		String typeName = switch (type) {
		case 1 -> "PETROL";
		case 2 -> "DIESEL";
		case 3 -> "CNG/LPG";
		default -> "UNKNOWN";
		};

		return new String[] { registrationNo, brand, String.format("%.2f", velocity), String.valueOf(capacity),
				typeName, String.format("%.2f", purchaseCost), String.format("%.2f", taxAmount) };
	}
}
