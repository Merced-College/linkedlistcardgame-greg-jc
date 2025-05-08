// File: CardGame.java
// ------- Main Game Class -------
// Controls loading, dealing, and playing the War card game.
import java.io.*;
import java.util.*;

public class CardGame {
    private static final String CARD_FILE = "cards.txt"; // file listing all cards
    private static final int MAX_ROUNDS = 60;           // stops game if too long

    /**
     * Program start: loads deck, shuffles, deals cards, and runs game loop.
     * @param args not used
     */
    public static void main(String[] args) {
        try {
            // Load all cards from file into a List
            List<Card> fullDeck = loadDeckFromFile(CARD_FILE);
            // Randomize card order
            Collections.shuffle(fullDeck);

            // Prepare two player decks
            LinkedList player1 = new LinkedList();
            LinkedList player2 = new LinkedList();
            for (int i = 0; i < fullDeck.size(); i++) {
                // alternate dealing
                if (i % 2 == 0) {
                    player1.insertLast(fullDeck.get(i));
                } else {
                    player2.insertLast(fullDeck.get(i));
                }
            }

            // Game rounds: each player plays top card
            int round = 1;
            while (!player1.isEmpty() && !player2.isEmpty() && round <= MAX_ROUNDS) {
                System.out.println("=== Round " + round + " ===");
                // Each player draws their top card
                Card c1 = player1.removeFirst();
                Card c2 = player2.removeFirst();
                System.out.println("Player 1 plays: " + c1);
                System.out.println("Player 2 plays: " + c2);

                // Determine round winner
                if (c1.getValue() > c2.getValue()) {
                    // Player 1 wins, takes both cards to bottom of deck
                    player1.insertLast(c1);
                    player1.insertLast(c2);
                    System.out.println("Player 1 wins the round.\n");
                } else if (c2.getValue() > c1.getValue()) {
                    // Player 2 wins
                    player2.insertLast(c1);
                    player2.insertLast(c2);
                    System.out.println("Player 2 wins the round.\n");
                } else {
                    // Tie: each player keeps their own card
                    player1.insertLast(c1);
                    player2.insertLast(c2);
                    System.out.println("Tie! Cards returned.\n");
                }
                round++; // increment round counter
            }

            // Announce final outcome
            if (player2.isEmpty()) {
                System.out.println("Player 1 wins the game in " + (round - 1) + " rounds!");
            } else if (player1.isEmpty()) {
                System.out.println("Player 2 wins the game in " + (round - 1) + " rounds!");
            } else {
                System.out.println("Game is a draw after " + MAX_ROUNDS + " rounds.");
            }

        } catch (IOException e) {
            // Handle file read errors
            System.err.println("Error loading cards from " + CARD_FILE + ": " + e.getMessage());
        }
    }

    /**
     * Reads lines from cards.txt and builds Card objects.
     * Expected format per line: suit,name,value,filename
     * Invalid lines are skipped.
     * @param filename path to deck file
     * @return List of Cards read from file
     * @throws IOException on file access errors
     */
    private static List<Card> loadDeckFromFile(String filename) throws IOException {
        List<Card> deck = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue; // skip empty lines
            }
            String[] parts = line.split(",");
            if (parts.length != 4) {
                continue; // skip malformed entries
            }
            String suit = parts[0].trim();
            String name = parts[1].trim();
            int value   = Integer.parseInt(parts[2].trim());
            String pic  = parts[3].trim();
            deck.add(new Card(suit, name, value, pic));
        }
        reader.close();
        return deck;
    }
}
