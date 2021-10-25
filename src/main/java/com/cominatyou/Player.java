package com.cominatyou;

import java.util.Scanner;
import java.util.List;

public class Player extends Entity {
    public Card playCard() {
        List<Card> cards = getCards();
        System.out.println("Please pick a card to play:");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ": " + cards.get(i).toString());
        }
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int cardIndex = scanner.nextInt() - 1;
        return cards.remove(cardIndex);

    }
}
