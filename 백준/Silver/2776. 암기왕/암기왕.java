import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0;t<T;t++) {
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> note1 = new HashSet<>();
        for(int i=0;i<N;i++) {
        	note1.add(Integer.parseInt(st.nextToken()));
        }
       
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++) {
        	int note2 = Integer.parseInt(st.nextToken());
        	int exist = 0;
        	if(note1.contains(note2)) exist = 1;
        	sb.append(exist).append("\n");
        }

        }
        System.out.println(sb);
	}
}
