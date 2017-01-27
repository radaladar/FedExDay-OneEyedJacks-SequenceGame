/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.service;

import com.sequencegame.oneeyedjacks.fedexday.greenfox.domain.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
public class GameLogic {

    private Board board;
    private Team greenTeam;
    private Team blueTeam;
    private Team redTeam;
    private Deck deck;
    private int numberOfTeam;
    private int[] lastMove;
    public static int round = 0;
    private int[][] tempSequenceHolderForPlayer1;
    private int[][] tempSequenceHolderForPlayer2;

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

    public boolean isWon() {
        placeChipsOnCorners();
        if (isThereASequenceWithTheLastChipPutDown(lastMove[0], lastMove[1])) {
            getActiveTeam().increaseSequence();
        }
        clearCorners();
        if (numberOfTeam == 2) {
            return getActiveTeam().getSequence() == 2;
        } else {
            return getActiveTeam().getSequence() == 1;
        }
    }

    public Card playCard(int index) {
        Player activePlayer = getActiveTeam().getActivePlayer();
        Card cardPlayed = activePlayer.playCard(index);
        if (activePlayer.getNumberOfCardsInHand() < 6 && deck.getNumberOfCardsRemaining() > 0) {
            activePlayer.addNewCardToHand(deck.drawCard());
        }
        return cardPlayed;
    }

    public void dumpCard(int index) {
        if (isDumpingDeadCardAllowed(index)) {
            Card cardRemoved = playCard(index);
        }
    }

    public void placeChip(int x, int y) {
        board.placeChip(x, y, getActiveTeam().getColorCode());
        lastMove = new int[]{x, y};
    }

    public void removeChip(int x, int y) {
        board.placeChip(x, y, 0);
        lastMove = new int[]{x, y};
    }

    private void placeChipsOnCorners() {
        board.placeChip(0, 0, getActiveTeam().getColorCode());
        board.placeChip(0, 9, getActiveTeam().getColorCode());
        board.placeChip(9, 0, getActiveTeam().getColorCode());
        board.placeChip(9, 9, getActiveTeam().getColorCode());
    }

    private void clearCorners() {
        board.placeChip(0, 0, 0);
        board.placeChip(0, 9, 0);
        board.placeChip(9, 0, 0);
        board.placeChip(9, 9, 0);
    }

    private boolean isDumpingDeadCardAllowed(int index) {
        Card card = getActiveTeam().getActivePlayer().getHand().get(index);
        int[][] placesTocheck = board.findCardOnBoard(card.toString());
        return board.isCardisOccupied(placesTocheck[0][0], placesTocheck[0][1]) && board.isCardisOccupied(placesTocheck[1][0], placesTocheck[1][1]);
    }

    private Team getActiveTeam() {
        if (round % numberOfTeam == 0) {
            return greenTeam;
        } else if (round % numberOfTeam == 1) {
            return blueTeam;
        } else {
            return redTeam;
        }
    }

    public boolean isThereASequenceWithTheLastChipPutDown(int x, int y) {
        return checkHorizontal(y) || checkVertical(x) || checkDiagonal(x, y);
    }

    private boolean checkHorizontal(int y) {
        int counter = 0;
        int[][] localSequenceHolder = new int[5][2];
        for (int i = 0; i < 10; i++) {
            if (counter == 5) {
                if (numberOfTeam == 2) {
                    if (getActiveTeam().getColorCode() == 1 && getActiveTeam().getSequence() == 0) {
                        tempSequenceHolderForPlayer1 = localSequenceHolder;
                    } else if (getActiveTeam().getColorCode() == 1 && getActiveTeam().getSequence() == 1) {
                        return !Arrays.equals(localSequenceHolder, tempSequenceHolderForPlayer1);
                    }
                    if (getActiveTeam().getColorCode() == 2 && getActiveTeam().getSequence() == 0) {
                        tempSequenceHolderForPlayer2 = localSequenceHolder;
                    } else if (getActiveTeam().getColorCode() == 2 && getActiveTeam().getSequence() == 1) {
                        return !Arrays.equals(localSequenceHolder, tempSequenceHolderForPlayer2);
                    }
                }
                break;
            } else if (board.getColorCodesForChips()[y][i] == getActiveTeam().getColorCode()) {
                localSequenceHolder[counter] = new int[]{y, i};
                counter++;
            } else {
                counter = 0;
                Arrays.fill(localSequenceHolder, null);
            }
        }
        return counter == 5;
    }

    private boolean checkVertical(int x) {
        int counter = 0;
        int[][] localSequenceHolder = new int[5][2];
        for (int i = 0; i < 10; i++) {
            if (counter == 5) {
                if (numberOfTeam == 2) {
                    if (getActiveTeam().getColorCode() == 1 && getActiveTeam().getSequence() == 0) {
                        tempSequenceHolderForPlayer1 = localSequenceHolder;
                    } else if (getActiveTeam().getColorCode() == 1 && getActiveTeam().getSequence() == 1) {
                        return !Arrays.equals(localSequenceHolder, tempSequenceHolderForPlayer1);
                    }
                    if (getActiveTeam().getColorCode() == 2 && getActiveTeam().getSequence() == 0) {
                        tempSequenceHolderForPlayer2 = localSequenceHolder;
                    } else if (getActiveTeam().getColorCode() == 2 && getActiveTeam().getSequence() == 1) {
                        return !Arrays.equals(localSequenceHolder, tempSequenceHolderForPlayer2);
                    }
                }
                break;
            } else if (board.getColorCodesForChips()[i][x] == getActiveTeam().getColorCode()) {
                localSequenceHolder[counter] = new int[]{i, x};
                counter++;
            } else {
                counter = 0;
                Arrays.fill(localSequenceHolder, null);
            }
        }
        return counter == 5;
    }

    private boolean checkDiagonal(int x, int y) {
        return checkDiagonalLeftToRight(x, y) || checkDiagonalRightToLeft(x, y);
    }

    private boolean checkDiagonalLeftToRight(int x, int y) {
        int counter = 0;
        int startFromHereVertical = y;
        int startFromHereHorizontal = x;
        int[][] localSequenceHolder = new int[5][2];
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
                    if (numberOfTeam == 2) {
                        if (getActiveTeam().getColorCode() == 1 && getActiveTeam().getSequence() == 0) {
                            tempSequenceHolderForPlayer1 = localSequenceHolder;
                        } else if (getActiveTeam().getColorCode() == 1 && getActiveTeam().getSequence() == 1) {
                            return !Arrays.equals(localSequenceHolder, tempSequenceHolderForPlayer1);
                        }
                        if (getActiveTeam().getColorCode() == 2 && getActiveTeam().getSequence() == 0) {
                            tempSequenceHolderForPlayer2 = localSequenceHolder;
                        } else if (getActiveTeam().getColorCode() == 2 && getActiveTeam().getSequence() == 1) {
                            return !Arrays.equals(localSequenceHolder, tempSequenceHolderForPlayer2);
                        }
                    }
                    break;
                } else if (board.getColorCodesForChips()[startFromHereVertical + i][startFromHereHorizontal + i] == getActiveTeam().getColorCode()) {
                    localSequenceHolder[counter] = new int[]{startFromHereVertical + i, startFromHereHorizontal + i};
                    counter++;
                } else {
                    counter = 0;
                    Arrays.fill(localSequenceHolder, null);
                }
            }
            return counter == 5;
        }
    }

    private boolean checkDiagonalRightToLeft(int x, int y) {
        int counter = 0;
        int startFromHereVertical = y;
        int startFromHereHorizontal = x;
        int[][] localSequenceHolder = new int[5][2];
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
                    if (numberOfTeam == 2) {
                        if (getActiveTeam().getColorCode() == 1 && getActiveTeam().getSequence() == 0) {
                            tempSequenceHolderForPlayer1 = localSequenceHolder;
                        } else if (getActiveTeam().getColorCode() == 1 && getActiveTeam().getSequence() == 1) {
                            return !Arrays.equals(localSequenceHolder, tempSequenceHolderForPlayer1);
                        }
                        if (getActiveTeam().getColorCode() == 2 && getActiveTeam().getSequence() == 0) {
                            tempSequenceHolderForPlayer2 = localSequenceHolder;
                        } else if (getActiveTeam().getColorCode() == 2 && getActiveTeam().getSequence() == 1) {
                            return !Arrays.equals(localSequenceHolder, tempSequenceHolderForPlayer2);
                        }
                    }
                    break;
                } else if (board.getColorCodesForChips()[startFromHereVertical + i][startFromHereHorizontal - i] == getActiveTeam().getColorCode()) {
                    localSequenceHolder[counter] = new int[]{startFromHereVertical + i, startFromHereHorizontal - i};
                    counter++;
                } else {
                    counter = 0;
                }
            }
            return counter == 5;
        }
    }
}
