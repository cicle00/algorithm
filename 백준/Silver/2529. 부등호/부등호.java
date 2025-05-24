import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static char[] signs;
	static boolean[] used = new boolean[10]; //0~9
	static List<String> results = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        signs = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++) {
        	signs[i] = st.nextToken().charAt(0);
        }
        
        for(int i=0;i<=9;i++) {
        	used[i] = true;
        	dfs(0, i+"");
        	used[i] = false;
        }
        
        Collections.sort(results);
        System.out.println(results.get(results.size()-1));
        System.out.println(results.get(0));
        
        
    }
    
    public static void dfs(int depth, String number) {
    	if(depth == k) {
    		results.add(number);
    		return;
    	}
    	
    	for(int i=0;i<=9;i++) {
    		if(!used[i]) {
    			char sign = signs[depth];
    			int prev = number.charAt(number.length()-1)-'0';
    			
    			if((sign=='<' && prev < i) || (sign=='>' && prev > i)) {
    				used[i] = true;
    				dfs(depth + 1, number + i);
    				used[i] = false;
    			}
    		}
    	}
    }
}
