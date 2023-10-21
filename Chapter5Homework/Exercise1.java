package Chapter5Homework;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a list of numbers separated by commas: ");
        String input = scanner.nextLine();
        scanner.close();

        String[] numbersStr = input.split(",");
        int[] numbers = new int[numbersStr.length];

        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        int sum = 0;
        int lowest = numbers[0];
        int highest = numbers[0];

        for (int number : numbers) {
            sum += number;
            if (number < lowest) {
                lowest = number;
            }
            if (number > highest) {
                highest = number;
            }
        }

        double average = (double) sum / numbers.length;

        try {
            FileWriter writer = new FileWriter("stats.txt");
            writer.write("The sum of the numbers is: " + sum + "\n");
            writer.write("The lowest number is: " + lowest + "\n");
            writer.write("The highest number is: " + highest + "\n");
            writer.write("The average of the numbers is: " + average + "\n");
            writer.close();
            System.out.println("Results have been written to 'stats.txt'.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

