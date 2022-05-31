package com.company.BlackJack.util;

import com.company.BlackJack.decks.Deck;
import com.company.BlackJack.decks.Figure;

public class ScoringUtils {
    private ScoringUtils(){
        // utility class
    }

    public static boolean isCardsSumExceeded(Deck deck) {
        int sum = 0;
        for (Figure figure : deck.getCardDeck().getFigures()) {
            sum += Figure.getStrength(figure);
        }
        return sum > 21;
    }
}
