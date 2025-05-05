import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N];
		int max = 0;
		
		for(int i=0;i<N;i++) {
			coins[i] = sc.nextInt();
		}
		
		int count = 0;
		
		for(int i=N-1;i>=0;i--) {
			if(coins[i]<=K) {
			//K = K % coins[i]; //순서 중요
			count += K / coins[i];
            K = K % coins[i];
			}
		}
        System.out.println(count);
    }
	
}