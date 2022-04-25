package com.cominatyou.players;

import java.util.Scanner;

import com.cominatyou.cards.Card;

import java.util.ArrayList;

public class Player extends Entity {
    public Card playCard() {
        final ArrayList<Card> cards = getCards();

        System.out.println("Please pick a card to play:");

        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ": " + cards.get(i));
        }

        @SuppressWarnings("all")
        Scanner scanner = new Scanner(System.in);

        int cardIndex;
        do {
            System.out.print("Your choice: ");
            cardIndex = scanner.nextInt() - 1;
        }
        while (cardIndex < 0 || cardIndex >= cards.size());

        return cards.remove(cardIndex);
    }
}
