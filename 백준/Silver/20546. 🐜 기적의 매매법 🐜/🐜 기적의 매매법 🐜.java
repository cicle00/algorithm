import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] prices = new int[14];
        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // BNP
        int bnpMoney = money;
        int bnpStock = 0;
        for (int i = 0; i < 14; i++) {
            if (bnpMoney >= prices[i]) {
                int buy = bnpMoney / prices[i];
                bnpStock += buy;
                bnpMoney -= buy * prices[i];
            }
        }
        int bnpAsset = bnpMoney + bnpStock * prices[13];

        // TIMING
        int timingMoney = money;
        int timingStock = 0;
        for (int i = 3; i < 14; i++) {
            // 3일 연속 하락: i-3, i-2, i-1 비교
            if (prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1]) {
                // 다음 날 매수
                if (timingMoney >= prices[i]) {
                    int buy = timingMoney / prices[i];
                    timingStock += buy;
                    timingMoney -= buy * prices[i];
                }
            }
            // 3일 연속 상승: i-3, i-2, i-1 비교
            else if (prices[i - 3] < prices[i - 2] && prices[i - 2] < prices[i - 1]) {
                // 다음 날 매도
                timingMoney += timingStock * prices[i];
                timingStock = 0;
            }
        }
        int timingAsset = timingMoney + timingStock * prices[13];

        // 결과 출력
        if (bnpAsset > timingAsset) {
            System.out.println("BNP");
        } else if (bnpAsset < timingAsset) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
