package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class EasyAI extends Player {

    Random random;

    public EasyAI(char sign) {
        this.setSign(sign);
        this.random = new Random();
    }

    public void turn(Scanner scanner, Map map) {
        System.out.println("Making move level \"easy\"");
        randomTurn(map);
    }

    protected void randomTurn(Map map) {
        int coords;
        while (true) {
            coords = random.nextInt(9) + 1;

            if (map.getMapChar(coords - 1) == ' ') {
                map.updateMap(coords, getSign());
                break;
            }
        }
    }
}
