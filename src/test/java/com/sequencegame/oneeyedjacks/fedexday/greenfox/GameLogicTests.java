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

    @Before
    public void setup(){
        arrayForHorizontalTest = new int[][] {
                {1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,0,0,0,0,0},
                {0,0,0,0,0,1,1,1,1,1},
                {1,1,1,1,0,1,1,1,1,0},
                {0,0,1,1,1,1,1,1,1,0},
                {0,0,0,1,0,0,1,1,1,0},
                {1,0,1,1,0,1,0,1,0,1},
                {0,0,0,0,0,1,0,1,0,1},
                {1,1,0,0,1,0,1,0,1,0}
        };
        arrayForVerticalTest = new int[][] {
                {1,0,1,0,1,0,0,1,0,1},
                {1,0,1,0,1,0,0,0,0,1},
                {1,0,1,0,1,1,0,1,0,0},
                {1,0,1,0,1,1,1,1,0,0},
                {1,0,1,0,0,1,0,0,0,1},
                {1,0,0,1,1,1,0,1,1,0},
                {1,0,0,1,1,1,1,0,0,1},
                {1,0,0,1,1,1,1,1,1,0},
                {1,0,0,1,1,1,0,0,0,1},
                {1,0,0,1,0,0,0,1,1,0}
        };
        arrayForDiagonalTest = new int[][] {
                {0,0,0,0,1,1,1,0,0,0},
                {0,0,0,1,0,1,1,0,0,0},
                {0,0,1,0,1,0,0,1,1,0},
                {0,1,0,1,0,0,0,1,1,0},
                {1,0,1,0,0,0,1,0,0,1},
                {0,0,0,1,0,1,0,0,0,1},
                {0,0,0,0,1,0,0,0,1,0},
                {0,0,0,0,0,1,0,1,0,0},
                {0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,1,0,0,0,0}
        };

    }

    @Test
    public void testCheckHorizontal1(){
        Assert.assertEquals(true, GameLogic.checkHorizontal(1,arrayForHorizontalTest,0));
    }
    @Test
    public void testCheckHorizontal2(){
        Assert.assertEquals(false, GameLogic.checkHorizontal(1,arrayForHorizontalTest,1));
    }
    @Test
    public void testCheckHorizontal3(){
        Assert.assertEquals(true, GameLogic.checkHorizontal(1,arrayForHorizontalTest,2));
    }
    @Test
    public void testCheckHorizontal4(){
        Assert.assertEquals(true, GameLogic.checkHorizontal(1,arrayForHorizontalTest,3));
    }
    @Test
    public void testCheckHorizontal5(){
        Assert.assertEquals(false, GameLogic.checkHorizontal(1,arrayForHorizontalTest,4));
    }
    @Test
    public void testCheckHorizontal6(){
        Assert.assertEquals(true, GameLogic.checkHorizontal(1,arrayForHorizontalTest,5));
    }
    @Test
    public void testCheckHorizontal7(){
        Assert.assertEquals(false, GameLogic.checkHorizontal(1,arrayForHorizontalTest,6));
    }
    @Test
    public void testCheckHorizontal8(){
        Assert.assertEquals(false, GameLogic.checkHorizontal(1,arrayForHorizontalTest,7));
    }
    @Test
    public void testCheckHorizontal9(){
        Assert.assertEquals(false, GameLogic.checkHorizontal(1,arrayForHorizontalTest,8));
    }
    @Test
    public void testCheckHorizontal10(){
        Assert.assertEquals(false, GameLogic.checkHorizontal(1,arrayForHorizontalTest,9));
    }
    @Test
    public void testCheckVertical1(){
        Assert.assertEquals(true, GameLogic.checkVertical(1,arrayForVerticalTest,0));
    }
    @Test
    public void testCheckVertical2(){
        Assert.assertEquals(false, GameLogic.checkVertical(1,arrayForVerticalTest,1));
    }
    @Test
    public void testCheckVertical3(){
        Assert.assertEquals(true, GameLogic.checkVertical(1,arrayForVerticalTest,2));
    }
    @Test
    public void testCheckVertical4(){
        Assert.assertEquals(true, GameLogic.checkVertical(1,arrayForVerticalTest,3));
    }
    @Test
    public void testCheckVertical5(){
        Assert.assertEquals(false, GameLogic.checkVertical(1,arrayForVerticalTest,4));
    }
    @Test
    public void testCheckVertical6(){
        Assert.assertEquals(true, GameLogic.checkVertical(1,arrayForVerticalTest,5));
    }
    @Test
    public void testCheckVertical7(){
        Assert.assertEquals(false, GameLogic.checkVertical(1,arrayForVerticalTest,6));
    }
    @Test
    public void testCheckVertical8(){
        Assert.assertEquals(false, GameLogic.checkVertical(1,arrayForVerticalTest,7));
    }
    @Test
    public void testCheckVertical9(){
        Assert.assertEquals(false, GameLogic.checkVertical(1,arrayForVerticalTest,8));
    }
    @Test
    public void testCheckVertical10(){
        Assert.assertEquals(false, GameLogic.checkVertical(1,arrayForVerticalTest,9));
    }
    @Test
    public void testCheckDiagonal1(){
        Assert.assertEquals(false, GameLogic.checkDiagonal(1, arrayForDiagonalTest,0,0));
    }
    @Test
    public void testCheckDiagonal2(){
        Assert.assertEquals(true, GameLogic.checkDiagonal(1, arrayForDiagonalTest,1,3));
    }
    @Test
    public void testCheckDiagonal3(){
        Assert.assertEquals(false, GameLogic.checkDiagonal(1, arrayForDiagonalTest,0,9));
    }
    @Test
    public void testCheckDiagonal4(){
        Assert.assertEquals(true, GameLogic.checkDiagonal(1, arrayForDiagonalTest,3,5));
    }
    @Test
    public void testCheckDiagonal5(){
        Assert.assertEquals(true, GameLogic.checkDiagonal(1, arrayForDiagonalTest,2,4));
    }
    @Test
    public void testCheckDiagonal6(){
        Assert.assertEquals(true, GameLogic.checkDiagonal(1, arrayForDiagonalTest,5,7));
    }
    @Test
    public void testCheckDiagonal7(){
        Assert.assertEquals(true, GameLogic.checkDiagonal(1, arrayForDiagonalTest,5,9));
    }
    @Test
    public void testCheckDiagonal8(){
        Assert.assertEquals(true, GameLogic.checkDiagonal(1, arrayForDiagonalTest,6,0));
    }
    @Test
    public void testCheckDiagonal9(){
        Assert.assertEquals(true, GameLogic.checkDiagonal(1, arrayForDiagonalTest,5,0));
    }
    @Test
    public void testCheckDiagonal10(){
        Assert.assertEquals(true, GameLogic.checkDiagonal(1, arrayForDiagonalTest,4,0));
    }
}
