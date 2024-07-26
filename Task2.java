import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Java Calculator!");

        while (true) {
            System.out.print("Enter first number (or 'q' to quit): ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Enter second number (or 'q' to quit): ");
            String input2 = scanner.nextLine();
            if (input2.equalsIgnoreCase("q")) {
                break;
            }

            double num1 = 0;
            double num2 = 0;

            try {
                num1 = Double.parseDouble(input1);
                num2 = Double.parseDouble(input2);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
                continue;
            }

            System.out.println("Select an operation:");
            System.out.println("1: Addition (+)");
            System.out.println("2: Subtraction (-)");
            System.out.println("3: Multiplication (*)");
            System.out.println("4: Division (/)");

            String operation = scanner.nextLine();
            double result = 0;
            boolean validOperation = true;

            switch (operation) {
                case "1":
                case "+":
                    result = num1 + num2;
                    break;
                case "2":
                case "-":
                    result = num1 - num2;
                    break;
                case "3":
                case "*":
                    result = num1 * num2;
                    break;
                case "4":
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Invalid operation. Please select a valid operation.");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }
        }

        scanner.close();
        System.out.println("Calculator has been closed.");
    }
}
