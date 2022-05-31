package com.company.BlackJack.decks;

import com.company.BlackJack.Points;

import java.util.Scanner;

public abstract class Deck extends Points {
    protected final CardDeck cardDeck = new CardDeck();
    protected final Dealer dealer;
    private boolean isBlocked = false;

    public Deck(Dealer dealer, Scanner scanner){
        super(scanner);
        this.dealer = dealer;
    }

    public void drawCards() {
        for (int i = 0; i < 2; i++) {
            Figure figure = Figure.getFigure(dealer.getCard());
            cardDeck.getFigures().add(i, figure);
            cardDeck.getColors().add(i, Color.setColor());
        }
    }

    protected abstract void showCards();

    public final CardDeck getCardDeck() {
        return cardDeck;
    }

    public void betYourWin() {
        System.out.println("SPACE");
        System.out.print("Enter the value you want to bet on: ");
    }

    public void block(){
        this.isBlocked = true;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
