package main.java.q1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[] input = promptForInts();
        double[] calcString = calcInts(input);
        printCalc(calcString);
    }

    private static int[] promptForInts() {
        int[] input = new int[2];
        input[0] = promptForInt("Enter an integer: ");
        input[1] = promptForInt("Enter another integer: ");
        return input;
    }

    private static int promptForInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That is not an integer");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static double[] calcInts(int[] input) {
        int sum = input[0] + input[1];
        int difference = input[0] - input[1];
        int product = input[0] * input[1];
        double average = (double) sum / 2;
        int distance = Math.abs(difference);
        int min = Math.min(input[0], input[1]);
        int max = Math.max(input[0], input[1]);

        return new double[]{sum, difference, product, average, distance, min, max};
    }

    private static void printCalc(double[] analysis) {
        String format = "%-18s %8.2f%n";
        System.out.printf(format, "Sum:", analysis[0]);
        System.out.printf(format, "Difference:", analysis[1]);
        System.out.printf(format, "Product:", analysis[2]);
        System.out.printf(format, "Average:", analysis[3]);
        System.out.printf(format, "Distance:", analysis[4]);
        System.out.printf(format, "Min:", analysis[5]);
        System.out.printf(format, "Max:", analysis[6]);
    }
}