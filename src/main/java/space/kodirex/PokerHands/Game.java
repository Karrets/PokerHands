package space.kodirex.PokerHands;

import space.kodirex.PokerHands.card.Card;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Game {
    public static final int HAND_SIZE = 5;

    /**
     * @param hand A hand with a size of exactly HAND_SIZE.
     * @return A boolean with the result of the query.
     * @throws IllegalArgumentException If a hand with an invalid size is given.
     */
    public static boolean isFullHouse(Card[] hand) {
        validateHandSize(hand.length);

        var handDistribution = getCardDistribution(hand, Card::rank).values();

        //In the event of a full house, 3 of your cards must be of the same value, and then another set of two of the
        //same value. This means a full house requires all cards fit the model, meaning there will be exactly two
        //items in our distribution. If we ever see anything else, we can assume safely that we don't have a full house.
        //This implementation **only** works with a hand size of 5.

        for(Integer i : handDistribution) {
            if(i == 3 || i == 2) break;

            return false;
        }

        return true;
    }

    /**
     * @param hand A hand with a size of exactly HAND_SIZE.
     * @return A boolean with the result of the query.
     * @throws IllegalArgumentException If a hand with an invalid size is given.
     */
    public static boolean isFlush(Card[] hand) {
        validateHandSize(hand.length);

        var handDistribution = getCardDistribution(hand, Card::suit).values();

        //Hand distribution must be a list of size 1, as all cards must be of the same value.
        return handDistribution.size() == 1;
    }

    /**
     * @param hand A hand with a size of exactly HAND_SIZE.
     * @return A boolean with the result of the query.
     * @throws IllegalArgumentException If a hand with an invalid size is given.
     */
    public static boolean isThreeOfAKind(Card[] hand) {
        validateHandSize(hand.length);

        var handDistribution = getCardDistribution(hand, Card::rank).values();


        for(Integer i : handDistribution) {
            if(i == 3) return true;
        }

        return false;
    }

    /**
     * @param hand A hand with a size of exactly HAND_SIZE.
     * @return A boolean with the result of the query.
     * @throws IllegalArgumentException If a hand with an invalid size is given.
     */
    public static boolean isFourOfAKind(Card[] hand) {
        validateHandSize(hand.length);

        var handDistribution = getCardDistribution(hand, Card::rank).values();

        for(Integer i : handDistribution) {
            if(i == 4) return true;
        }

        return false;
    }

    /**
     * Returns a distribution map, with key stored as a data type of your choice, and keys as the total given.
     * @param hand The hand / list of cards you want the distribution of. Ignores HAND_SIZE.
     * @param distOf A function, typically a lambda which determines what you want to make the distribution on.
     * @return Returns the given distribution map.
     * @param <Type> A type of your choice, usually inferred from distOf.
     */
    //This method returns a distribution of the cards as a map.
    //It looks more complicated than it is with those spooky generics.
    private static <Type> Map<Type, Integer> getCardDistribution(Card[] hand, Function<Card, Type> distOf) {
        return Arrays.stream(hand)
                .collect(Collectors.groupingBy(distOf, //This collector groups cards by
                        // value, and stores the quantity as a value in map
                        Collectors.summingInt(card -> 1)));
    }

    /**
     * Enforces hand size requirements
     * @param length Takes length of a hand
     * @throws IllegalArgumentException if length is of invalid size, based on HAND_SIZE
     */
    private static void validateHandSize(int length) {
        if(length != 5)
            throw new IllegalArgumentException("Hand size must be %d".formatted(HAND_SIZE));

    }
}
