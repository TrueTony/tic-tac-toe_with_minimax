package tictactoe;

import java.util.Scanner;

public abstract class Player {

    private char sign;

    public abstract void turn(Scanner scanner, Map map);

    public void setSign(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

}
