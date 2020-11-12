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

        for (int s = 0; s <= 1; s++)
        {
            for (int b = 0; b <= 2; b++)
            {
                System.out.print("Please enter " + names[b] + "'s score for GAME #" + (s + 1) + ": ");

                boolean isValidInput = false;

                while(!isValidInput)
                {
                    try
                    {
                        score = keyboard.nextInt();
                        isValidInput = true;

                        if((score < 0 ) || (score > 300))
                        {
                            System.out.println("Invalid input. Value between 0 and 300 needed. Please try again.");
                            System.out.print("Please enter " + names[b] + "'s score for GAME #" + (s + 1) + ": ");
                            keyboard.nextLine();
                            isValidInput = false;
                        }

                        scores[b][s] = score;
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input. Whole number needed. Please try again.");
                        System.out.print("Please enter " + names[b] + "'s score for GAME #" + (s + 1) + ": ");
                        keyboard.nextLine();
                        isValidInput = false;
                    }
                }
            }
            System.out.println("");
        }

        // Output

        for (int b = 0; b <= 2; b++)
        {
            System.out.println("Score details for " + names[b] + ":");

            for (int s = 0; s <= 1; s++)
            {
                System.out.println("Game #" + (s + 1) + ":    " + scores[b][s]);
                average += scores[b][s];
            }

            average = average / 2;
            System.out.printf("Average for " + names[b] + ": %1f", average);
            System.out.println("");
            average = 0.0f;
        }
    }
}
