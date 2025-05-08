// File: Card.java
// ------- Card Class -------
// Stores information about a single playing card used in the game.
public class Card {
    // The suit of this card (e.g., "heart", "diamond")
    private String suit;
    // The face name of this card (e.g., "ace", "two", "king")
    private String name;
    // Numeric value for game comparisons (higher wins)
    private int value;
    // Filename for card image (not used in console version)
    private String pic;

    /**
     * Builds a card with specified suit, name, value, and image file.
     * @param suit  suit of card (heart, diamond, club, spade)
     * @param name  face name (two, jack, ace, etc.)
     * @param value numeric value used for comparing cards
     * @param pic   image filename (e.g. "ah.gif")
     */
    public Card(String suit, String name, int value, String pic) {
        this.suit  = suit;
        this.name  = name;
        this.value = value;
        this.pic   = pic;
    }

    /**
     * Gets the numeric value of the card.
     * @return value for comparing cards in a round
     */
    public int getValue() {
        return value;
    }

    /**
     * Provides a text description of the card for console output.
     * @return formatted string like "ace of heart (value=11)"
     */
    @Override
    public String toString() {
        return name + " of " + suit + " (value=" + value + ")";
    }
}
