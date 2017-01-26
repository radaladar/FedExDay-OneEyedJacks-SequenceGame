/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.service;

public class GameLogic {

    public boolean isThereASequenceWithTheLastChipPutDown(int team, int[][] array, int x, int y){
        return checkHorizontal(team, array, y) || checkVertical(team, array, x) || checkDiagonal(team, array, x, y);
    }

    public static boolean checkHorizontal(int team, int[][] array, int y) {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (counter == 5) {
                break;
            } else if (array[y][i] == team) {
                counter++;
            }  else {
                counter = 0;
            }
        }
        return counter == 5;
    }
    public static boolean checkVertical(int team, int[][]array, int x) {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (counter == 5) {
                break;
            } else if (array[i][x] == team) {
                counter++;
            }  else {
                counter = 0;
            }
        }
        return counter == 5;
    }
    public static boolean checkDiagonal(int team, int[][]array, int x, int y){
        return checkDiagonalLeftToRight(team, array, x, y) || checkDiagonalRightToLeft(team, array, x, y);
    }

   private static boolean checkDiagonalLeftToRight(int team, int[][]array, int x, int y) {
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
            for (int i = 0; startFromHereVertical + i < 10 && startFromHereHorizontal + i < 10 ; i++) {
                if (counter == 5) {
                    break;
                } else if (array[startFromHereVertical + i][startFromHereHorizontal + i] == team) {
                    counter++;
                }  else {
                    counter = 0;
                }
            }
            return counter == 5;
        }
   }

   private static boolean checkDiagonalRightToLeft(int team, int[][]array, int x, int y) {
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
           for (int i = 0; startFromHereVertical + i < 10 && startFromHereHorizontal - i >= 0 ; i++) {
               if (counter == 5) {
                   break;
               } else if (array[startFromHereVertical + i][startFromHereHorizontal - i] == team) {
                   counter++;
               }  else {
                   counter = 0;
               }
           }
           return counter == 5;
       }
   }
}
