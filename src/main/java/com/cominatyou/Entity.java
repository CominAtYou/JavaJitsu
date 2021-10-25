package com.cominatyou;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    private List<Card> winPile = new ArrayList<Card>();

    private List<Card> cards = new ArrayList<Card>();

    public abstract Card playCard();

    public List<Card> getCards() {
        return cards;
    }

    public void addCard() {
        cards.add(new Card());
    }

    public void addCardToWinPile(Card card) {
        winPile.add(card);
    }
}
