package org.christophercapps.blurredleclient.model;

import java.util.List;

public class GuessColumn {
    List<Character> possibleLetters;

    public List<Character> getPossibleLetters() {
        return possibleLetters;
    }

    public void setPossibleLetters(List<Character> possibleLetters) {
        this.possibleLetters = possibleLetters;
    }
}
