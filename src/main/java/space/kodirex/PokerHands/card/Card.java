package space.kodirex.PokerHands.card;

/**
 * @param rank The face / value of the card
 * @param suit The suit of the card
 */
public record Card(Rank rank, Suit suit) {

    /**
     * Gives a human-readable String of the card
     *
     * @return A String formatted as *Face* of *Suit* i.e. "Ace of Spades"
     */
    @Override
    public String toString() {
        return "%s of %s".formatted(rank, suit);
    }
}
