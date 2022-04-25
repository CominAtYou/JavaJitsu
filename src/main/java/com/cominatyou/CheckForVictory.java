package com.cominatyou;

import java.util.ArrayList;

import com.cominatyou.cards.Card;

// Conditions for winning:
// Player has at least three cards in their win pile.
// The win pile has three cards of the same type that do not have the same color, or
// The win pile has three cards of the same color that are of different types.
public class CheckForVictory {
    public static boolean check(ArrayList<Card> winPile) {
        final ArrayList<Card> uniqueCards = new ArrayList<>();

        winPile.forEach(i -> {
            if (!uniqueCards.contains(i)) uniqueCards.add(i);
        });

        if (uniqueCards.size() < 3) return false;

        // Check for three colors that do not have the same type
        final ArrayList<Card> uniqueColorCards = new ArrayList<>();

        uniqueColorCards.add(uniqueCards.get(0));

        for (int i = 0; i < uniqueCards.size(); i++) {
            // loop through uniqueCards and add a card to uniqueColorCards if it is not the same color as the last card
            if (!uniqueColorCards.get(uniqueColorCards.size() - 1).getColor().equals(uniqueCards.get(i).getColor())) {
                uniqueColorCards.add(uniqueCards.get(i));
            }
        }

        // return true if there are at least three cards in uniqueColorCards with different types
        for (int i = 0; i < uniqueColorCards.size() - 2; i++) {
            if (uniqueColorCards.get(i).getType() != uniqueColorCards.get(i + 1).getType()
                    && uniqueColorCards.get(i).getType() != uniqueColorCards.get(i + 2).getType()) {
                return true;
            }
        }

        // Filter cards with unique types in uniqueCards
        final ArrayList<Card> uniqueTypeCards = new ArrayList<>();

        uniqueTypeCards.add(uniqueCards.get(0));

        for (int i = 0; i < uniqueCards.size(); i++) {
            // loop through uniqueCards and add a card to uniqueTypeCards if it is not the same type as the last card
            if (uniqueTypeCards.get(uniqueTypeCards.size() - 1).getType() != uniqueCards.get(i).getType()) {
                uniqueTypeCards.add(uniqueCards.get(i));
            }
        }

        // return true if there are at least three cards in uniqueTypeCards with different colors
        for (int i = 0; i < uniqueTypeCards.size() - 2; i++) {
            if (uniqueTypeCards.get(i).getColor() != uniqueTypeCards.get(i + 1).getColor()
                    && uniqueTypeCards.get(i).getColor() != uniqueTypeCards.get(i + 2).getColor()) {
                return true;
            }
        }

        return false;
    }
}
