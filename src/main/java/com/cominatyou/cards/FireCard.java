package com.cominatyou.cards;

public class FireCard extends Card {
    public FireCard(int value, String color) {
        super(CardType.FIRE, value, color);
    }

    public CardComparisonResult compareTo(Card other) {
        if (super.getType() ==  other.getType()) {
            if (super.getValue() == other.getValue()) return CardComparisonResult.DRAW;
            else if (super.getValue() > other.getValue()) return CardComparisonResult.WIN;
            else return CardComparisonResult.LOSS;
        }
        else if (other.getType() == CardType.WATER) return CardComparisonResult.LOSS;
        else return CardComparisonResult.WIN;
    }
}
