import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String[] num;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        num = new String[N];
        
        for(int i=0;i<N;i++) {
        	num[i] = br.readLine().trim();
        }
        
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (shouldSwap(num[j], num[j + 1])) {
                    swap(j, j + 1);
                }
            }
        }
        
        for(String a:num) {
        	System.out.println(a);
        }
	}

	private static boolean shouldSwap(String a, String b) {
		if (a.length() != b.length()) {
            return a.length() > b.length();
        }

        int sumA = getDigitSum(a);
        int sumB = getDigitSum(b);
        if (sumA != sumB) {
            return sumA > sumB;
        }

        return a.compareTo(b) > 0;
	}

	private static void swap(int index1, int index2) {
		String temp = num[index1];
		num[index1] = num[index2];
		num[index2] = temp;
		
	}

	private static int getDigitSum(String s) {
		int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
	}
}
