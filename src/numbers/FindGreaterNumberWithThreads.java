package numbers;

import java.util.Random;

public class FindGreaterNumberWithThreads {

    public static void main(String[] args) {
        // Create a vector with 1000 random numbers
        int[] vector = generateVector(1000000);

        // Get the start time
        long startTime = System.currentTimeMillis();

        // Find the largest number
        int greaterNumber = findGreaterNumber(vector);

        // Get the end time
        long endTime = System.currentTimeMillis();

        // Display results
        System.out.println("The largest number is: " + greaterNumber);
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
    }

    // Method to generate a vector with random numbers
    static int[] generateVector(int size) {
        int[] vector = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            vector[i] = random.nextInt(size); // Range of random numbers (0 to 999)
        }

        return vector;
    }

    // Method to find the maximum number in a vector
    static int findGreaterNumber(int[] vector) {
        int max = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > max) {
                max = vector[i];
            }
        }
        return max;
    }
}