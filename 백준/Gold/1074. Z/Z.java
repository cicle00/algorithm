import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int r;
	static int c;
	static int count = 0;
	static int order = 0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        int size = 1 << N;
        zCheck(0, 0, size);
        System.out.println(order);
        
	}
    
    public static void zCheck(int x, int y, int size) {
    	if(size == 1) {
    		if(x==r && y==c) order = count;
	    	count++;
	    	return;
    	}
    	
    	int half = size / 2;
    	if(r<x+half && c<y+half) {
    		zCheck(x,y,half);
    	}else if(r<x+half && c>=y+half) {
    		count += half * half;
    		zCheck(x,y+half,half);
    	}else if(r>=x+half && c<y+half) {
    		count += 2* half * half;
    		zCheck(x+half,y,half);
    	}else {
    		count += 3* half * half;
    		zCheck(x+half,y+half,half);
    	}
    }
}
