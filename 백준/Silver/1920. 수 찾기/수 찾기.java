import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] numN;
	static int[] numM;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        numN = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	numN[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(numN);
        
        M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        numM = new int[M];
        
        for(int i=0;i<M;i++) {
        	numM[i] = Integer.parseInt(st.nextToken());
        }
        
        find();
		
	}

	private static void find() {
		for(int i=0;i<M;i++) {
			int start = 0;
			int end = N-1;
			int result = 0;
			int target = numM[i];
			while(start<=end) {
				int mid = (start+end)/2;
				if(target>numN[mid]) start = mid+1;
				else if(target<numN[mid]) end = mid-1;
				else {
                    result = 1; 
                    break;
                }
			}
			System.out.println(result);
		}
		
	}
}
