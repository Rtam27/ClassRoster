/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raymondtam
 */

import java.util.Scanner;
import java.lang.Math;

public class RockPaperScissors {
    public static int chooseRounds() {
        try {

            boolean roundConditions = true;
            while (roundConditions == true) {

                Scanner myScanner = new Scanner(System.in);
                System.out
                        .println("Please Choose How Many Rounds of Rock Paper Scissor You Would Like to Play (1-10): ");
                String playerRounds = myScanner.nextLine();
                int round = Integer.parseInt(playerRounds);
                if (round > 0 && round < 11) {
                    return round;
                } else {
                    System.out.println("Please choose a valid number!");
                }
            }
        }

        catch (Exception e) {
            System.out.println("Invalid Input, Please Try Again");
            chooseRounds();
        }

    }

    public static String playerChoice() {
        boolean choosing = true;

        while (choosing == true) {
            try {

                System.out.println("Please choose one of the following:");
                System.out.println("1: Rock");
                System.out.println("2: Paper");
                System.out.println("3: Scissor");

                Scanner newScanner = new Scanner(System.in);
                String playerRPS = newScanner.nextLine();
                int playerRPSchoice = Integer.parseInt(playerRPS);

                switch (playerRPSchoice) {
                case 1:
                    return "Rock";

                case 2:
                    return "Paper";
                case 3:
                    return "Scissor";
                default:
                    System.out.println("Invalid Input, Please Try Again");

                }

            } catch (Exception e) {
                System.out.println("Invalid Input, Please Try Again");

            }
        }

    }

    public static String computerChoice() {
        int max = 3;
        int min = 1;
        int range = max - min + 1;

        int choice = (int) (Math.random() * range) + min;

        switch (choice) {
        case 1:
            return "Rock";
        case 2:
            return "Paper";
        case 3:
            return "Scissor";
        }
    }

    public static void main(String[] args) {
        boolean gameOn = true;
        while (gameOn == true) {
            int rounds = 0;
            int currentRound = 1;
            int tieCounter = 0;
            int winCounter = 0;
            int loseCounter = 0;
            String playerPick = "";
            String computerPick = "";

            rounds = chooseRounds();
            System.out.println(rounds + " " + "rounds");

            while (currentRound <= rounds) {
                System.out.println("Round" + " " + currentRound);

                playerPick = playerChoice();
                System.out.println("Player 1 Chooses" + " " + playerPick);
                computerPick = computerChoice();
                System.out.println("CPU Chooses" + " " + computerPick);

                switch (playerPick) {
                case "Rock":
                    switch (computerPick) {
                    case "Rock":
                        System.out.println("Draw!");
                        tieCounter++;
                        break;
                    case "Paper":
                        System.out.println("Round Lost!");
                        loseCounter++;
                        break;
                    case "Scissor":
                        System.out.println("Round Won!");
                        winCounter++;
                        break;

                    }
                    break;
                case "Paper":
                    switch (computerPick) {
                    case "Paper":
                        System.out.println("Draw!");
                        tieCounter++;
                        break;
                    case "Scissor":
                        System.out.println("Round Lost!");
                        loseCounter++;
                        break;
                    case "Rock":
                        System.out.println("Round Win!");
                        winCounter++;
                        break;

                    }
                    break;
                case "Scissor":
                    switch (computerPick) {
                    case "Scissor":
                        System.out.println("Draw!");
                        tieCounter++;
                        break;
                    case "Rock":
                        System.out.println("Round Lost!");
                        loseCounter++;
                        break;
                    case "Paper":
                        System.out.println("Round Won!");
                        winCounter++;
                        break;

                    }
                    break;
                }

                System.out.println("Current Scores:");
                System.out.println("Wins:" + " " + winCounter);
                System.out.println("Loses:" + " " + loseCounter);
                System.out.println("Ties:" + " " + tieCounter);
                currentRound++;

            }

            if (winCounter > loseCounter) {
                System.out.println("You Win!");
            } else if (loseCounter > winCounter) {
                System.out.println("You Lose!");

            } else {
                System.out.println("Game Draw");
            }

            boolean playAgainCond = true;
            while (playAgainCond == true) {
                System.out.println("Play Again? Type Yes or No");

                Scanner Scan = new Scanner(System.in);
                String playAgain = Scan.nextLine();

                switch (playAgain) {
                case "Yes":
                    gameOn = true;
                    playAgainCond = false;
                    break;
                case "No":
                    gameOn = false;
                    playAgainCond = false;
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Invalid Input");

                }
            }

        }
    }

}
