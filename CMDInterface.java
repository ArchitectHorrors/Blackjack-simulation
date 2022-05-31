package com.company.BlackJack;

import com.company.BlackJack.decks.Dealer;
import com.company.BlackJack.decks.Deck;
import com.company.BlackJack.decks.EnemyDeck;
import com.company.BlackJack.decks.MyDeck;
import verificationOfEvents.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CMDInterface {
    private final Scanner scanner;
    private final Events events;
    private final String SPACE = "*--------------------------------------------*";
    private final Dealer dealer;
    private final MyDeck myDeck;
    private final EnemyDeck firstEnemy;
    private final EnemyDeck secondEnemy;

    public CMDInterface(Dealer dealer, MyDeck myDeck, EnemyDeck firstEnemy, EnemyDeck secondEnemy, Scanner scanner) {
        this.events = new Events(dealer);
        this.dealer = dealer;
        this.myDeck = myDeck;
        this.firstEnemy = firstEnemy;
        this.secondEnemy = secondEnemy;
        this.scanner = scanner;
    }

    void drawCards() {
        firstEnemy.drawCards();
        secondEnemy.drawCards();
        myDeck.drawCards();
    }

    void showCards(boolean showDealerFirstCard) {
        System.out.println(SPACE);
        String STARTING_GAME = "The dealer dealt the cards. ";
        System.out.println(STARTING_GAME);

        System.out.println(SPACE);
        myDeck.showCards();
        firstEnemy.showCards();
        secondEnemy.showCards();
        dealer.showCards(showDealerFirstCard);
    }

    /**
     * the purpose of the method is to determine if
     * the player wants to exchange their card
     *
     * @return
     */
    public Action drawNewCard() {
        Action choice = Action.BLOCK_MYSELF;
        if (myDeck.isBlocked()) {
            return choice;
        }

        System.out.println(SPACE);
        String CHANGE_CARD = "Do you want to draw another card?";
        boolean correctValue = false;

        do {
            System.out.println(CHANGE_CARD);
            System.out.println("1. YES." + "\n" + "2. NO.");

            String action = scanner.next() + scanner.nextLine();
            try {
                choice = Action.stringValueOf(action);
            } catch (IllegalArgumentException e) {
                System.out.println("No such option!");
                try {
                    System.out.println("1. YES." + "\n" + "2. NO.");
                    choice = Action.stringValueOf(action);
                } catch (IllegalArgumentException ex) {
                    choice = Action.NO;
                }
            }

            if (choice.equals(Action.YES)) {
                correctValue = true;
            } else if (choice.equals(Action.NO)) {
                correctValue = true;
                myDeck.block();
            } else {
                String ERROR = "An invalid value was entered. Try again.";
                System.out.println(ERROR);
            }
        } while (!correctValue);

        return choice;
    }

    List<Player> checkCardsSum() {
        System.out.println(SPACE);
        List<Player> players = new ArrayList<>();
        if (events.exceededSum(myDeck)) {
            System.out.println(SPACE);
            players.add(Player.MYSELF);
        } else if (events.exceededSum(firstEnemy)) {
            dealer.throwTwoCardsAway(firstEnemy);
            players.add(Player.FIRST_ENEMY);
        } else if (events.exceededSum(secondEnemy)) {
            dealer.throwTwoCardsAway(secondEnemy);
            players.add(Player.SECOND_ENEMY);
        } else if (events.exceededSum(dealer)) {
            events.dealerSurplus();
            players.add(Player.DEALER);
        }
        return players;
    }

    public void hitCard(Deck deck) {
        events.hitCard(deck);
    }
}
