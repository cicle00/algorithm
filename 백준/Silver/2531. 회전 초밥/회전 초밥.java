import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] belt = new int[N];
        
        for(int i=0;i<N;i++) {
        	belt[i] = Integer.parseInt(br.readLine());
        }
        
        int[] count = new int[d+1]; 
        int kind = 0;
        
        for (int i=0;i<k;i++) {
            if (count[belt[i]] == 0) kind++;
            count[belt[i]]++;
        }
        
        int max = kind;
        if (count[c] == 0) max++;
        
        for(int i=1;i<N;i++) {
        	int remove = belt[(i-1)%N];
        	int add = belt[(i+k-1)%N];
        	
        	count[remove]--;
        	if(count[remove]==0) kind--;
        	
        	if(count[add]==0) kind++;
        	count[add]++;
        	
        	int totalKinds = kind;
        	if(count[c]==0) totalKinds++;

        	max = Math.max(max, totalKinds);
        }
        
        System.out.println(max);
	}
}
