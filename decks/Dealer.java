package com.company.BlackJack.decks;

import java.util.List;
import java.util.Random;

public class Dealer {
    private final CardDeck cardDeck = new CardDeck();
    private final Random random = new Random();
    private boolean isBlocked = false;

    String DEALER_FIRST_CARD = "The value of dealer first card: ";
//    String ALL_DEALERS_CARDS = "The value of dealers cards: ";

    /**
     * the purpose od the method is to draw cards for
     * individual players
     */
    public int getCard() {
        return random.nextInt(14);
    }

    public void drawCard() {
        Figure figure = Figure.getFigure(getCard());
        cardDeck.getFigures().add(0, figure);
        cardDeck.getColors().add(0, Color.setColor());
    }

    public void throwTwoCardsAway(Deck deck) {
        List<Figure> figures = deck.cardDeck.getFigures().stream().limit(2).toList();
        List<Color> colors = deck.cardDeck.getColors().stream().limit(2).toList();

        deck.cardDeck.getFigures().removeAll(figures);
        deck.cardDeck.getColors().removeAll(colors);
    }

    public void showFirstCard() {
        System.out.println(DEALER_FIRST_CARD + cardDeck.getFigures().get(0) +
                " " + cardDeck.getColors().get(0));
    }

    public void showCards(boolean showOnlyFirst) {
        if (showOnlyFirst) {
            System.out.println("The value of dealer card: ");
            System.out.print(cardDeck.getFigures().get(0) + " OF ");
            System.out.println(cardDeck.getColors().get(0));
        } else {
            System.out.println("The value of dealer card: ");
            for (int i = 0; i < cardDeck.getFigures().size(); i++) {
                System.out.print(cardDeck.getFigures().get(i)+ " OF ");
                System.out.println(cardDeck.getColors().get(i));
            }
        }
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public void block(){
        this.isBlocked = true;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
