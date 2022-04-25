package com.cominatyou.players;

import java.util.ArrayList;

import com.cominatyou.cards.Card;
import com.cominatyou.cards.CardFactory;

public abstract class Entity {

    private ArrayList<Card> winPile = new ArrayList<Card>();

    private ArrayList<Card> cards = new ArrayList<Card>();

    public abstract Card playCard();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Card> getWinPile() {
        return winPile;
    }

    public void addCard() {
        cards.add(CardFactory.drawCard());
    }

    public void addCardToWinPile(Card card) {
        winPile.add(card);
    }
}
