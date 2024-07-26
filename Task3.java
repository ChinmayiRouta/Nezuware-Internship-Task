import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");

        while (true) {
            System.out.print("Enter temperature value (or 'q' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            double temperature = 0;
            try {
                temperature = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            System.out.println("Select source scale:");
            System.out.println("1: Celsius (C)");
            System.out.println("2: Fahrenheit (F)");
            System.out.println("3: Kelvin (K)");

            String sourceScale = scanner.nextLine();
            if (!isValidScale(sourceScale)) {
                System.out.println("Invalid scale. Please select a valid source scale.");
                continue;
            }

            System.out.println("Select target scale:");
            System.out.println("1: Celsius (C)");
            System.out.println("2: Fahrenheit (F)");
            System.out.println("3: Kelvin (K)");

            String targetScale = scanner.nextLine();
            if (!isValidScale(targetScale)) {
                System.out.println("Invalid scale. Please select a valid target scale.");
                continue;
            }

            double convertedTemperature = convertTemperature(temperature, sourceScale, targetScale);
            String sourceScaleName = getScaleName(sourceScale);
            String targetScaleName = getScaleName(targetScale);

            System.out.println("Converted Temperature: " + convertedTemperature + " " + targetScaleName);
        }

        scanner.close();
        System.out.println("Temperature Converter has been closed.");
    }

    private static boolean isValidScale(String scale) {
        return scale.equals("1") || scale.equals("2") || scale.equals("3");
    }

    private static String getScaleName(String scale) {
        switch (scale) {
            case "1":
                return "Celsius (C)";
            case "2":
                return "Fahrenheit (F)";
            case "3":
                return "Kelvin (K)";
            default:
                return "";
        }
    }

    private static double convertTemperature(double temperature, String sourceScale, String targetScale) {
        if (sourceScale.equals(targetScale)) {
            return temperature;
        }

        // Convert source to Celsius
        double tempInCelsius;
        switch (sourceScale) {
            case "1": // Celsius
                tempInCelsius = temperature;
                break;
            case "2": // Fahrenheit
                tempInCelsius = (temperature - 32) * 5 / 9;
                break;
            case "3": // Kelvin
                tempInCelsius = temperature - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Invalid source scale");
        }

        // Convert Celsius to target
        switch (targetScale) {
            case "1": // Celsius
                return tempInCelsius;
            case "2": // Fahrenheit
                return (tempInCelsius * 9 / 5) + 32;
            case "3": // Kelvin
                return tempInCelsius + 273.15;
            default:
                throw new IllegalArgumentException("Invalid target scale");
        }
    }
}
