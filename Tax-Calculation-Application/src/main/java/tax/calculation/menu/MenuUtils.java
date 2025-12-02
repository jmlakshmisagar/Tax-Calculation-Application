package tax.calculation.menu;

import tax.calculation.service.PropertyService;
import tax.calculation.service.VehicleService;
import tax.calculation.util.ConsoleTable;

public class MenuUtils {

	public static void showTotal(PropertyService propertyService, VehicleService vehicleService) {

		ConsoleTable table = new ConsoleTable("PARTICULAR", "COUNT", "TOTAL TAX");

		table.addRow("PROPERTIES", String.valueOf(propertyService.getPropertyCount()),
				String.format("%.2f", propertyService.getTotalPropertyTax()));

		table.addRow("VEHICLES", String.valueOf(vehicleService.getVehicleCount()),
				String.format("%.2f", vehicleService.getTotalVehicleTax()));

		double grandTotal = propertyService.getTotalPropertyTax() + vehicleService.getTotalVehicleTax();

		table.addRow("GRAND TOTAL", "-", String.format("%.2f", grandTotal));

		System.out.println("\nTOTAL TAX SUMMARY");
		table.printTable();
	}
}
	