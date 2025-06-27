import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int result = 1;
        
        int start = 1;
        int end = 1;
        int sum = 1;
        
        while(end != N) {
        	if(sum<N) {
        		end++;
        		sum += end;
        	} else if(sum>N) {
        		sum -= start;
        		start++;
        	} else {
        		result++;
        		end++;
        		sum += end;
        	}
        }
        
        System.out.println(result);
        
    
	}
}
