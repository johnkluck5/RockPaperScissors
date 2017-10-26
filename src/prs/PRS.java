package prs;
//John Kluck
//CSCI 1010/1011
//The game of rock, paper, scissors

import java.util.*;

public class PRS {
    //*********************************METHODS*********************

    //method to display instructions
    public static void instructions() {
        System.out.println("This is the popular game of paper, rock, scissors. Enter your\n"
                + "choice by typing the word \"paper\", the word \"rock\" or the word\n"
                + "\"scissors\". The computer will also make a choice from the three\n"
                + "options. After you have entered your choice, the winner of the\n"
                + "game will be determined according to the following rules:\n"
                + "\n"
                + "Paper wraps rock (paper wins)\n"
                + "Rock breaks scissors (rock wins)\n"
                + "Scissors cuts paper (scissors wins)\n"
                + "\n"
                + "If both you and the computer enter the same choice, then the game is tied.\n");
    }

    //method to compare input and find the winner
    public static int analyzeRound(String playerInput, String compInput) {
        //check to see if player wins
        if (playerInput.equals("rock") && compInput.equals("scissors")
                || (playerInput.equals("paper") && compInput.equals("rock"))
                || (playerInput.equals("scissors") && compInput.equals("paper"))) {

            return 1;
            //check to see if the computer wins
        } else if (playerInput.equals("rock") && compInput.equals("paper")
                || playerInput.equals("paper") && compInput.equals("scissors")
                || playerInput.equals("scissors") && compInput.equals("rock")) {
            return 2;
        }

        //return 3 for a tie
        return 3;
    }

    // method to generate a computer choice
    public static String computerChoose() {

        String[] answer = new String[3];
        answer[0] = "paper";
        answer[1] = "rock";
        answer[2] = "scissors";
        return answer[generator.nextInt(3)];
    }

    public static Random generator;

    //********************************METHODS END********************
    public static void main(String[] args) {
        //initialize variables
        String input, playerChoice, compChoice;
        boolean gameLoop = true;
        int result, wins = 0, losses = 0, ties = 0, played = 0;

        generator = args.length == 0 ? new Random() : new Random(Integer.parseInt(args[0]));

        Scanner kbd = new Scanner(System.in);

        System.out.println("The Game of Paper, Rock, Scissors\n");

        //check if the users wants instructions
        System.out.println("Do you need instructions (Y or N)? ");
        input = kbd.next();
        input = input.toLowerCase();
        if (input.equals("y")) {
            instructions();
        }

        //start the game loop
        while (gameLoop) {
            System.out.println("Enter your choice: ");
            //get player choice
            playerChoice = kbd.next();
            //generate computer choice
            compChoice = computerChoose();
            
            //convert player input to lower case
            playerChoice = playerChoice.toLowerCase();
            
            System.out.println("   You entered: " + playerChoice + "\nComputer chose: " + compChoice + "\n");
            //call the result method to find the winner
            result = analyzeRound(playerChoice, compChoice);

            switch (result) {
                //player wins
                case 1:
                    System.out.println("YOU WIN!\n");
                    wins++;
                    played++;
                    break;
                //computer wins
                case 2:
                    System.out.println("I WIN!\n");
                    losses++;
                    played++;
                    break;
                //the game is a tie
                default:
                    System.out.println("IT'S A TIE!\n");
                    ties++;
                    played++;
                    break;
            }

            //check if the user wants to play again
            System.out.print("Play again (Y or N)? \n");
            input = kbd.next();
            input = input.toLowerCase();

            //if the user does not want to play again, display stats 
            if (input.equals("n")) {
                System.out.println("Games played:  " + played + "\nWins for you:  "
                        + wins + "\nWins for me:   " + losses + "\nTied games:    "
                        + ties);
                gameLoop = false;
            }
        }

    }

}

