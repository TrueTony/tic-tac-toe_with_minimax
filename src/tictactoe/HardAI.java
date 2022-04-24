package tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HardAI extends MediumAI {

    private final char opponentSign;
    
    public HardAI(char sign) {
        super(sign);
        opponentSign = sign == 'X' ? 'O': 'X';
    }

    public char getOpponentSign() {
        return opponentSign;
    }

    @Override
    public void turn(Scanner scanner, Map map) {
        System.out.println("Making move level \"hard\"");
        if (openSpaces(map).size() == 9) {
            randomTurn(map);
        } else {
            map.updateMap(minimax(map, getSign())[0], getSign());
        }
    }

    private int[] minimax(Map map, char player) {
        char other_player = player == 'X' ? 'O': 'X';

        if (map.isWins(getSign())) {
            return new int[]{-1, 10};
        } else if (map.isWins(getSign() == 'X' ? 'O': 'X')) {
            return new int[]{-1, -10};
        } else if (map.isDraw()) {
            return new int[]{-1, 0};
        }

        int[] best;
        if (player == getSign()) {
            best = new int[]{-1, (int)Double.NEGATIVE_INFINITY};
        } else {
            best = new int[]{-1, (int)Double.POSITIVE_INFINITY};
        }

        for (int el: openSpaces(map)) {
            map.updateMap(el, player);
            int[] sim_score = minimax(map, other_player);

            map.updateMap(el, ' ');
            sim_score[0] = el;

            if (player == getSign()) {
                if (sim_score[1] > best[1]) {
                    best = sim_score;
                }
            } else {
                if (sim_score[1] < best[1]) {
                    best = sim_score;
                }
            }
        }
        return best;
    }

    private ArrayList<Integer> openSpaces(Map map) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            if (map.getMapChar(i) == ' ') {
                res.add(i + 1);
            }
        }
        return res;
    }
}
