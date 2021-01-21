package com.testTast.Tymerlan;

import java.util.Arrays;

public class ShipsCounter {
    static int[][] ships = {
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, },
            { 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, },
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, }



    };



    public static void main(String[] args) {
        int count = 0;
        count = shipCount();
        System.out.println(count);
    }

        private static int shipCount() {
        int[][] visited = new int[10][10];
        int shipsCount = 0; //should be 9
            for (int y = 0; y < ships.length; y++) {                // Делаем перебор элементов поля
                for (int x = 0; x < ships[y].length; x++) {
                    if (ships[y][x] == 1 && visited[y][x] != 1) {
                        shipsCount++;
                    }
                    cellCheck(y, x, ships.length, ships[y].length, visited);
                }
            }
            return shipsCount;
        }



    private static void cellCheck(int j, int i, int height, int width, int [][] visited){
        if (i < 0 || j < 0 || i >= ships.length || j >= ships[0].length) {
        return; //out of bounds check
        }
        if (visited[j][i] == 1) return; //dont re-check visited cells
        visited[j][i]=1;
        if (ships[j][i]==1)    {
            cellCheck(j-1,i, height,  width, visited);
            cellCheck(j+1, i, height,  width, visited);
            cellCheck(j, i-1, height,  width, visited);
            cellCheck(j, i+1, height,  width, visited);
        }
    }
 }






















