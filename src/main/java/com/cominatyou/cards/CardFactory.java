package com.cominatyou.cards;

public class CardFactory {
    public static Card drawCard() {
        final String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange"};
        final CardType[] types = {CardType.FIRE, CardType.WATER, CardType.SNOW};

        // set type to random type
        final CardType type = types[(int) (Math.random() * types.length)];

        // set color to random color
        final String color = colors[(int) (Math.random() * colors.length)];

        // stuff for weighted random value generation
        final int[] commonValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int[] rareValues = {10, 11, 12};

        // get random int from 0 to 29
        final int randomInt = (int) (Math.random() * 30);

        // if random int is less than 25, set value to a random common value. Else, set it to a random rare value.
        final int value = randomInt < 25 ? commonValues[(int) (Math.random() * commonValues.length)] : rareValues[(int) (Math.random() * rareValues.length)];

        if (type == CardType.FIRE) return new FireCard(value, color);
        else if (type == CardType.WATER) return new WaterCard(value, color);
        else return new SnowCard(value, color);
    }
}
