package com.cominatyou.players;

import java.util.ArrayList;

import com.cominatyou.cards.Card;

public class Opponent extends Entity {

    public Card playCard() {
        final ArrayList<Card> cards = getCards();
        // return random item from cards
        return cards.remove((int) (Math.random() * cards.size()));
    }
}
