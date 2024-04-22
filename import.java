import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result = 0;
        char operator;

        try {
            System.out.println("Enter the first number: ");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
            } else {
                throw new IllegalArgumentException("Invalid input for the first number!");
            }

            System.out.println("Enter the operator (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            System.out.println("Enter the second number: ");
            if (scanner.hasNextDouble()) {
                num2 = scanner.nextDouble();
            } else {
                throw new IllegalArgumentException("Invalid input for the second number!");
            }

            if (num1 < 0 || num2 < 0) {
                throw new IllegalArgumentException("Negative numbers are not supported");
            }

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        throw new ArithmeticException("Division by zero");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator!");
            }

            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
