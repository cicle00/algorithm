import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> S = new HashSet<>();
        for(int i=0;i<N;i++) {
        	S.add(br.readLine());
        }
        
        int count = 0;
        for(int i=0;i<M;i++) {
        	String check = br.readLine();
        	if(S.contains(check)) count++;
        }
        
        System.out.println(count);
        
	}
}
