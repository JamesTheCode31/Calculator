import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner ac = new Scanner(System.in);

        // User input for the operation
        System.out.print("Choose operation \n1:Addition \n2:Subtraction \n3:Multiplication \n4:Division \n");
        int operationChoice = ac.nextInt();

        // User input for number systems
        double number1 = getInputNumber(ac, "first");
        double number2 = getInputNumber(ac, "second");

        // Perform the selected operation
        double result = 0;
        switch (operationChoice) {
            case 1:
                result = number1 + number2;
                printResult("Addition", result);
                break;
            case 2:
                result = number1 - number2;
                printResult("Subtraction", result);
                break;
            case 3:
                result = number1 * number2;
                printResult("Multiplication", result);
                break;
            case 4:
                if (number2 != 0) {
                    result = number1 / number2;
                    printResult("Division", result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operation choice.");
        }

        ac.close();
    }

    // Method to get input number based on chosen number system
    private static double getInputNumber(Scanner ac, String order) {
        System.out.print("\nEnter " + order + " number system \n1:Binary \n2:Decimal \n3:Octal \n4:Hexadecimal \n");
        int numberSystem = ac.nextInt();

        System.out.print("\nEnter " + order + " number: ");
        String inputNumber = ac.next();

        switch (numberSystem) {
            case 1: // Binary
                return Integer.parseInt(inputNumber, 2);
            case 2: // Decimal
                return Double.parseDouble(inputNumber);
            case 3: // Octal
                return Integer.parseInt(inputNumber, 8);
            case 4: // Hexadecimal
                return Integer.parseInt(inputNumber, 16);
            default:
                System.out.println("Invalid number system choice. Defaulting to decimal.");
                return Double.parseDouble(inputNumber);
        }
    }

    // Method to print results in different number systems
    private static void printResult(String operation, double result) {
        int intResult = (int) result;

        System.out.println(operation + " Result:");
        System.out.println("Decimal: " + result);
        System.out.println("Binary: " + Integer.toBinaryString(intResult));
        System.out.println("Octal: " + Integer.toOctalString(intResult));
        System.out.println("Hexadecimal: " + Integer.toHexString(intResult).toUpperCase());
        System.out.println(); // For better formatting
    }
}

