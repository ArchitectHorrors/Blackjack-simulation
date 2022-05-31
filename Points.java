package com.company.BlackJack;

import java.util.Scanner;

public class Points {
    protected int betValue;
    protected int total = 50;
    protected Scanner scanner;

    public Points(Scanner scanner) {
        this.scanner = scanner;
    }

    public void betYourWin() {
        boolean correct = false;

        do {
            betValue = scanner.nextInt();

            if (betValue > total) {
                System.out.println("The entered value is incorrect. Try again.");
            } else {
                correct = true;
                System.out.println("The player has bet: " + betValue + " points.");
            }
        } while (!correct);
    }

    public void getBetBack(int bet) {
        total += bet;
    }

    public void looseBet(int bet) {
        total -= bet;
    }
}
