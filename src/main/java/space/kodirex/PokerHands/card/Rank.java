package space.kodirex.PokerHands.card;

public enum Rank {
    ONE("Ace", 13),
    TWO("Two", 1),
    THREE("Three", 2),
    FOUR("Four", 3),
    FIVE("Five", 4),
    SIX("Six", 5),
    SEVEN("Seven", 6),
    EIGHT("Eight", 7),
    NINE("Nine", 8),
    TEN("Ten", 9),
    ELEVEN("Jack", 10),
    TWELVE("Queen", 11),
    THIRTEEN("King", 12);

    private final String name;
    private final int value;

    /**
     * Constructor for Face Enum, not used by outside classes
     * @param name Name of the card as it would be read by a player.
     * @param value Value of card on its own, in Texas Hold'em.
     */
    Rank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * getValue
     * @return Returns the value of the card, a per Texas Hold'em
     */
    public int getValue() {
        return value;
    }

    /**
     * toString
     * @return Returns the name of the card, not identical to the ENUM constants.
     */
    @Override
    public String toString() {
        return name;
    }
}
