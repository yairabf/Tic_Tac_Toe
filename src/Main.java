import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int won = 2;
        char[][] map = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = 'd';
            }
        }
        int count = 0;
        while (count < 9) {
            int x = s.nextInt();
            int y = s.nextInt();
            if (map[x][y] == 'd') {
                if(count % 2 == 0){
                    map[x][y] = 'X';
                } else {
                    map[x][y] = 'O';
                }
            } else {
                System.out.println("Please enter other place");
                continue;
            }
            count++;
            if(count >= 4){
                won = isWon(map);
                if(won == 0 || won == 1){
                    break;
                }
            }
            printMap(map);
        }
        System.out.println(won);
    }

    private static void printMap(char[][] map) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static int isWon(char[][] map) {
        int result = checkCol(map);
        if(result == 2) {
            result = checkRow(map);
        }
        if (result == 2) {
            result = checkSlant(map);
        }
        return result;
    }

    private static int checkSlant(char[][] map) {
        if ((map[0][0] == 'O' && map[1][1] == 'O' && map[2][2] == 'O') ||
                (map[0][2] == 'O' && map[1][1] == 'O' && map[2][0] == 'O')) {
            return 0;
        }
        if ((map[0][0] == 'X' && map[1][1] == 'X' && map[2][2] == 'X') ||
                (map[0][2] == 'X' && map[1][1] == 'X' && map[2][0] == 'X')) {
            return 1;
        }
        return 2;
    }

    private static int checkRow(char[][] map) {
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == 'O' && map[1][i] == 'O' && map[2][i] == 'O') {
                return 0;
            } else if (map[0][i] == 'X' && map[1][i] == 'X' && map[2][i] == 'X') {
                return 1;
            }
        }
        return 2;
    }

    private static int checkCol(char[][] map) {
        for(int i = 0; i < 3; i++){
            if(map[i][0] == 'O' && map[i][1] == 'O' && map[i][2] == 'O'){
                return 0;
            } else if(map[i][0] == 'X' && map[i][1] == 'X' && map[i][2] == 'X') {
                return 1;
            }
        }
        return 2;
    }
}
