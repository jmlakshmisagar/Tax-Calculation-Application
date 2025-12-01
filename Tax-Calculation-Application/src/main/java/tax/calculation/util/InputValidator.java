
package tax.calculation.util;

public class InputValidator {

    // Validate positive double
    public static boolean isPositiveDouble(double value) {
        return value > 0;
    }

    // Validate positive integer
    public static boolean isPositiveInt(int value) {
        return value > 0;
    }

    // Validate city input (Y/N)
    public static boolean isValidCityInput(String input) {
        return input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N");
    }

    // Validate registration number (4-digit, non-zero)
    public static boolean isValidRegistrationNumber(String regNo) {
        if (regNo.length() == 4 && regNo.matches("\\d{4}")) {
            return !regNo.equals("0000");
        }
        return false;
    }

    // Validate purchase cost (between 50,000 and 10,00,000)
    public static boolean isValidPurchaseCost(double cost) {
        return cost >= 50000 && cost <= 1000000;
    }

    // Validate velocity (between 120 and 300 kmph)
    public static boolean isValidVelocity(double velocity) {
        return velocity >= 120 && velocity <= 300;
    }

    // Validate capacity (between 2 and 50 seats)
    public static boolean isValidCapacity(int capacity) {
        return capacity >= 2 && capacity <= 50;
    }

    // Validate vehicle type (1, 2, or 3)
    public static boolean isValidVehicleType(int type) {
        return type >= 1 && type <= 3;
    }
}
