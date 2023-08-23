import java.util.Scanner;

public class Main {
    private boolean isNormalMode;

    public Main(boolean isNormalMode) {
        this.isNormalMode = isNormalMode;
    }

    public int add(int a, int b) {
        if (isNormalMode) {
            return a + b;
        } else {
            return a - b;
        }
    }

    public int subtract(int a, int b) {
        if (isNormalMode) {
            return a - b;
        } else {
            return a + b;
        }
    }

    public int performOperation(int a, int b, String operation) {
        if ("+".equalsIgnoreCase(operation)) {
            return add(a, b);
        } else if ("-".equalsIgnoreCase(operation)) {
            return subtract(a, b);
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    public int performOperation(int a, int b, int c, String operation) {
        int result = performOperation(a, b, operation);
        return performOperation(result, c, operation);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter calculator mode (normal/opposite): ");
        String modeInput = scanner.nextLine();
        boolean isNormalMode = modeInput.equalsIgnoreCase("normal");

        Main calculator = new Main(isNormalMode);

        System.out.print("Enter operation (+/-): ");
        String operation = scanner.nextLine();

        System.out.print("Enter numbers: \n");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int result;
        if (scanner.hasNextInt()) {
            int num3 = scanner.nextInt();
            result = calculator.performOperation(num1, num2, num3, operation);
        }
        else
        {
            result = calculator.performOperation(num1, num2, operation);
        }
        System.out.println("Result: " + result);

        scanner.close();
    }
}
