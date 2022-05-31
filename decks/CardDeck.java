package com.company.BlackJack.decks;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private final List<Color> colors = new ArrayList<>(5);
    private final List<Figure> cards = new ArrayList<>(5);

    public List<Color> getColors() {
        return colors;
    }

    public List<Figure> getFigures() {
        return cards;
    }
}
