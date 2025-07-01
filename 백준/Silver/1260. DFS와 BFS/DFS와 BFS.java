import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u); 
        }

        for (int i = 1; i <= N; i++) Collections.sort(graph[i]);

        boolean[] visited = new boolean[N + 1];
        dfs(V, visited);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V, visited);
    }

    static void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }

    static void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
