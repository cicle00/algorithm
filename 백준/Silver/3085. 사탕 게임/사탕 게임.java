import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int max = 0;

        // 모든 위치에서 오른쪽, 아래쪽과 바꿔보기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽과 교환
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, checkMax());
                    swap(i, j, i, j + 1); // 원상복구
                }

                // 아래쪽과 교환
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, checkMax());
                    swap(i, j, i + 1, j); // 원상복구
                }
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    static int checkMax() {
        int max = 1;

        // 행 기준
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        // 열 기준
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        return max;
    }
}
