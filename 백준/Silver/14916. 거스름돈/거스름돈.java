import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int result = -1;
		if(N!=1 && N !=3) {
		if((N%5)%2 != 0) {
			result = N/5 - 1;
			N -= (5*(N/5 - 1));
		}else {
			result = N/5;
			N -= (5*(N/5));
		}
		
		result += N/2;
		}
		
		System.out.println(result);
	}	
}

