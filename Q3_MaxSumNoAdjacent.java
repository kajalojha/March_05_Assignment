package March_05_Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3_MaxSumNoAdjacent {
    public int maxSumNoAdjacent(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        if (cols == 1)
        { // If there is only one column

            return Math.max(array[0][0], array[1][0]); // Return the maximum value among the two elements
        }

        // Create a dynamic programming table to store intermediate results
        int[][] dp = new int[rows][cols];

        // Initialize the first row of dp table
        for (int j = 0; j < cols; j++)
        { // Iterate through each column in the first row
            dp[0][j] = array[0][j]; // Initialize dp table with values from the first row of the grid
        }

        // Populate the dp table
        for (int i = 1; i < rows; i++) { // Iterate through each row starting from the second row
            for (int j = 0; j < cols; j++) { // Iterate through each column
                // For each cell, we have two options:
                // 1. Choose the number at this cell and skip the adjacent cells.
                // 2. Skip this number and take the maximum sum from the previous row.
                int maxSum = 0;
                if (j > 0) // If not the first column
                    maxSum = Math.max(maxSum, dp[i - 1][j - 1]); // Take the maximum sum from the left diagonal cell
                if (j < cols - 1) // If not the last column
                    maxSum = Math.max(maxSum, dp[i - 1][j + 1]); // Take the maximum sum from the right diagonal cell
                dp[i][j] = maxSum + array[i][j]; // Add the current element to the maximum sum and store it in dp table
            }
        }

        // Find the maximum sum from the last row of the dp table
        int maxSum = Integer.MIN_VALUE; // Initialize maximum sum to the minimum possible value
        for (int j = 0; j < cols; j++) { // Iterate through each column in the last row
            maxSum = Math.max(maxSum, dp[rows - 1][j]); // Update maximum sum with the maximum value from the last row
        }
        return maxSum; // Return the maximum sum
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner to read user input

        // Input the number of columns (N)
        System.out.println("Enter the number of columns (N):");
        int cols = scanner.nextInt(); // Read the number of columns from the user

        // Input the 2 x N grid
        int[][] array = new int[2][cols]; // Create a 2D array to store the grid
        System.out.println("Enter the elements of the grid:");
        for (int i = 0; i < 2; i++) { // Iterate through each row
            for (int j = 0; j < cols; j++) { // Iterate through each column
                array[i][j] = scanner.nextInt(); // Read the element from the user input
            }
        }

        // Create an instance of the class to access non-static method
        Q3_MaxSumNoAdjacent solution = new Q3_MaxSumNoAdjacent();

        // Find and print the maximum sum of non-adjacent elements
        int maxSum = solution.maxSumNoAdjacent(array); // Calculate the maximum sum
        System.out.println("Maximum sum of non-adjacent elements: " + maxSum); // Print the result

    }
}



