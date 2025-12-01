package tax.calculation.util;

public class InputValidator {
	public static boolean isPositiveDouble(double value) {
		return value > 0;
	}

	public static boolean isPositiveInt(int value) {
		return value > 0;
	}

	public static boolean isValidCityInput(String input) {
		return input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N");
	}

	public static boolean isValidRegistrationNumber(String regNo) {
		return regNo.length() == 4 && regNo.matches("\\d{4}") && !regNo.equals("0000");
	}

	public static boolean isValidPurchaseCost(double cost) {
		return cost >= 50000 && cost <= 1000000;
	}

	public static boolean isValidVelocity(double velocity) {
		return velocity >= 120 && velocity <= 300;
	}

	public static boolean isValidCapacity(int capacity) {
		return capacity >= 2 && capacity <= 50;
	}

	public static boolean isValidVehicleType(int type) {
		return type >= 1 && type <= 3;
	}
}
