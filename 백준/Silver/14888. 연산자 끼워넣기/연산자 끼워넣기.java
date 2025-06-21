import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] ops = new int[4]; // +, -, *, /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            ops[i] = Integer.parseInt(st.nextToken());

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int result) {
        if (idx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--; 
                int next = calculate(result, nums[idx], i);
                dfs(idx + 1, next);
                ops[i]++; 
            }
        }
    }

    static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            case 3: return a < 0 ? -(-a / b) : a / b;
            default: return 0;
        }
    }
}
