import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String S = sc.nextLine();
		String K = sc.nextLine();
		StringBuilder s = new StringBuilder();

		// 숫자만 제외하고 문자들을 이어붙임
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (!Character.isDigit(ch)) {
				s.append(ch);
			}
		}

		if (s.toString().contains(K)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
