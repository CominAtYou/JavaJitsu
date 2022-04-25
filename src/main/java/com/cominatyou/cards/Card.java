package com.cominatyou.cards;

public abstract class Card {
    final private CardType type;
    final private int value;
    final private String color;

    public Card(CardType type, int value, String color) { // cards will always be randomly generated
        this.type = type;
        this.value = value;
        this.color = color;
    }

    public abstract CardComparisonResult compareTo(Card other);

    public CardType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public boolean equals(Object other) {
        if (other == null) return false;

        if (other == this) return true;

        if (!(other instanceof Card)) return false;

        Card otherCard = (Card) other;
        return this.type == otherCard.type && this.color.equals(otherCard.color);
    }

    public String toString() {
        return String.format("%s %s card with value %d", color, type.name().toLowerCase(), value);
    }
}
