import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minPaint = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minPaint = Math.min(minPaint, getMinPaint(i, j));
            }
        }

        System.out.println(minPaint);
    }

    public static int getMinPaint(int x, int y) {
        int count1 = 0; //W 시작
        int count2 = 0; //B 시작

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[x + i][y + j];

                if ((i + j) % 2 == 0) {
                    if (current != 'W') count1++; 
                    if (current != 'B') count2++; 
                } else {
                    if (current != 'B') count1++;
                    if (current != 'W') count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }
}
