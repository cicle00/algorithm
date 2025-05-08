import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static Integer[] sa;
    static int[] lcp, group, temp;
    static int t, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        String sep = "$";  // A와 B 구분자
        String str = A + sep + B;
        n = str.length();

        buildSuffixArray(str);
        buildLCP(str);

        int maxLen = 0;
        int start = 0;
        int lenA = A.length();

        for (int i = 1; i < n; i++) {
            boolean fromA = sa[i] < lenA;
            boolean fromB = sa[i - 1] < lenA;
            if (fromA != fromB && lcp[i] > maxLen) {
                maxLen = lcp[i];
                start = sa[i];
            }
        }

        String longest = str.substring(start, start + maxLen);
        System.out.println(longest.equals(C) ? "YES" : "NO");
    }

    static void buildSuffixArray(String s) {
        sa = new Integer[n];
        group = new int[n + 1];
        temp = new int[n];
        t = 1;

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            group[i] = s.charAt(i);
        }
        group[n] = -1;

        while (t <= n) {
            final int T = t;
            Arrays.sort(sa, (a, b) -> {
                if (group[a] != group[b]) return group[a] - group[b];
                return group[a + T] - group[b + T];
            });

            temp[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                temp[sa[i]] = temp[sa[i - 1]];
                if (group[sa[i - 1]] != group[sa[i]] ||
                        group[sa[i - 1] + T] != group[sa[i] + T])
                    temp[sa[i]]++;
            }

            System.arraycopy(temp, 0, group, 0, n);
            t <<= 1;
        }
    }

    static void buildLCP(String s) {
        int[] rank = new int[n];
        lcp = new int[n];
        for (int i = 0; i < n; i++) rank[sa[i]] = i;

        int h = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = sa[rank[i] - 1];
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) h++;
                lcp[rank[i]] = h;
                if (h > 0) h--;
            }
        }
    }
}
