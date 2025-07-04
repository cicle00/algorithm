import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lectures[i]);
            sum += lectures[i];
        }

        int left = max;
        int right = sum;
        int result = sum;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (countBluerays(lectures, mid) <= M) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static int countBluerays(int[] lectures, int capacity) {
        int count = 1, sum = 0;
        for (int len : lectures) {
            if (sum + len > capacity) {
                count++;
                sum = len;
            } else {
                sum += len;
            }
        }
        return count;
    }
}
