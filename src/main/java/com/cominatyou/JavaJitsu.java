package com.cominatyou;

import com.cominatyou.cards.Card;
import com.cominatyou.cards.CardComparisonResult;
import com.cominatyou.players.Opponent;
import com.cominatyou.players.Player;

/*
* Conditions for victory:
* Either:
* Have one card of each element type in different colors, or
* Have three of the same element in different colors.
*/

public class JavaJitsu {
    private static final Player player = new Player();
    private static final Opponent opponent = new Opponent();

    private static void roundResult(Card playerCard, Card opponentCard, CardComparisonResult result) {
        if (result == CardComparisonResult.WIN) {
            System.out.printf("Your %s beats your opponent's %s.\n", playerCard, opponentCard);
            player.addCardToWinPile(playerCard);
        } else if (result == CardComparisonResult.LOSS) {
            System.out.printf("Your %s lost to your opponent's %s.\n", playerCard, opponentCard);
            opponent.addCardToWinPile(playerCard);
        } else {
            System.out.printf("Your %s drew your opponent's %s.\n", playerCard, opponentCard);
        }
    }

    private static void clearConsole() {
        // DO NOT USE PRINTLN
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Generating card decks...");
        for (int i = 0; i < 5; i++) {
            player.addCard();
            opponent.addCard();
        }

        System.out.println("Ready!");

        while (true) {
            final Card opponentCard = opponent.playCard();
            final Card playerCard = player.playCard();

            final CardComparisonResult result = playerCard.compareTo(opponentCard);
            roundResult(playerCard, opponentCard, result);

            Thread.sleep(3000);

            clearConsole();

            final boolean playerVictory = CheckForVictory.check(player.getWinPile());
            final boolean opponentVictory = CheckForVictory.check(opponent.getWinPile());

            if (playerVictory) {
                System.out.println("You won!");
                break;
            } else if (opponentVictory) {
                System.out.println("You lost.");
                break;
            }

            if (player.getWinPile().size() != 0) System.out.println("Your win pile: " + player.getWinPile());
            if (opponent.getWinPile().size() != 0) System.out.println("Opponent's win pile: " + opponent.getWinPile());
            if (player.getWinPile().size() != 0 || opponent.getWinPile().size() != 0) System.out.println();

            player.addCard();
            opponent.addCard();
            Thread.sleep(2000);
        }
    }
}
