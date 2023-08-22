import java.util.Scanner;

public class Main {

    private String mode;

    public Main(String mode) {
        this.mode = mode;
    }

    public int add(int... numbers) {
        if (mode.equals("Normal")) {
            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }
            return sum;
        } else if (mode.equals("Opposite")) {
            int result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result -= numbers[i];
            }
            return result;
        } else {
            throw new IllegalArgumentException("Invalid mode. Use 'Normal' or 'Opposite'.");
        }
    }

    public int subtract(int... numbers) {
        if (mode.equals("Normal")) {
            int result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result -= numbers[i];
            }
            return result;
        } else if (mode.equals("Opposite")) {
            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }
            return sum;
        } else {
            throw new IllegalArgumentException("Invalid mode. Use 'Normal' or 'Opposite'.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter mode (Normal/Opposite): ");
        String mode = scanner.nextLine();
        Main calculator = new Main(mode);

        System.out.print("Enter numbers (separated by spaces): ");
        String[] numStrings = scanner.nextLine().split(" ");
        int[] numbers = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            numbers[i] = Integer.parseInt(numStrings[i]);
        }

        int resultAdd = calculator.add(numbers);
        int resultSubtract = calculator.subtract(numbers);

        System.out.println("\n" + mode + " Mode:");
        System.out.println("Addition: " + resultAdd);
        System.out.println("Subtraction: " + resultSubtract);

        scanner.close();
    }
}
