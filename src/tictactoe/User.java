package tictactoe;

import java.util.Scanner;

public class User extends Player {

    public User(char sign) {
        this.setSign(sign);
    }

    public void turn(Scanner scanner, Map map) {
        System.out.println("Enter the coordinates: ");
        map.updateMap(validTurn(scanner, map), getSign());
    }

    private int validTurn(Scanner scanner, Map map) {
        int[] resDouble = new int[]{0, 0};
        int res;
        while (true) {
            String[] inc = scanner.nextLine().strip().split(" ");
            if (inc.length != 2) {
                System.out.println("Enter two numbers by space");
                continue;
            }
            int i;
            for (i = 0; i < 2; i++) {
                try {
                    resDouble[i] = Integer.parseInt(inc[i]);
                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                    break;
                }
                if (resDouble[i] < 1 || resDouble[i] > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    break;
                }
            }
            if (resDouble[0] == 1) {
                res = resDouble[1];
            } else if (resDouble[0] == 2) {
                res = resDouble[1] + 3;
            } else {
                res = resDouble[1] + 6;
            }
            if (i == 2 && map.getMapChar(res - 1) != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            if (i == 2) {
                break;
            }
        }
        return res;
    }
}
