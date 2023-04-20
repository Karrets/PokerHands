package space.kodirex.PokerHands.card;

public enum Suit {
    SPADE("Spades", 1),
    CLUB("Clubs", 2),
    DIAMOND("Diamonds", 3),
    HEART("Hearts", 4),
    ;
    private final String name;
    private final int value;

    /**
     * Constructor for Suit ENUM, not used externally.
     * @param name Name of the suit. (plural)
     * @param value Value of the suit, as per the rules of Texas Hold'em.
     */
    Suit(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * getValue
     * @return Returns the value a per Texas Hold'em.
     */
    public int getValue() {
        return value;
    }

    /**
     * toString
     * @return Returns the name of the suit.
     */
    @Override
    public String toString() {
        return name;
    }
}
