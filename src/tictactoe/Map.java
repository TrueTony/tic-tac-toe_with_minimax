package tictactoe;

import java.util.Arrays;

public class Map {

    public int length;
    char[] map;

    public Map() {
        length = 9;
        map = new char[9];
    }

    public void initializationMap() {
        Arrays.fill(map, ' ');
    }

    public char getMapChar(int position) {
        return map[position];
    }

    public void updateMap(int coords, char playerSymbol) {
        map[coords - 1] = playerSymbol;
    }

    public void printMap() {
        System.out.println("---------");
        for (int i = 0; i < map.length; i++) {
            if (i == 0 || i == 3 || i == 6) {
                System.out.print("| ");
            }
            System.out.print(map[i] + " ");
            if (i == 2 || i == 5 || i == 8) {
                System.out.print("|");
                System.out.println();
            }
        }
        System.out.println("---------");
    }

    public boolean isWins(char s) {
        if (getMapChar(0) == s && getMapChar(1) == s && getMapChar(2) == s)
            return true;
        if (getMapChar(3) == s && getMapChar(4) == s && getMapChar(5) == s)
            return true;
        if (getMapChar(6) == s && getMapChar(7) == s && getMapChar(8) == s)
            return true;
        if (getMapChar(0) == s && getMapChar(3) == s && getMapChar(6) == s)
            return true;
        if (getMapChar(1) == s && getMapChar(4) == s && getMapChar(7) == s)
            return true;
        if (getMapChar(2) == s && getMapChar(5) == s && getMapChar(8) == s)
            return true;
        if (getMapChar(0) == s && getMapChar(4) == s && getMapChar(8) == s)
            return true;
        return (getMapChar(6) == s && getMapChar(4) == s && getMapChar(2) == s);
    }

    public boolean isDraw() {
        for (int i = 0; i < length; i++) {
                if (getMapChar(i) == ' ') {
                    return false;
            }
        }
        return true;
    }
}
