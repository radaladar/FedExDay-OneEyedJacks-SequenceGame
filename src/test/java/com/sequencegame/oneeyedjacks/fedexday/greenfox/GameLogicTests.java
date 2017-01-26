/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox;

import com.sequencegame.oneeyedjacks.fedexday.greenfox.service.GameLogic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameLogicTests {
    private int[][] arrayForHorizontalTest;
    private int[][] arrayForVerticalTest;
    private int[][] arrayForDiagonalTest;

    GameLogic gameLogic;

    @Before
    public void setup() {
        gameLogic = new GameLogic(2);
        arrayForHorizontalTest = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 1, 0}
        };
        arrayForVerticalTest = new int[][]{
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 0, 1, 1, 0},
                {1, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 1, 0}
        };
        arrayForDiagonalTest = new int[][]{
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
        };
        GameLogic.round = 2;

    }

    @Test
    public void testCheckHorizontal1() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 0));
    }

    @Test
    public void testCheckHorizontal2() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 1));
    }

    @Test
    public void testCheckHorizontal3() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 2));
    }

    @Test
    public void testCheckHorizontal4() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 3));
    }

    @Test
    public void testCheckHorizontal5() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 4));
    }

    @Test
    public void testCheckHorizontal6() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 5));
    }

    @Test
    public void testCheckHorizontal7() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 6));
    }

    @Test
    public void testCheckHorizontal8() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 7));
    }

    @Test
    public void testCheckHorizontal9() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 8));
    }

    @Test
    public void testCheckHorizontal10() {
        gameLogic.getBoard().setColorCodesForChips(arrayForHorizontalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 9));
    }

    @Test
    public void testCheckVertical1() {
        gameLogic.getBoard().setColorCodesForChips(arrayForVerticalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 0));
    }

    @Test
    public void testCheckVertical2() {
        gameLogic.getBoard().setColorCodesForChips(arrayForVerticalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 1));
    }

    @Test
    public void testCheckVertical3() {
        gameLogic.getBoard().setColorCodesForChips(arrayForVerticalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 2));
    }

    @Test
    public void testCheckVertical4() {
        gameLogic.getBoard().setColorCodesForChips(arrayForVerticalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(0, 0));
    }

    @Test
    public void testCheckVertical5() {
        gameLogic.getBoard().setColorCodesForChips(arrayForVerticalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 4));
    }

    @Test
    public void testCheckVertical6() {
        gameLogic.getBoard().setColorCodesForChips(arrayForVerticalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(5, 5));
    }

    @Test
    public void testCheckVertical7() {
        gameLogic.getBoard().setColorCodesForChips(arrayForVerticalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 6));
    }

    @Test
    public void testCheckVertical10() {
        gameLogic.getBoard().setColorCodesForChips(arrayForVerticalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 9));
    }

    @Test
    public void testCheckDiagonal1() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(0, 0));
    }

    @Test
    public void testCheckDiagonal2() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(1, 3));
    }

    @Test
    public void testCheckDiagonal3() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(false, gameLogic.isThereASequenceWithTheLastChipPutDown(0, 9));
    }

    @Test
    public void testCheckDiagonal4() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(3, 5));
    }

    @Test
    public void testCheckDiagonal5() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(2, 4));
    }

    @Test
    public void testCheckDiagonal6() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(5, 7));
    }

    @Test
    public void testCheckDiagonal7() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(5, 9));
    }

    @Test
    public void testCheckDiagonal8() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(6, 0));
    }

    @Test
    public void testCheckDiagonal9() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(5, 0));
    }

    @Test
    public void testCheckDiagonal10() {
        gameLogic.getBoard().setColorCodesForChips(arrayForDiagonalTest);
        Assert.assertEquals(true, gameLogic.isThereASequenceWithTheLastChipPutDown(4, 0));
    }
}
