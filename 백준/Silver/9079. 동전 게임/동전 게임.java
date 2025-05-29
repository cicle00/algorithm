import java.io.*;
import java.util.*;

public class Main {
    static int[][] ops = {
        {0, 1, 2}, //0행
        {3, 4, 5}, //1행
        {6, 7, 8}, //2행
        {0, 3, 6}, //0열
        {1, 4, 7}, //1열
        {2, 5, 8}, //2열
        {0, 4, 8}, //↘ 대각선
        {2, 4, 6}  //↙ 대각선
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int state = 0;

            for (int i = 0; i < 3; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    if (line[j].equals("T")) {
                        int idx = i * 3 + j;
                        state |= (1 << idx); 
                    }
                }
            }

            System.out.println(bfs(state));
        }
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[512]; //2^9 = 512
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int state = now[0];
            int depth = now[1];

            if (state == 0 || state == 511) {
                return depth;
            }

            for (int[] op : ops) {
                int next = applyOp(state, op);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                }
            }
        }

        return -1; 
    }

    static int applyOp(int state, int[] op) {
        for (int idx : op) {
            state ^= (1 << idx); 
        }
        return state;
    }
}
