import java.util.*;

class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to Office Calculator!");

            // Repeat until valid input is received for the first number
            double num1;
            do {
                System.out.println("Please enter the first number:");
                num1 = getValidNumber(scanner);
            } while (Double.isNaN(num1)); // Repeat if input is not a valid number

            // Repeat until valid input is received for the operator
            char operator;
            do {
                System.out.println("Please enter the operator (+, -, *, /):");
                operator = getValidOperator(scanner);
            } while (operator == '\0'); // Repeat if input is not a valid operator

            // Repeat until valid input is received for the second number
            double num2;
            do {
                System.out.println("Please enter the second number:");
                num2 = getValidNumber(scanner);
            } while (Double.isNaN(num2)); // Repeat if input is not a valid number

            double result = calculate(num1, operator, num2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Method to get a valid number input from the user
    public static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                double num = scanner.nextDouble();
                return num;
            } catch (InputMismatchException e) {
                // Clear the invalid input
                scanner.next();
                System.out.println("Invalid input format. Please enter a valid number.");
            }
        }
    }

    // Method to get a valid operator input from the user
    public static char getValidOperator(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid operator. Please enter +, -, *, or /.");
            }
        }
    }

    // Method to perform calculation based on the operator
    public static double calculate(double num1, char operator, double num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is notw allowed");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
