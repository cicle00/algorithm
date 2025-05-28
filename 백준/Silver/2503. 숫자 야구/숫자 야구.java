import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] callNum = new String[N+1];
        int[] strike = new int[N+1];
        int[] ball = new int[N+1];
        
        for(int i=1;i<N+1;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	callNum[i] = st.nextToken();
        	strike[i] = Integer.parseInt(st.nextToken());
        	ball[i] = Integer.parseInt(st.nextToken());
        }
        
        int count = 0;

        for (int i = 123; i <= 987; i++) {
            String candidate = String.valueOf(i);

            // 0이 포함되거나 중복 숫자가 있으면 건너뜀
            if (candidate.charAt(0) == candidate.charAt(1) ||
                candidate.charAt(0) == candidate.charAt(2) ||
                candidate.charAt(1) == candidate.charAt(2) ||
                candidate.contains("0")) continue;

            boolean isValid = true;

            for (int j = 1; j <= N; j++) {
                int s = 0, b = 0;

                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (candidate.charAt(x) == callNum[j].charAt(y)) {
                            if (x == y) s++;
                            else b++;
                        }
                    }
                }

                if (s != strike[j] || b != ball[j]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) count++;
        }

        System.out.println(count);        
    }
}
