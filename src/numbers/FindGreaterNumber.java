package numbers;

import java.util.Random;

public class FindGreaterNumber {
	
    static int x1; // Variable to store the result of thread 1
    static int x2; // Variable to store the result of thread 2

    public static void main(String[] args) {
    	// Create a vector with 1000 random numbers
        int[] vector = generateVector(1000000);
        
        // Create instances of threads
        Thread thread1 = new Thread(() -> {
            x1 = findMaximum(0, vector.length / 2, vector);
        });

        Thread thread2 = new Thread(() -> {
            x2 = findMaximum(vector.length / 2, vector.length, vector);
        });

        // Get the start time
        long startTime = System.currentTimeMillis();

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the end time
        long endTime = System.currentTimeMillis();

        // Compare the results
        int finalResult = Math.max(x1, x2);

        // Display results
        System.out.println("The largest number is: " + finalResult);
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

    // Method to find the maximum number in a specific part of the vector
    static int findMaximum(int start, int end, int[] vector) {
        int maximum = vector[start];
        for (int i = start + 1; i < end; i++) {
            if (vector[i] > maximum) {
                maximum = vector[i];
            }
        }
        return maximum;
    }
}