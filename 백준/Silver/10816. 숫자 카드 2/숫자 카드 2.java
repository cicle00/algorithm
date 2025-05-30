import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> nums = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums.put(num, nums.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(nums.getOrDefault(num, 0)).append(' ');
        }
        
        System.out.println(sb.toString());
    }
}
