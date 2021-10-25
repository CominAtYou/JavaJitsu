package com.cominatyou;

public class Card {
    private CardType type;
    private int value;
    private String color;

    public Card() { // cards will always be randomly generated
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange"};
        CardType[] types = {CardType.FIRE, CardType.WATER, CardType.SNOW};
        // set type to random type
        this.type = types[(int) (Math.random() * types.length)];
        // set color to random color
        this.color = colors[(int) (Math.random() * colors.length)];
        // stuff for weighted random value generation
        int[] commonValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] rareValues = {10, 11, 12};
        // get random int from 0 to 29
        int randomInt = (int) (Math.random() * 30);
        // if random int is less than 25, set value to a random common value
        if (randomInt < 25) {
            this.value = commonValues[(int) (Math.random() * commonValues.length)];
        }
        // else, set it to a random rare value
        else {
            this.value = rareValues[(int) (Math.random() * rareValues.length)];
        }
    }

    public CardType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return String.format("%s %s card with value %d", color, type.name().toLowerCase(), value);
    }
}
