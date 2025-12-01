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

	public Property(int id, double builtUpArea, double baseValue, int age, boolean isCity) {
		this.id = id;
		this.builtUpArea = builtUpArea;
		this.baseValue = baseValue;
		this.age = age;
		this.isCity = isCity;
		this.taxAmount = 0.0;
	}

	@Override
	public void calculateTax() {
		double ageFactor = age;
		if (isCity) {
			taxAmount = (builtUpArea * ageFactor * baseValue) + (0.5 * builtUpArea);
		} else {
			taxAmount = builtUpArea * ageFactor * baseValue;
		}
	}

	@Override
	public double getTaxAmount() {
		return taxAmount;
	}

	public int getId() {
		return id;
	}

	public void displayProperty() {
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.printf("%-5d %-10.2f %-10.2f %-5d %-6s %-10s%n", id, builtUpArea, baseValue, age,
				(isCity ? "Y" : "N"), df.format(taxAmount));
	}
}
