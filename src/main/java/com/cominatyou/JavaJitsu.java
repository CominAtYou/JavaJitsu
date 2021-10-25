package com.cominatyou;

/*
* Conditions for victory:
* Either:
* Have one card of each element type in different colors, or
* Have three of the same element in different colors.
*/


public class JavaJitsu {
    private static Player player = new Player();
    private static Opponent opponent = new Opponent();

    private static void roundVictory(Card playerCard, Card opponentCard) {
        System.out.printf("Your %s beats your opponent's %s.\n", playerCard, opponentCard);
        player.addCardToWinPile(playerCard);

    }
    private static void roundDefeat(Card playerCard, Card opponentCard) {
        System.out.printf("Your %s loses to your opponent's %s.\n", playerCard, opponentCard);
        opponent.addCardToWinPile(opponentCard);
    }
    private static void roundTie(Card playerCard, Card opponentCard) {
        System.out.printf("Your %s tied with your opponent's %s.\n", playerCard, opponentCard);
        player.addCardToWinPile(playerCard);
        opponent.addCardToWinPile(opponentCard);
    }
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Generating card decks...");
        for (int i = 0; i < 5; i++) {
            player.addCard();
            opponent.addCard();
        }
        System.out.println("Ready!");
        // clear the console screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            Card opponentCard = opponent.playCard();
            Card playerCard = player.playCard();
            if (playerCard.getType() == opponentCard.getType()) {
                if (playerCard.getValue() > opponentCard.getValue()) {
                    roundVictory(playerCard, opponentCard);
                }
                else if (playerCard.getValue() < opponentCard.getValue()) {
                    roundDefeat(playerCard, opponentCard);
                }
                else {
                    roundTie(playerCard, opponentCard);
                }
            }
            else {
                if (playerCard.getType().ordinal() > opponentCard.getType().ordinal()) {
                    roundVictory(playerCard, opponentCard);
                }
                else {
                    roundDefeat(playerCard, opponentCard);
                }
            }
            player.addCard();
            opponent.addCard();
            Thread.sleep(2000);
        }
    }
}
