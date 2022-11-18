import file.FileByChaining;

public class Main {
    //Perform a test that simulates a card battle game between 2 virtual players.
    //The game is played with a deck starting at 2 and ending at 14.

    public static void main(String[] args) {
        //Create a deck of cards
        FileByChaining player1 = new FileByChaining();
        FileByChaining player2 = new FileByChaining();

        //Fill the deck with cards
        FileByChaining cardPlayed = new FileByChaining();

        //Create a deck of 52 cards
        int[] deck = new int[52];
        int nbCards = 0;
        for (int i = 2; i <= 14; i++) {
            deck[nbCards] = i;
            nbCards++;
            deck[nbCards] = i;
            nbCards++;
            deck[nbCards] = i;
            nbCards++;
            deck[nbCards] = i;
            nbCards++;
        }

        //Shuffle the deck.

        //Create the deck of each player
        for (int i = 0; i < 52; i = i + 2) {
            player1.push(deck[i]);
            player2.push(deck[i + 1]);
        }

        //Display the decks
        System.out.println("Player 1's deck :" + player1.showFile());
        System.out.println("Player 2's deck :" + player2.showFile());

        int nbRounds = 0;

        //Play the game
        while (!player1.isEmpty() && !player2.isEmpty()) {
            //Get the cards
            Object card1 = player1.pop();
            Object card2 = player2.pop();
            nbRounds++;

            //Put the cards in the cardPlayed pile
            cardPlayed.push(card1);
            cardPlayed.push(card2);

            //if there is a tie, 1 cards from each player are played face down and the game continues.
            while (card1 == card2) {
                System.out.println("Tie ! " + card1 + " = " + card2);
                card1 = player1.pop();
                card2 = player2.pop();
                nbRounds++;
                cardPlayed.push(card1);
                cardPlayed.push(card2);
                //There is an error here, if the player has no more cards, the game will crash.
                card1 = player1.pop();
                card2 = player2.pop();
                nbRounds++;
            }

            //If the card of player 1 is higher than the card of player 2, player 1 wins the round.
            System.out.println("Player 1's card : " + card1 + " Player 2's card : " + card2);
            if ((int)card1 > (int)card2) {
                while (cardPlayed.length() != 0) {
                    player1.push(cardPlayed.pop());
                }
                System.out.println("Player 1 wins the round " + nbRounds);
            } else {
                while (cardPlayed.length() != 0) {
                    player2.push(cardPlayed.pop());
                }
                System.out.println("Player 2 wins the round " + nbRounds);
            }
            System.out.println("Player 1's deck :" + player1.showFile());
            System.out.println("Player 2's deck :" + player2.showFile());
        }
        //If one of the players has no more cards, the game ends.
        if (player1.length() > player2.length()) {
            System.out.println("Player 1 wins the game in " + nbRounds + " rounds");
        } else {
            System.out.println("Player 2 wins the game in " + nbRounds + " rounds");
        }
    }
}
