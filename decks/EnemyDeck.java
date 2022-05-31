package com.company.BlackJack.decks;

import com.company.BlackJack.util.Utility;
import verificationOfEvents.Events;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class EnemyDeck extends Deck {
    private static final Random random = new SecureRandom();
    private final Events events;
    final String OPPONENTS_VALUE = "The values of opponent's cards: ";

    public EnemyDeck(Dealer dealer, Scanner scanner){
        super(dealer, scanner);
        this.events = new Events(dealer);
    }

    public void showCards() {
        System.out.println(OPPONENTS_VALUE);

        for (int i = 0; i < cardDeck.getFigures().size(); i++) {
            System.out.print(cardDeck.getFigures().get(i) + " OF ");
            System.out.println(cardDeck.getColors().get(i));
        }
    }

    public void hitCard() {
        int sum = Utility.sum(cardDeck.getFigures());
        if (sum <= 18) {
            System.out.println("The opponent decided to draw the card.");
            events.hitCard(this);
            showCards();
        } else {
            events.stand();
            block();
        }
    }

    public void betYourWin(String name) {
        super.betValue = random.nextInt(super.total);
        System.out.println("The " + name + " opponent has bet: " + betValue + " points.");
    }
}
