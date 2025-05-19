import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int result = -1;
		
		for(int five=N/5;five>=0;five--) {
			int remainder = N - (5*five);
			if(remainder%2==0) {
				int two = remainder/2;
				result = two + five;
				break;
			}
		}
		
		System.out.println(result);
	}	
}