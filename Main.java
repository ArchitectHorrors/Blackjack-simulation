package com.company.BlackJack;

import com.company.BlackJack.decks.Dealer;
import com.company.BlackJack.decks.EnemyDeck;
import com.company.BlackJack.decks.MyDeck;
import com.company.BlackJack.util.Utility;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Dealer dealer = new Dealer();
        MyDeck myDeck = new MyDeck(dealer, scanner);
        EnemyDeck firstEnemy = new EnemyDeck(dealer, scanner);
        EnemyDeck secondEnemy = new EnemyDeck(dealer, scanner);
        final CMDInterface cmd = new CMDInterface(dealer, myDeck, firstEnemy, secondEnemy, scanner);

        myDeck.betYourWin();
        firstEnemy.betYourWin("first");
        secondEnemy.betYourWin("second");

        dealer.drawCard();
        dealer.drawCard();
        cmd.drawCards();

        cmd.showCards(true);

        Action choice;
        do {
            choice = cmd.drawNewCard();
            if (choice == Action.YES) {
                cmd.hitCard(myDeck);
            }
            firstEnemy.hitCard();
            secondEnemy.hitCard();

            cmd.showCards(true);
        } while (!choice.equals(Action.BLOCK_MYSELF));

        cmd.showCards(false);
        List<Player> players = cmd.checkCardsSum();
        for (Player player : players) {
            switch (player) {
                case MYSELF -> myDeck.block();
                case FIRST_ENEMY -> firstEnemy.block();
                case SECOND_ENEMY -> secondEnemy.block();
                case DEALER -> dealer.block();
            }
        }

        Player previsionWinner = Utility.compare(myDeck, firstEnemy, secondEnemy);
        if (previsionWinner.equals(Player.MYSELF)) {
            System.out.println(Utility.compare(myDeck, dealer) ? "You won :)" : "Dealer won :(");
            Objects.requireNonNull(myDeck).getBetBack(myDeck.betValue);
            myDeck.getBetBack(myDeck.betValue);
            System.out.println("You have " + myDeck.total + " points.");

        } else if (previsionWinner.equals(Player.FIRST_ENEMY)) {
            System.out.println(Utility.compare(firstEnemy, dealer) ? "First opponent won :(" : "Dealer won :(");
            firstEnemy.getBetBack(firstEnemy.betValue);
            System.out.println("Winner have " + firstEnemy.total + " points.");

        } else if (previsionWinner.equals(Player.SECOND_ENEMY)) {
            System.out.println(Utility.compare(secondEnemy, dealer) ? "Second opponent won :(" : "Dealer won :(");
            secondEnemy.getBetBack(secondEnemy.betValue);
            System.out.println("Winner have " + secondEnemy.total + " points.");

        } else if (previsionWinner.equals(Player.NO_ONE)){
            System.out.println(dealer.isBlocked() ? "No one won" : "Dealer won :(");
        }
    }
}