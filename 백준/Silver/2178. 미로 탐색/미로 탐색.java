import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 범위 벗어나면 패스
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 벽이거나 방문한 곳이면 패스
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                // 다음 칸으로 이동 (현재 값 + 1)
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                map[nx][ny] = map[p.x][p.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0); // 시작점 (0, 0)
        System.out.println(map[N - 1][M - 1]); // 도착점 값 출력
    }
}
