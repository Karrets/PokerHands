package space.kodirex.PokerHands;

import space.kodirex.PokerHands.card.Card;
import space.kodirex.PokerHands.card.Rank;
import space.kodirex.PokerHands.card.Suit;

public class Main {
    public static void main(String[] args) {
        Card[] hand = new Card[] {
                new Card(Rank.ONE, Suit.SPADE),
                new Card(Rank.TWELVE, Suit.HEART),
                new Card(Rank.TWELVE, Suit.HEART),
                new Card(Rank.TWELVE, Suit.HEART),
                new Card(Rank.TWELVE, Suit.HEART),
        };
    }
}
