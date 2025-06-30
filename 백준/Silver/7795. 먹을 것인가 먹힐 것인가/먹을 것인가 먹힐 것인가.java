import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0;t<T;t++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        
	        int[] A = new int[N];
	        int[] B = new int[M];
	        
	        st = new StringTokenizer(br.readLine());
	        for(int i=0;i<N;i++) {
	        	A[i] = Integer.parseInt(st.nextToken());
	        }
	        st = new StringTokenizer(br.readLine());
	        for(int i=0;i<M;i++) {
	        	B[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        Arrays.sort(B);
	        
	        int count = 0;
	        
	        for(int i=0;i<N;i++) {
	        	count += binary(B, A[i]);
	        	
	        }
	        
	        System.out.println(count);
        }
	}

	private static int binary(int[] b, int val) {
		int start = 0;
		int end = b.length;
		
		while(start<end) {
			int mid = (start + end) / 2;
			if(b[mid]<val) start = mid + 1;
			else end = mid;
		}
		return start;
	}
}
