package tax.calculation.model;

import tax.calculation.interfaces.TaxCalculator;

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

	public double getBuiltUpArea() {
		return builtUpArea;
	}

	public double getBaseValue() {
		return baseValue;
	}

	public int getAge() {
		return age;
	}

	public boolean isCity() {
		return isCity;
	}

	public String[] toTableRow() {
		return new String[] { String.valueOf(id), String.format("%.2f", builtUpArea), String.format("%.2f", baseValue),
				String.valueOf(age), isCity ? "CITY" : "NON-CITY", String.format("%.2f", taxAmount) };
	}
}
