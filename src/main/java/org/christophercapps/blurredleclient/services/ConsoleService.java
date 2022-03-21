package org.christophercapps.blurredleclient.services;

import org.christophercapps.blurredleclient.model.GuessTracker;

import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);
    private final GuessTrackerService guessTrackerService = new GuessTrackerService();

    public void printHeader() {
        System.out.println  ("***********************\n" +
                             "*   B L U R R D L E   *\n" +
                             "*                     *\n" +
                             "*  A HIGH-DIFFICULTY  *\n" +
                             "*   WORDLE  VARIANT   *\n" +
                             "*                     *\n" +
                             "***********************");
    }

    public void printWinBanner(GuessTracker tracker) {




        System.out.println  ("***********************\n" +
                             "*  CONGRATULATIONS!!  *\n" +
                             "*                     *\n" +
                            buildWinningAnswerLine(tracker) +
                             "*                     *\n" +
                             "*     IS CORRECT!     *\n" +
                             "***********************\n" +
                                                    "\n" +
                             "It only took you " + tracker.getGuessHistory().size() + " guesses!");
    }

    public String buildWinningAnswerLine(GuessTracker tracker) {
        String correctAnswer = "*";
        int sideSpace = tracker.wordSize() /2;
        boolean isEven = (tracker.wordSize() % 2 == 0);

        for (int i = 0; i < 10 - sideSpace; i++) {
            correctAnswer += " ";
        }

        correctAnswer += tracker.getGuess();

        for (int i = 0; i < 10 - sideSpace; i++) {
            correctAnswer += " ";
        }

        if (isEven) {
            correctAnswer += " ";
        }

        correctAnswer += "*\n";
        return correctAnswer;
    }
    public void printNewGameInfo(GuessTracker tracker) {
        System.out.println("Today's word is " + tracker.wordSize() + " letters long.");
        System.out.println();
        String qMarks = "";
        for (int i = 0; i < tracker.wordSize(); i++) {
            qMarks += "? ";
        }
        System.out.println(qMarks);
        System.out.println();
    }

    public String promptForGuess(String prompt, GuessTracker tracker) {

        String newGuess = null;

        while (newGuess == null || !isOnlyLetters(newGuess) || newGuess.length() != tracker.wordSize()) {
            System.out.println(prompt);

            newGuess = scanner.nextLine().toUpperCase();

            if (!isOnlyLetters(newGuess) || newGuess.length() != tracker.wordSize()) {
                System.out.println("Guess must consist of exactly " + tracker.wordSize() + " letters.");
            }
        }

        return newGuess;

    }

    private boolean isOnlyLetters(String word) {
        char[] chars = word.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
