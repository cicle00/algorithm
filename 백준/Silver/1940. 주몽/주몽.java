import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] S = new int[N];
        for(int i=0;i<N;i++) {
        	S[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(S);
        
        int count = 0;
        
        int start = 0;
        int end = N-1;
        
        while(start<end) {
        	int sum = 0;
        	sum = S[start]+S[end];
        	
        	if(sum>M) end--;
        	else if(sum<M) start++;
        	else {
        		start++;
        		end--;
        		count++;
        	}
        }
        
        System.out.println(count);
        
	}
}
