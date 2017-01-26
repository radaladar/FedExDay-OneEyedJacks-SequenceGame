/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.service;

import com.sequencegame.oneeyedjacks.fedexday.greenfox.domain.*;

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
        board.placeChip(x, y, activeTeam().getColorCode());
    }

    public boolean isDumpingDeadCardAllowed(int index) {
        Card card = activeTeam().getActivePlayer().getHand().get(index);
        int[][] placesTocheck = board.findCardOnBoard(card.toString());
        return board.isCardisOccupied(placesTocheck[0][0], placesTocheck[0][1]) && board.isCardisOccupied(placesTocheck[1][0], placesTocheck[1][1]);
    }

    private Team activeTeam() {
        return greenTeam;
    }

    public boolean isThereASequenceWithTheLastChipPutDown(int teamColorCode, int x, int y) {
        return checkHorizontal(teamColorCode, y) || checkVertical(teamColorCode, x) || checkDiagonal(teamColorCode, x, y);
    }

    public boolean checkHorizontal(int teamColorCode, int y) {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (counter == 5) {
                break;
            } else if (board.getColorCodesForChips()[y][i] == teamColorCode) {
                counter++;
            } else {
                counter = 0;
            }
        }
        return counter == 5;
    }

    public boolean checkVertical(int teamColorCode, int x) {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (counter == 5) {
                break;
            } else if (board.getColorCodesForChips()[i][x] == teamColorCode) {
                counter++;
            } else {
                counter = 0;
            }
        }
        return counter == 5;
    }

    public boolean checkDiagonal(int team, int x, int y) {
        return checkDiagonalLeftToRight(team, x, y) || checkDiagonalRightToLeft(team, x, y);
    }

    private boolean checkDiagonalLeftToRight(int team, int x, int y) {
        int counter = 0;
        int startFromHereVertical = y;
        int startFromHereHorizontal = x;
        while (startFromHereHorizontal > 0 && startFromHereVertical > 0) {
            startFromHereVertical--;
            startFromHereHorizontal--;
        }
        if ((startFromHereHorizontal == 0 && startFromHereVertical > 5) ||
                (startFromHereHorizontal > 5 && startFromHereVertical == 0)) {
            return false;
        } else {
            for (int i = 0; startFromHereVertical + i < 10 && startFromHereHorizontal + i < 10; i++) {
                if (counter == 5) {
                    break;
                } else if (board.getColorCodesForChips()[startFromHereVertical + i][startFromHereHorizontal + i] == team) {
                    counter++;
                } else {
                    counter = 0;
                }
            }
            return counter == 5;
        }
    }

    private boolean checkDiagonalRightToLeft(int team, int x, int y) {
        int counter = 0;
        int startFromHereVertical = y;
        int startFromHereHorizontal = x;
        while (startFromHereVertical > 0 && startFromHereHorizontal != 9) {
            startFromHereVertical--;
            startFromHereHorizontal++;
        }
        if ((startFromHereHorizontal < 4 && startFromHereVertical == 0)
                || (startFromHereHorizontal == 9 && startFromHereVertical > 5)) {
            return false;
        } else {
            for (int i = 0; startFromHereVertical + i < 10 && startFromHereHorizontal - i >= 0; i++) {
                if (counter == 5) {
                    break;
                } else if (board.getColorCodesForChips()[startFromHereVertical + i][startFromHereHorizontal - i] == team) {
                    counter++;
                } else {
                    counter = 0;
                }
            }
            return counter == 5;
        }
    }
}
