import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            String prefix = br.readLine();
            String candidate = set.ceiling(prefix);
            
            if (candidate != null && candidate.startsWith(prefix)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
