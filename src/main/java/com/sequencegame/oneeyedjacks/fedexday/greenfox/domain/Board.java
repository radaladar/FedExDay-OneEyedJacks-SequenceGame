/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.domain;

public class Board {
    static String[][] boardMap = new String[][]{
            {"WC", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "WC"},
            {"♣6", "♣5", "♣4", "♣3", "♣2", "♥A", "♥K", "♥Q", "♥10", "♠10"},
            {"♣7", "♠A", "♦2", "♦3", "♦4", "♦5", "♦6", "♦7", "♥9", "♠Q"},
            {"♣8", "♠K", "♣6", "♣5", "♣4", "♣3", "♣2", "♦8", "♥8", "♠K"},
            {"♣9", "♠Q", "♣7", "♥6", "♥5", "♥4", "♥A", "♦9", "♥7", "♠A"},
            {"♣10", "♠10", "♣8", "♥7", "♥2", "♥3", "♥K", "♦10", "♥6", "♦2"},
            {"♣Q", "♠9", "♣9", "♥8", "♥9", "♥10", "♥Q", "♦Q", "♥5", "♦3"},
            {"♣K", "♠8", "♣10", "♣Q", "♣K", "♣A", "♦A", "♦K", "♥4", "♦4"},
            {"♣A", "♠7", "♠6", "♠5", "♠4", "♠3", "♠2", "♥2", "♥3", "♦5"},
            {"WC", "♦A", "♦K", "♦Q", "♦10", "♦9", "♦8", "♦7", "♦6", "WC"}
    };

    private BoardCard[][] boardCards;
    private Deck deck;

    public Board() {
        deck = new Deck();
        boardCards = new BoardCard[boardMap.length][boardMap[0].length];
        populateBoard();
    }

    private void populateBoard() {
        for (int i = 0; i < boardMap.length; i++) {
            for (int j = 0; j < boardMap[i].length; j++) {
                boardCards[i][j] = new BoardCard(boardMap[i][j]);
            }
        }
    }
}
