import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        // M은 최소 N - 9 * 자릿수 ~ N 사이 범위만 확인하면 됨
        for (int i = Math.max(1, N - 9 * String.valueOf(N).length()); i < N; i++) {
            int sum = i;
            int temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == N) {
                result = i;
                break; // 가장 작은 M을 찾으면 바로 종료
            }
        }

        System.out.println(result);
    }
}
