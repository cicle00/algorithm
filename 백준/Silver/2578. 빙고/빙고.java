import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[5][5];
        boolean[][] marked = new boolean[5][5];
        Map<Integer, int[]> positionMap = new HashMap<>();

        // 빙고판 입력 및 위치 매핑
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num = sc.nextInt();
                board[i][j] = num;
                positionMap.put(num, new int[]{i, j});
            }
        }

        int count = 0;
        boolean bingoAchieved = false;

        // 사회자가 부르는 숫자 처리
        for (int i = 0; i < 5 && !bingoAchieved; i++) {
            for (int j = 0; j < 5 && !bingoAchieved; j++) {
                int calledNum = sc.nextInt();
                count++;
                int[] pos = positionMap.get(calledNum);
                marked[pos[0]][pos[1]] = true;

                if (count >= 12 && checkBingo(marked) >= 3) {
                    System.out.println(count);
                    bingoAchieved = true;
                }
            }
        }
        sc.close();
    }

    // 빙고 줄 수 계산
    static int checkBingo(boolean[][] marked) {
        int bingoCount = 0;

        // 가로 체크
        for (int i = 0; i < 5; i++) {
            boolean rowComplete = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    rowComplete = false;
                    break;
                }
            }
            if (rowComplete) bingoCount++;
        }

        // 세로 체크
        for (int j = 0; j < 5; j++) {
            boolean colComplete = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    colComplete = false;
                    break;
                }
            }
            if (colComplete) bingoCount++;
        }

        // 대각선 체크
        boolean diag1 = true;
        boolean diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) diag1 = false;
            if (!marked[i][4 - i]) diag2 = false;
        }
        if (diag1) bingoCount++;
        if (diag2) bingoCount++;

        return bingoCount;
    }
}
