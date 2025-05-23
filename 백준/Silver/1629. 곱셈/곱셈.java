import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	 Scanner sc = new Scanner(System.in);
         long A = sc.nextLong();
         long B = sc.nextLong();
         long C = sc.nextLong();

         System.out.println(modPow(A, B, C));
        
    }

	private static long modPow(long a, long b, long c) {
		if(b==1) return a%c;
		
		long temp = modPow(a, b/2, c);
		if(b%2 == 0) return (temp * temp) % c;
		else return (temp * temp % c) * a % c;
	}
}
