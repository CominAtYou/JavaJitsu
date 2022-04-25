package com.cominatyou.cards;

public class SnowCard extends Card {
    public SnowCard(int value, String color) {
        super(CardType.SNOW, value, color);
    }

    public CardComparisonResult compareTo(Card other) {
        if (super.getType() ==  other.getType()) {
            if (super.getValue() == other.getValue()) return CardComparisonResult.DRAW;
            else if (super.getValue() > other.getValue()) return CardComparisonResult.WIN;
            else return CardComparisonResult.LOSS;
        }
        if (other.getType() == CardType.FIRE) return CardComparisonResult.LOSS;
        else return CardComparisonResult.WIN;
    }
}
