package com.company.BlackJack.decks;

import java.util.Scanner;

public class MyDeck extends Deck {
    final String MY_VALUES = "The values of your cards: ";

    public MyDeck(Dealer dealer, Scanner scanner) {
        super(dealer, scanner);
    }

    String ERROR = "An invalid value was entered. Try again.";

    public void showCards() {
        System.out.println(MY_VALUES);

        for (int i = 0; i < cardDeck.getFigures().size(); i++) {
            System.out.print(cardDeck.getFigures().get(i) + " OF ");
            System.out.println(cardDeck.getColors().get(i));
        }
    }

    @Override
    public void betYourWin() {
        boolean correct = false;
        do {
            System.out.print("Enter the value of your bet for this game: ");
            betValue = scanner.nextInt();

            if (betValue > total) {
                System.out.println("The entered value is incorrect. Try again.");
            } else {
                correct = true;
                System.out.println("The player has bet: " + betValue + " points.");
            }
        } while (!correct);
    }
}
