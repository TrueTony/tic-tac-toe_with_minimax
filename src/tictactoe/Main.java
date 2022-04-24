package tictactoe;

import java.util.*;

public class Main {

    private static final List<String> VALID_PLAYERS = Arrays.asList("user", "easy", "medium", "hard");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map map = new Map();
        menu(scanner, map);
        scanner.close();
    }

    public static void menu(Scanner scanner, Map map) {
        String inp;
        while (true) {
            inp = scanner.nextLine();
            if (inp.split(" ").length == 1 && "exit".equals(inp)) {
                break;
            } else if (inp.split(" ").length == 3
                    && "start".equals(inp.split(" ")[0])
                    && VALID_PLAYERS.contains(inp.split(" ")[1])
                    && VALID_PLAYERS.contains(inp.split(" ")[2])) {
                Player one = createPlayer(inp.split(" ")[1], 'X');
                Player two = createPlayer(inp.split(" ")[2], 'O');
                map.initializationMap();
                map.printMap();
                gameBody(scanner, map, one, two);
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    public static Player createPlayer(String player, char sign) {
        if ("user".equals(player)) {
            return new User(sign);
        } else if ("easy".equals(player)) {
            return new EasyAI(sign);
        } else if ("medium".equals(player)) {
            return new MediumAI(sign);
        } else if ("hard".equals(player)) {
            return new HardAI(sign);
        } else {
            return null;
        }
    }

    public static void gameBody(Scanner scanner, Map map, Player one, Player two) {
        while (true) {
            one.turn(scanner, map);
            if (isGameEnd(map, one.getSign())) {
                 break;
            }
            map.printMap();
            two.turn(scanner, map);
            if (isGameEnd(map, two.getSign())) {
                break;
            }
            map.printMap();
        }
        map.printMap();
    }

    public static boolean isGameEnd(Map map, char sign) {
        if (map.isWins(sign)) {
            System.out.println(sign + " wins");
            return true;
        } else if (map.isDraw()) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }

}
