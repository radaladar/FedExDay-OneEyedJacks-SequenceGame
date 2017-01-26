/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    static String[] deckMap = new String[]{
            "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9",
            "♣6", "♣5", "♣4", "♣3", "♣2", "♥A", "♥K", "♥Q", "♥10", "♠10",
            "♣7", "♠A", "♦2", "♦3", "♦4", "♦5", "♦6", "♦7", "♥9", "♠Q",
            "♣8", "♠K", "♣6", "♣5", "♣4", "♣3", "♣2", "♦8", "♥8", "♠K",
            "♣9", "♠Q", "♣7", "♥6", "♥5", "♥4", "♥A", "♦9", "♥7", "♠A",
            "♣10", "♠10", "♣8", "♥7", "♥2", "♥3", "♥K", "♦10", "♥6", "♦2",
            "♣Q", "♠9", "♣9", "♥8", "♥9", "♥10", "♥Q", "♦Q", "♥5", "♦3",
            "♣K", "♠8", "♣10", "♣Q", "♣K", "♣A", "♦A", "♦K", "♥4", "♦4",
            "♣A", "♠7", "♠6", "♠5", "♠4", "♠3", "♠2", "♥2", "♥3", "♦5",
            "♦A", "♦K", "♦Q", "♦10", "♦9", "♦8", "♦7", "♦6",
            "J1", "J1", "J1", "J1",
            "J2", "J2", "J2", "J2"
    };

    private List<DeckCard> cards;

    public Deck() {
        cards = new ArrayList<>();
        populateDeck();
        Collections.shuffle(cards);
    }

    private void populateDeck() {
        for (String cardType : deckMap) {
            cards.add(new DeckCard(cardType));
        }
    }

    public DeckCard drawCard() {
        if (cards.size() > 0) {
            DeckCard cardDrawn = cards.get(0);
            cards.remove(cardDrawn);
            return cardDrawn;
        } else {
            return null;
        }
    }
}
