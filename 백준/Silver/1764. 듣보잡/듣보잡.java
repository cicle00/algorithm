import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> neverHeard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            neverHeard.add(br.readLine());
        }

        TreeSet<String> unknown = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (neverHeard.contains(name)) {
                unknown.add(name);
            }
        }
        
        System.out.println(unknown.size());
        for (String name : unknown) {
            System.out.println(name); 
        }
    }
}
