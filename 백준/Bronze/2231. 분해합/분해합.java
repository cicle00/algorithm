import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = 0;

        for(int i = Math.max(1, N - 9 * String.valueOf(N).length());i<N;i++){
            int n = i;
            int temp = i;
            while(temp>0){
                n += temp%10;
                temp/=10;
            }

            if(n == N) {
                min = i;
                break;
            }
        }

        System.out.println(min);

    }
}
