import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// DP 배열 선언: dp[i] = i를 1로 만드는 최소 연산 횟수
        int[] dp = new int[N + 1];

        // 초기값 설정
        dp[1] = 0; // 1은 0번 연산 필요

        // DP 점화식
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; 

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
	
	
}