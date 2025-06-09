import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] S;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = new int[N][N];
        visited = new boolean[N];
        
        for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		S[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        combination(0,0);
        System.out.println(min);
        
    }

	private static void combination(int idx, int pickedNum) {
		if(pickedNum == N/2) {
			calcDiff();
			return;
		}
		
		for(int i=idx;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i+1,pickedNum+1);
				visited[i] = false;
			}
		}
		
	}

	private static void calcDiff() {
		int start = 0;
		int link = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(visited[i] && visited[j]) {
					start+=S[i][j]+S[j][i];
				}else if(!visited[i] && !visited[j]) {
					link+=S[i][j]+S[j][i];
				}
			}
		}
		
		min = Math.min(min, Math.abs(start-link));
		
	}
}
