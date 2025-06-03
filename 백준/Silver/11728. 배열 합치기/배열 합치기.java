import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
        	B[i] = Integer.parseInt(st.nextToken());
    	}
        
        List<Integer> arr = new ArrayList<>();
        
        int a=0; 
        int b=0;
        
        while(a<N && b<M) {
        	if(A[a]>B[b]) {
        		arr.add(B[b++]);
        	}else{
        		arr.add(A[a++]);
        	}
        }
        
        while(a<N) arr.add(A[a++]);
        while(b<M) arr.add(B[b++]);
        
        StringBuilder sb = new StringBuilder();
        for(int k:arr) {
        	sb.append(k);
        	sb.append(" ");
        }
        
        System.out.println(sb);
        
    }
}
