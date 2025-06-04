import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        boolean[] a;
        int count = 0;
        
        for(int t=0;t<N;t++) {
        	a = new boolean[26];
        	String world = br.readLine().trim();
        	for(int i=0;i<world.length();i++) {
        		if(a[world.charAt(i)-'a']) {
        			if(world.charAt(i)==world.charAt(i-1)) continue;
        			else {
        				count++;
        				break;
        			}
        		}
        		a[world.charAt(i)-'a'] = true;
        	}
        }
        
        System.out.println(N-count);
        
    }
}
