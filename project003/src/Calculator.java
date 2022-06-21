import java.util.Scanner;

public class  Calculator {
     private static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }


    private static int getNumber(String message) {
        try {
            System.out.print(message + " : ");
            return scan.nextInt();
        } catch (Exception ex) {
            scan.nextLine();
            throw new IllegalArgumentException(ex);
        }
    }

    private static void calculate(int firstNumber, int secondNumber) {
        System.out.println("which  option  You want */-+ [1 to 4 ]? and 5 for Exit  ");
        String option = scan.next();
        String operand = "";
        long result = 0;
        switch (option) {
            case "1":
            case "mul":
            case "*":
                operand = "*";
                result = mul(firstNumber, secondNumber);
                break;
            case "2":
            case "div":
                operand = "/";
                result = div(firstNumber, secondNumber);
                break;
            case "3":
            case "minus":
                operand = "-";
                result = sub(firstNumber, secondNumber);
                break;
            case "4":
            case "sum":
            case "add":
                operand = "+";
                result = sum(firstNumber, secondNumber);
                break;
            case "5":
            case "exit":
            case "quit":
                System.out.println("good bye");
                System.exit(0);
                break;
            default:
                System.out.println("invalid operation.Please try again");
                startProgram();
                break;
        }
        System.out.printf("%d %s %d = %d\n", firstNumber, operand, secondNumber, result);

    }

    private static int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private static int sub(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    private static int mul(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    private static int div(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }


    private static void startProgram() {
        try {
            int firstNumber = getNumber("Enter the firstNumber");
            int secondNumber = getNumber("Enter the secondNumber");
            calculate(firstNumber, secondNumber);
        } catch (Exception ex) {
            System.out.println("Error ====> " + ex.getMessage());
        }
        startProgram();
    }

    public static void main(String[] args) {
        startProgram();
    }
}