package tictactoe;

import java.util.Scanner;

public class MediumAI extends EasyAI {

    public MediumAI(char sign) {
        super(sign);
    }

    @Override
    public void turn(Scanner scanner, Map map) {
        System.out.println("Making move level \"medium\"");
        int turn;
        if ((turn = lastMove(map, getSign())) != -1) {
            map.updateMap(turn, getSign());
        } else if ((turn = lastMove(map, (getSign()) == 'X' ? 'O' : 'X')) != -1) {
            map.updateMap(turn, getSign());
        } else {
            randomTurn(map);
        }
    }

    private int lastMove(Map map, char sign) {
        int goal = (int)sign * 2 + 32;
        int[] line = new int[0];
        // vertical
        if (sumOfCells(map,0, 1, 2) == goal) {
            line = new int[]{0, 1, 2};
        } else if (sumOfCells(map, 3, 4, 5) == goal) {
            line = new int[]{3, 4, 5};
        } else if (sumOfCells(map, 6, 7, 8) == goal) {
            line = new int[]{6, 7, 8};
            // vertical
        } else if (sumOfCells(map, 0, 3, 6) == goal) {
            line = new int[]{0, 3, 6};
        } else if (sumOfCells(map, 1, 4, 7) == goal) {
            line = new int[]{1, 4, 7};
        } else if (sumOfCells(map, 2, 5, 8) == goal) {
            line = new int[]{2, 5, 8};
            // cross
        } else if (sumOfCells(map, 0, 4, 8) == goal) {
            line = new int[]{0, 4, 8};
        } else if (sumOfCells(map, 6, 4, 2) == goal) {
            line = new int[]{6, 4, 2};
        }
        return findEmptyCell(map, line);
    }

    private int sumOfCells(Map map, int first, int second, int third) {
        return (int)map.getMapChar(first) + (int)map.getMapChar(second) + (int)map.getMapChar(third);
    }

    private int findEmptyCell(Map map, int[] line) {
        for (int e : line) {
            if (map.getMapChar(e) == ' ')
                return e + 1;
        }
        return -1;
    }


}
