package com.company.BlackJack.util;

import com.company.BlackJack.Player;
import com.company.BlackJack.decks.Dealer;
import com.company.BlackJack.decks.Deck;
import com.company.BlackJack.decks.EnemyDeck;
import com.company.BlackJack.decks.Figure;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    private Utility() {
        // utility class
    }

    public static List<Object> inferIfNull(List<Object> objects){
        List<Object> nonNullObjects = new ArrayList<>();
        for (Object object : objects){
            if (object == null) {
                break;
            } else {
                nonNullObjects.add(object);
            }
        }

        return nonNullObjects;
    }

    public static int sum(List<Figure> figures) {
        int sum = 0;
        for (Figure figure : figures) {
            sum += Figure.getStrength(figure);
        }
        return sum;
    }

    public static Player compare(Deck myDeck, Deck firstEnemy, Deck secondEnemy) {
        List<Figure> myFigures = myDeck.getCardDeck().getFigures();
        List<Figure> feFigures = firstEnemy.getCardDeck().getFigures();
        List<Figure> seFigures = secondEnemy.getCardDeck().getFigures();

        boolean myGreaterThanFe = sum(myFigures) > sum(feFigures);
        boolean myGreaterThanSe = sum(myFigures) > sum(seFigures);
        boolean feGreaterThanSe = sum(seFigures) < sum(feFigures);

        if (myGreaterThanFe){
            if (myGreaterThanSe){
                return Player.MYSELF;
            }
        } else {
            if (feGreaterThanSe){
                return Player.FIRST_ENEMY;
            } else {
                return Player.SECOND_ENEMY;
            }
        }

        return Player.NO_ONE;
    }

    public static boolean compare(Deck bestDeck, Dealer dealer) {
        if (dealer == null) {
            return true; // it simply means dealer was thrown out
        }
        List<Figure> bestDeckFigures = bestDeck.getCardDeck().getFigures();
        List<Figure> dealerDeck = dealer.getCardDeck().getFigures();

        boolean winningGame = false;
        int bestDeckSum = sum(bestDeckFigures);
        int dealersSum = sum(dealerDeck);

        if (bestDeckSum > dealersSum) {
            System.out.println("The player has won the game. " +
                    "He scored more points than the dealer. ");
            winningGame = true;
        }

        return winningGame;
    }
}
//        if (myDeck == null && firstEnemy == null && secondEnemy == null) {
//            return Player.NO_ONE;
//        } else if (myDeck == null){
//            if (firstEnemy == null) {
//                return Player.SECOND_ENEMY;
//            }
//            if (sum(firstEnemy.getCardDeck().getFigures()) > sum(secondEnemy.getCardDeck().getFigures())){
//                return Player.FIRST_ENEMY;
//            } else {
//                return Player.SECOND_ENEMY;
//            }
//        } else if (firstEnemy == null) {
//            if (secondEnemy == null){
//                return Player.MYSELF;
//            } else {
//                if (sum(myDeck.getCardDeck().getFigures()) > sum(secondEnemy.getCardDeck().getFigures())){
//                    return Player.MYSELF;
//                } else {
//                    return Player.SECOND_ENEMY;
//                }
//            }
//        } else {
//            return Player.MYSELF;
//        }
/*
my ? f >
s
else
f ? s
 */

