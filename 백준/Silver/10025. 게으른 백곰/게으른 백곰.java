import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] ice = new int[1000001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int maxIdx = 0;
        int sum = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            ice[idx] = value;
            if(idx>maxIdx) maxIdx = idx;
        }

        int size = 2*K+1;

        for (int i = 0; i < size && i <= maxIdx; i++) {
            sum += ice[i];
        }

        int max = sum;
        for(int i = size; i<=maxIdx;i++){
            sum+= ice[i]-ice[i-size];
            if(sum>max) max = sum;
        }

        System.out.println(max);
    }
}
