import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] S;
	static List<Integer> groupA = new ArrayList<>();
	static List<Integer> groupB = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = new int[N][N];
        
        for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		S[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        divide(0);
    
        System.out.println(min);
        
    }

	private static void divide(int idx) {
		
		if (idx == N) {
            if (!groupA.isEmpty() && !groupB.isEmpty()) {
                calcDiff();
            }
            return;
        }
		
		 groupA.add(idx);
	     divide(idx + 1);
	     groupA.remove(groupA.size() - 1);
	     
	     groupB.add(idx);
	     divide(idx + 1);
	     groupB.remove(groupB.size() - 1);
		
	}

	private static void calcDiff() {
		int sumA = 0;
		int sumB = 0;
		for(int i=0;i<groupA.size();i++) {
			for(int j=0;j<groupA.size();j++) {
				if (i == j) continue;
	            int a = groupA.get(i);
	            int b = groupA.get(j);
	            sumA += S[a][b];
			}
		}
		
		for (int i = 0; i < groupB.size(); i++) {
            for (int j = 0; j < groupB.size(); j++) {
                if (i == j) continue;
                int a = groupB.get(i);
                int b = groupB.get(j);
                sumB += S[a][b];
            }
        }
		
		min = Math.min(min, Math.abs(sumA - sumB));
		
	}
}
