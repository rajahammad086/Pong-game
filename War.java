// Raja Hammad Mehmood
/*
 * The two-player card game War, as described here:
 * http://en.wikipedia.org/wiki/War_%28card_game%29
 */

public class War {
    public static void main(String[] args) {

        Deck deck = new Deck(); // the deck of cards
        Player player1=new Player("Raja"); // player 1
        Player player2=new Player("Ali");  // player 2

        // shuffle a deck of cards
        deck.shuffle();

        // deal half to each player's player:
        player1.dealCards(deck,26);
        player2.dealCards(deck,26);

        // repeat until one player runs out of cards
        for (; player1.getNumCards()> 0 && player2.getNumCards() > 0;) {
            System.out.println();
            System.out.println("card count: " + player1.getNumCards() + " - " + player2.getNumCards());

            // cards played in this war
            Hand played = new Hand();

            // if someone runs out of cards in the middle of a war, the game
            // is over
            for (; player1.getNumCards() > 0 && player2.getNumCards() > 0;) {
                // each player plays a card
                Card card1=player1.playCard();
                played.addCard(card1);
                Card card2=player2.playCard();
                played.addCard(card2);
                System.out.println("playing: " + card1 + " / " + card2);

                // if player 1's card is higher
                //   player 1 has won the war
                // else if player 2's card is higher
                //   player 2 has won the war
                // else (there's a tie)
                //   each player plays an additional card
                //   continue the war
                if (card1.getValue() > card2.getValue()) {
                    // player 1 gets the cards in random order (to avoid infinite
                    // war)
                    player1.warWon(played);
                    System.out.println("   player 1 gets the cards");
                    break;
                } else if (card2.getValue() > card1.getValue()) {
                    // player 2 gets the cards in random order (to avoid infinite
                    // war)
                    player2.warWon(played);
                    System.out.println("   player 2 gets the cards");
                    break;
                } else {
                    System.out.println("   tie");
                    // play another card from each player's hand, if possible
                    if (player1.getNumCards() == 0 || player2.getNumCards() == 0) {
                        // if someone is out of cards, game is over
                        break;
                    }
                    card1=player1.playCard();
                    played.addCard(card1);
                    card2=player2.playCard();
                    played.addCard(card2);


                    // and continue the loop - the next cards played by each
                    // player are compared just like the first pair played
                }
            }
        }

        // congratulate the winner - the winner is the player with cards
        System.out.println();
        if (player1.getNumCards() > 0) {
            System.out.println(player1.getName() +" wins!");
        } else {
            System.out.println(player2.getName() +" wins!");
        }
        // printing the number of wins
        System.out.println(player1.getName()+ " won " + player1.getNumWarsWon() + " games");
        System.out.println(player2.getName()+ " won " + player2.getNumWarsWon() + " games");
    }
}