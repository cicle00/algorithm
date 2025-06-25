import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int L;
	static int[] pipe;
	static int tape;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        pipe = new int[N];
        
		st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		pipe[i] = Integer.parseInt(st.nextToken());;
    	}
    	
    	Arrays.sort(pipe);
    	tape = 0;
    	
    	int i = 0;
    	
    	while(i<N) {
    		int start = pipe[i];
    		tape++;
    		double end = start + L - 0.5; 
    		
    		while(i<N && pipe[i] <= end) {
    			i++;
    		}
    	}
    	
    	
    	System.out.println(tape);
        
    }
}
