package tax.calculation.service;

import tax.calculation.model.Property;
import java.util.ArrayList;
import java.util.List;

public class PropertyService {
	private List<Property> properties = new ArrayList<>();
	private int propertyIdCounter = 1;

	public void addProperty(double builtUpArea, double baseValue, int age, boolean isCity) {

		Property property = new Property(propertyIdCounter++, builtUpArea, baseValue, age, isCity);
		property.calculateTax();
		properties.add(property);
		System.out.println(
				"Property added successfully with ID: " + property.getId() + " | Tax: " + property.getTaxAmount());
	}

	public void calculateTax(int propertyId) {
		Property property = findPropertyById(propertyId);
		if (property != null) {
			property.calculateTax();
			System.out.println("Property tax for ID " + propertyId + " is: " + property.getTaxAmount());
		} else {
			System.out.println("Property ID not found!");
		}
	}

	public void displayAllProperties() {
		if (properties.isEmpty()) {
			System.out.println("No properties available.");
			return;
		}
		System.out.printf("%-5s %-10s %-10s %-5s %-6s %-10s%n", "ID", "AREA", "BASE", "AGE", "CITY", "TAX");
		properties.forEach(Property::displayProperty);
	}

	public double getTotalPropertyTax() {
		return properties.stream().mapToDouble(Property::getTaxAmount).sum();
	}

	public int getPropertyCount() {
		return properties.size();
	}

	private Property findPropertyById(int id) {
		return properties.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}
}
