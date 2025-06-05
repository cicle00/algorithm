import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] media;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        media = new int[N][N];
        
        for(int i=0;i<N;i++) {
        	String line = br.readLine();
        	for(int j=0;j<N;j++) {
        		media[i][j] = line.charAt(j)-'0';
        	}
        }
        
        quadtree(0,0, N);
        
        
    }
	private static void quadtree(int x, int y, int size) {
		if(checkSame(x,y,size)) {
			System.out.print(media[x][y]);
			return;
		}
		System.out.print("(");
		int newSize = size/2;
		quadtree(x,y,newSize);
		quadtree(x,y+newSize,newSize);
		quadtree(x+newSize,y,newSize);
		quadtree(x+newSize,y+newSize,newSize);
		System.out.print(")");
	}
	private static boolean checkSame(int x, int y, int size) {
		int num = media[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(media[i][j]!=num) return false;
			}
		}
		return true;
	}
}
