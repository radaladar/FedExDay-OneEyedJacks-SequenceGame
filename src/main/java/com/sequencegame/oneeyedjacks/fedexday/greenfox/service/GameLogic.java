/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.service;

import com.sequencegame.oneeyedjacks.fedexday.greenfox.domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {

    private Board board;
    private Team greenTeam;
    private Team blueTeam;
    private Team redTeam;
    private Deck deck;
    private int numberOfTeam;
    public static int round;

    public GameLogic(int numberOfPlayer) {
        board = new Board();
        deck = new Deck();
        if (numberOfPlayer == 2) {
            greenTeam = new Team();
            greenTeam.setColorCode(1);
            greenTeam.setPlayers(new ArrayList<Player>(Arrays.asList(new Player())));
            blueTeam = new Team();
            blueTeam.setColorCode(2);
            blueTeam.setPlayers(new ArrayList<Player>(Arrays.asList(new Player())));
            numberOfTeam = 2;
        } else if (numberOfPlayer == 3) {
            greenTeam = new Team();
            greenTeam.setColorCode(1);
            greenTeam.setPlayers(new ArrayList<Player>(Arrays.asList(new Player())));
            blueTeam = new Team();
            blueTeam.setColorCode(2);
            blueTeam.setPlayers(new ArrayList<Player>(Arrays.asList(new Player())));
            redTeam = new Team();
            redTeam.setColorCode(3);
            redTeam.setPlayers(new ArrayList<Player>(Arrays.asList(new Player())));
            numberOfTeam = 3;
        }
    }

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
        if (round % numberOfTeam == 0) {
            return greenTeam;
        } else if (round % numberOfTeam == 0) {
            return blueTeam;
        } else {
            return redTeam;
        }
    }

    public boolean isThereASequenceWithTheLastChipPutDown(int teamColorCode, int x, int y) {
        return checkHorizontal(teamColorCode, y) || checkVertical(teamColorCode, x) || checkDiagonal(teamColorCode, x, y);
    }

    private boolean checkHorizontal(int teamColorCode, int y) {
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

    private boolean checkVertical(int teamColorCode, int x) {
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

    private boolean checkDiagonal(int teamColorCode, int x, int y) {
        return checkDiagonalLeftToRight(teamColorCode, x, y) || checkDiagonalRightToLeft(teamColorCode, x, y);
    }

    private boolean checkDiagonalLeftToRight(int teamColorCode, int x, int y) {
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
                } else if (board.getColorCodesForChips()[startFromHereVertical + i][startFromHereHorizontal + i] == teamColorCode) {
                    counter++;
                } else {
                    counter = 0;
                }
            }
            return counter == 5;
        }
    }

    private boolean checkDiagonalRightToLeft(int teamColorCode, int x, int y) {
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
                } else if (board.getColorCodesForChips()[startFromHereVertical + i][startFromHereHorizontal - i] == teamColorCode) {
                    counter++;
                } else {
                    counter = 0;
                }
            }
            return counter == 5;
        }
    }
}
