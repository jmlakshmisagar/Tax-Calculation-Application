package tax.calculation.service;

import tax.calculation.model.Property;
import tax.calculation.util.ConsoleTable;

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

		ConsoleTable table = new ConsoleTable("ID", "AREA", "BASE", "AGE", "CITY", "TAX");

		for (Property p : properties) {
			table.addRow(p.toTableRow());
		}

		table.printTable();
	}

	public double getTotalPropertyTax() {
		return properties.stream().mapToDouble(Property::getTaxAmount).sum();
	}

	public int getPropertyCount() {
		return properties.size();
	}

	// ⬇️ THIS METHOD MUST EXIST — OTHERWISE your error occurs
	private Property findPropertyById(int id) {
		return properties.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}
}
