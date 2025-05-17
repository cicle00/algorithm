import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
        }

        M = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(0, max));
    }

    static int binarySearch(int start, int end) {
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int total = 0;

            for (int i = 0; i < N; i++) {
                total += Math.min(budget[i], mid);
            }

            if (total <= M) {
                result = mid;     
                start = mid + 1;   
            } else {
                end = mid - 1;   
            }
        }

        return result;
    }
}
