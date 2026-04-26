import java.util.Scanner;

public class Main {

    // Main method: handles user input, menu selection, and program flow
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Java Calculator ===");
        System.out.println("Supported operations: +, -, *, /, gcd, digit sum");

        while (running) {
            System.out.println("Please enter the operation you would like (+, -, *, /, gcd, digit sum).");
            String menu = scanner.nextLine();

            if (isValidOperation(menu) == false) {
                System.out.println("Invalid input!");
                continue;
            }

            if (menu.equals("digit sum")) {
                System.out.println("Please enter the number to calculate its digit sum.");
                int number = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Result: " + digitSum(number));
            } else {
                System.out.println("Please enter the first number");
                double firstNumber = scanner.nextDouble();
                System.out.println("Please enter the second number");
                double secondNumber = scanner.nextDouble();
                scanner.nextLine();

                switch (menu) {
                    case "+":
                        System.out.println("Result: " + add(firstNumber, secondNumber));
                        break;
                    case "-":
                        System.out.println("Result: " + subtract(firstNumber, secondNumber));
                        break;
                    case "*":
                        System.out.println("Result: " + multiply(firstNumber, secondNumber));
                        break;
                    case "/":
                        System.out.println("Result: " + divide(firstNumber, secondNumber));
                        break;
                    case "gcd":
                        System.out.println("Result: " + gcd(firstNumber, secondNumber));
                        break;
                }
            }

            System.out.println("Would you like to continue calculating? (yes/no)");
            String answer = scanner.nextLine();
            if (answer.equals("yes")) {
                continue;
            } else if (answer.equals("no")){
                System.out.println("Goodbye!");
                break;
            }else{
                System.out.println("Invalid input!");
                break;
            }
        }
    }

    // Validates if the user input is a supported operation
    public static boolean isValidOperation(String menu) {
        return switch (menu) {
            case "+", "-", "*", "/", "gcd", "digit sum" -> true;
            default -> false;
        };
    }

    // Returns the sum of two numbers
    public static double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    // Returns the difference of two numbers
    public static double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    // Returns the product of two numbers
    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    // Divides two numbers, returns 0.0 if divisor is zero
    public static double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            System.out.println("Division by zero is not allowed!");
            return 0.0;
        } else {
            return firstNumber / secondNumber;
        }
    }

    // Calculates the greatest common divisor using the Euclidean algorithm
    public static int gcd(double firstNumber, double secondNumber) {
        int a = (int) firstNumber;
        int b = (int) secondNumber;
        int rest = 0;

        while (b != 0) {
            rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }

    // Calculates the digit sum of a given integer
    public static int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
}
