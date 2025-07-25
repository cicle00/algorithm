import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] input, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  
        M = Integer.parseInt(st.nextToken());  

        input = new int[N];       
        result = new int[M];      
        visited = new boolean[N]; 

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input); 

        dfs(0);
        System.out.print(sb.toString());
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = input[i];
                dfs(depth + 1);
                visited[i] = false; 
            }
        }
    }
}
