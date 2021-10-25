package com.cominatyou;

import java.util.List;

public class Opponent extends Entity {

    public Card playCard() {
        List<Card> cards = getCards();
        // return random item from cards
        return cards.remove((int) (Math.random() * cards.size()));
    }
}
