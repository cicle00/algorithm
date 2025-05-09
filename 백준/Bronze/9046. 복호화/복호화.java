import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 0; t < T; t++) {
            int[] alphabet = new int[26];

            String cipher = sc.nextLine().toLowerCase();

            for (int i = 0; i < cipher.length(); i++) {
                char ch = cipher.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    alphabet[ch - 'a']++;
                }
            }

            int max = 0;
            char result = '?';
            boolean duplicate = false;

            for (int i = 0; i < 26; i++) {
                if (alphabet[i] > max) {
                    max = alphabet[i];
                    result = (char)(i + 'a');
                    duplicate = false;
                } else if (alphabet[i] == max && max > 0) {
                    duplicate = true;
                }
            }

            System.out.println(duplicate ? '?' : result);
        }
    }
}
