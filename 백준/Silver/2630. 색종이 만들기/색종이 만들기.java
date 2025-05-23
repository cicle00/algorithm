import java.util.Scanner;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 정사각형 크기

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        countColor(0, 0, N);  
        System.out.println(white);
        System.out.println(blue);
    }

    public static void countColor(int x, int y, int size) {
        if (checkSameColor(x, y, size)) {
            if (paper[x][y] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;
        countColor(x, y, newSize);                      // 왼쪽 위
        countColor(x, y + newSize, newSize);            // 오른쪽 위
        countColor(x + newSize, y, newSize);            // 왼쪽 아래
        countColor(x + newSize, y + newSize, newSize);  // 오른쪽 아래
    }

    public static boolean checkSameColor(int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
