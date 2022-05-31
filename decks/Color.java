package com.company.BlackJack.decks;

import java.security.SecureRandom;

public enum Color {
    SPADE,
    HEART,
    CLOVER,
    DIAMOND;


    /**
     * the method is responsible for drawing a value equal to the appropriate color
     * (Spade, Heart, Clover, Diamond) of the deck
     */
    public static Color setColor() {
        int color = new SecureRandom().nextInt(4);
        switch (color) {
            case 1 -> {
                return Color.HEART;
            }
            case 2 -> {
                return Color.CLOVER;
            }
            case 3 -> {
                return Color.DIAMOND;
            }
            default -> {
                return SPADE;
            }
        }
    }
}
