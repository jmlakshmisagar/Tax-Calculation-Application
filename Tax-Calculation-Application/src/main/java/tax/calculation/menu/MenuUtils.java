
package tax.calculation.menu;

import tax.calculation.service.PropertyService;
import tax.calculation.service.VehicleService;

public class MenuUtils {
    public static void showTotal(PropertyService propertyService, VehicleService vehicleService) {
        System.out.println("\nTOTAL TAX SUMMARY");
        System.out.printf("%-15s %-10s %-10s%n", "PARTICULAR", "COUNT", "TOTAL TAX");
        System.out.printf("%-15s %-10d %-10.2f%n", "PROPERTIES", propertyService.getPropertyCount(), propertyService.getTotalPropertyTax());
        System.out.printf("%-15s %-10d %-10.2f%n", "VEHICLES", vehicleService.getVehicleCount(), vehicleService.getTotalVehicleTax());
        double grandTotal = propertyService.getTotalPropertyTax() + vehicleService.getTotalVehicleTax();
        System.out.printf("%-15s %-10s %-10.2f%n", "GRAND TOTAL", "-", grandTotal);
    }
}
