/*
* Group #5
* Authors: Jordan Wriker Ahmed Rizvi
* Assignment: Java Lab 1
* Date: November 12, 2020
* Purpose: Take three bowlers scores for two games and then display
*          the information to the console.
*
*/


package ca.durhmacollege;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        // Define arrays

        String[] names = {"Jordan", "Ahmed", "Thom"};
        int[][] scores = new int[3][2];

        // Define our scanner

        Scanner keyboard = new Scanner(System.in);

        // Define score variable

        int score;
        float average = 0.0f;

        // Input

        // Outer loop for number of games
        for (int s = 0; s <= 1; s++)
        {
            // Inner loop for number of bowlers
            for (int b = 0; b <= 2; b++)
            {
                // Display message to enter score for current bowler for current game
                System.out.print("Please enter " + names[b] + "'s score for GAME #" + (s + 1) + ": ");

                boolean isValidInput = false;

                // Loops until the input has been validated
                while(!isValidInput)
                {
                    try
                    {
                        // Accept input from user
                        score = keyboard.nextInt();
                        // Will remain true unless error occurs in validation
                        isValidInput = true;

                        // Entered score was not within bounds
                        if((score < 0 ) || (score > 300))
                        {
                            // Display the validation error to the user
                            System.out.println("Invalid input. Value between 0 and 300 needed. Please try again.");
                            System.out.print("Please enter " + names[b] + "'s score for GAME #" + (s + 1) + ": ");
                            keyboard.nextLine();
                            isValidInput = false;
                        }
                        // Validation succeeded
                        scores[b][s] = score;
                    }
                    // A whole number was not inputted
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input. Whole number needed. Please try again.");
                        System.out.print("Please enter " + names[b] + "'s score for GAME #" + (s + 1) + ": ");
                        keyboard.nextLine();
                        isValidInput = false;
                    }
                }
            }
            System.out.println();
        }

        // Outputting contents in the score array

        // Outer loop for number of bowlers
        for (int b = 0; b <= 2; b++)
        {
            System.out.println("Score details for " + names[b] + ":");
            // Inner loop for number of games
            for (int s = 0; s <= 1; s++)
            {
                System.out.println("Game #" + (s + 1) + ":    " + String.format("%6s" , scores[b][s]));
                // Holds the sum of scores of current bowler
                average += scores[b][s];
            }

            // Calculate the average of scores for the current bowler
            average = average / 2;
            System.out.printf("Average for " + names[b] + ": %.1f", average);
            System.out.println();
            System.out.println();
            average = 0.0f;
        }
    }
}
