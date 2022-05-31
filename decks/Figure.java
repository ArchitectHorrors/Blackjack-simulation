package com.company.BlackJack.decks;

public enum Figure {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
    EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), AS(11);

    private int strength;

    Figure(int strength) {
        this.strength = strength;
    }

    public static void setStrength(Figure figure, int strength) {
        if (figure.equals(ONE)) {
            ONE.strength = strength;
        } else if (figure.equals(AS)) {
            AS.strength = strength;
        }
    }

    public static int getStrength(Figure figure) {
        switch (figure) {
            case TWO -> {
                return TWO.strength;
            }
            case THREE -> {
                return THREE.strength;
            }
            case FOUR -> {
                return FOUR.strength;
            }
            case FIVE -> {
                return FIVE.strength;
            }
            case SIX -> {
                return SIX.strength;
            }
            case SEVEN -> {
                return SEVEN.strength;
            }
            case EIGHT -> {
                return EIGHT.strength;
            }
            case NINE -> {
                return NINE.strength;
            }
            case TEN -> {
                return TEN.strength;
            }
            case JACK -> {
                return JACK.strength;
            }
            case QUEEN -> {
                return QUEEN.strength;
            }
            case KING -> {
                return KING.strength;
            }
            case AS -> {
                return AS.strength;
            }
            default -> {
                return ONE.strength;
            }
        }
    }

    public static Figure getFigure(int index) {
        switch (index) {
            case 1 -> {
                return TWO;
            }
            case 2 -> {
                return THREE;
            }
            case 3 -> {
                return FOUR;
            }
            case 4 -> {
                return FIVE;
            }
            case 5 -> {
                return SIX;
            }
            case 6 -> {
                return SEVEN;
            }
            case 7 -> {
                return EIGHT;
            }
            case 8 -> {
                return NINE;
            }
            case 9 -> {
                return TEN;
            }
            case 10 -> {
                return JACK;
            }
            case 11 -> {
                return QUEEN;
            }
            case 12 -> {
                return KING;
            }
            case 13 -> {
                return AS;
            }
            default -> {
                return ONE;
            }
        }
    }
}