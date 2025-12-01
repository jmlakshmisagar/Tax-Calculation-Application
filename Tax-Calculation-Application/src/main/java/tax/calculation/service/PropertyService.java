package tax.calculation.service;

import tax.calculation.model.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyService {
	private List<Property> properties = new ArrayList<>();
	private int propertyIdCounter = 1;

	// Add a new property
	public void addProperty(double builtUpArea, double baseValue, int age, boolean isCity) {
		Property property = new Property(propertyIdCounter++, builtUpArea, baseValue, age, isCity);
		properties.add(property);
		System.out.println("Property added successfully with ID: " + property.getId());
	}

	// Calculate tax for a specific property by ID
	public void calculateTax(int propertyId) {
		Property property = findPropertyById(propertyId);
		if (property != null) {
			property.calculateTax();
			System.out.println("Property tax for ID " + propertyId + " is: " + property.getTaxAmount());
		} else {
			System.out.println("Property ID not found!");
		}
	}

	// Display all properties
	public void displayAllProperties() {
		if (properties.isEmpty()) {
			System.out.println("No properties available.");
			return;
		}
		System.out.printf("%-5s %-10s %-10s %-5s %-6s %-10s%n", "ID", "AREA", "BASE", "AGE", "CITY", "TAX");
		for (Property property : properties) {
			property.displayProperty();
		}
	}

	// Calculate total property tax
	public double getTotalPropertyTax() {
		double total = 0.0;
		for (Property property : properties) {
			total += property.getTaxAmount();
		}
		return total;
	}

	// Helper method to find property by ID
	private Property findPropertyById(int id) {
		for (Property property : properties) {
			if (property.getId() == id) {
				return property;
			}
		}
		return null;
	}

	// Get property count
	public int getPropertyCount() {
		return properties.size();
	}
}
