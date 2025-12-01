
package tax.calculation.model;

import java.text.DecimalFormat;
import tax.calculation.service.TaxCalculator;

public class Property implements TaxCalculator {
	private int id;
	private double builtUpArea;
	private double baseValue;
	private int age;
	private boolean isCity;
	private double taxAmount;

	// Constructor
	public Property(int id, double builtUpArea, double baseValue, int age, boolean isCity) {
		this.id = id;
		this.builtUpArea = builtUpArea;
		this.baseValue = baseValue;
		this.age = age;
		this.isCity = isCity;
		this.taxAmount = 0.0;
	}

	// Implement calculateTax() from TaxCalculator
	@Override
	public void calculateTax() {
		double ageFactor = age; // Using age as factor
		if (isCity) {
			taxAmount = (builtUpArea * ageFactor * baseValue) + (0.5 * builtUpArea);
		} else {
			taxAmount = builtUpArea * ageFactor * baseValue;
		}
	}

	// Implement getTaxAmount() from TaxCalculator
	@Override
	public double getTaxAmount() {
		return taxAmount;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public double getBuiltUpArea() {
		return builtUpArea;
	}

	public void setBuiltUpArea(double builtUpArea) {
		this.builtUpArea = builtUpArea;
	}

	public double getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(double baseValue) {
		this.baseValue = baseValue;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isCity() {
		return isCity;
	}

	public void setCity(boolean city) {
		isCity = city;
	}

	// Display property details
	public void displayProperty() {
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.printf("%-5d %-10.2f %-10.2f %-5d %-6s %-10s%n", id, builtUpArea, baseValue, age,
				(isCity ? "Y" : "N"), df.format(taxAmount));
	}
}
