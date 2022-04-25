package com.cominatyou.cards;

public class WaterCard extends Card {
    public WaterCard(int value, String color) {
        super(CardType.WATER, value, color);
    }

    public CardComparisonResult compareTo(Card other) {
        if (super.getType() ==  other.getType()) {
            if (super.getValue() == other.getValue()) return CardComparisonResult.DRAW;
            else if (super.getValue() > other.getValue()) return CardComparisonResult.WIN;
            else return CardComparisonResult.LOSS;
        }
        if (other.getType() == CardType.SNOW) return CardComparisonResult.LOSS;
        else return CardComparisonResult.WIN;
    }
}
