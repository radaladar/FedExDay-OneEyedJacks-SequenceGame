/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.service;

import com.sequencegame.oneeyedjacks.fedexday.greenfox.domain.Board;
import com.sequencegame.oneeyedjacks.fedexday.greenfox.domain.Deck;
import com.sequencegame.oneeyedjacks.fedexday.greenfox.domain.Player;
import com.sequencegame.oneeyedjacks.fedexday.greenfox.domain.Team;

public class GameLogic {
    private Board board;
    private Team greenTeam;
    private Team blueTeam;
    private Team yellowTeam;
    private Deck deck;
    private int round;


    public void playCard(int index) {
        Player activePlyer = activeTeam().getActivePlayer();
        activePlyer.playCard(index);
        if (activePlyer.getNumberOfCardsInHand() < 6 && deck.getNumberOfCardsRemaining() > 0) {
            activePlyer.addNewCardToHand(deck.drawCard());
        }
    }

    public void placeChip(int x, int y) {
        board.placeChip(x, y, activeTeam().getColor());
    }

    private Team activeTeam() {
        return greenTeam;
    }
}
