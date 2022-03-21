package org.christophercapps.blurredleclient.model;

import java.util.List;

public class GuessTracker {

    boolean isCorrect;
    String guess;
    List<GuessColumn> columns;
    List<String> guessHistory;

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public List<GuessColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<GuessColumn> columns) {
        this.columns = columns;
    }

    public List<String> getGuessHistory() {
        return guessHistory;
    }

    public void setGuessHistory(List<String> guessHistory) {
        this.guessHistory = guessHistory;
    }

    public int wordSize() {
        return columns.size();
    }

    @Override
    public String toString() {
        String output = rowsToString();
        for (int i = 0; i < columns.size(); i++) {
            output += "? ";
        }
        if (guessHistory != null && guessHistory.size() > 0) {
            output += "\n \n Most recent guess: \n" + guessHistory.get(guessHistory.size()-1);
        }

        return output;
    }

    private String guessToString(String guess) {
        String guessString = "";

        for (int i = 0; i < guess.length(); i++) {
            guessString += Character.toUpperCase(guess.charAt(i)) + " ";
        }

        return guessString;
    }

    private String rowsToString() {
        String output = "";

        for (int i = 3; i > 0; i--) {
            for (GuessColumn column : columns) {
                if (column.getPossibleLetters().size() >= i) {
                    output += Character.toUpperCase(column.getPossibleLetters().get(i - 1)) + " ";
                } else {
                    output += "  ";
                }
            }
            output += "\n";
        }

        return output;
    }
}
