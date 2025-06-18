import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] paper;
	static int countM1 = 0;
	static int count0 = 0;
	static int count1 = 0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];
        
        for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		paper[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        cutPaper(0,0,N);
        System.out.println(countM1);
        System.out.println(count0);
        System.out.println(count1);
        
    }

	

	private static void cutPaper(int x, int y, int size) {
		if(checkNum(x, y, size)) {
			if(paper[x][y]==1) count1++;
			else if(paper[x][y]==0) count0++;
			else countM1++;
			return;
		}
		
		int newSize = size/3;
		
		cutPaper(x, y, newSize);
		cutPaper(x, y + newSize, newSize);
		cutPaper(x, y + 2*newSize, newSize);
		cutPaper(x + newSize, y, newSize);
		cutPaper(x + newSize, y + newSize, newSize);
		cutPaper(x + newSize, y + 2*newSize, newSize);
		cutPaper(x + 2*newSize, y, newSize);
		cutPaper(x + 2*newSize, y + newSize, newSize);
		cutPaper(x + 2*newSize, y + 2*newSize, newSize);
	}



	private static boolean checkNum(int x, int y, int size) {
		int point = paper[x][y];
		
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(paper[i][j]!=point) {
					return false;
				}
			}
		}
		
		return true;
		
	}
}
