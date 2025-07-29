import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] nums = new int[5][5];
    static boolean[][] check = new boolean[5][5];
    static boolean bingo = false;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        boolean bingoAchieved = false;

        for (int i = 0; i < 5 && !bingoAchieved; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5 && !bingoAchieved; j++) {
                int num = Integer.parseInt(st.nextToken());
                numCheck(num);
                count++;
                if(isBingo()>=3) {
                    bingoAchieved = true;
                    break;
                }
            }
            if(bingoAchieved) break;
        }

        System.out.println(count);

    }

    static void numCheck(int n){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(nums[i][j]==n){
                    check[i][j] = true;
                }
            }
        }
    }

    static int isBingo(){
        int bingoCount = 0;
        //가로
        for(int i=0;i<5;i++){
            boolean rowBingo = true;
            for(int j=0;j<5;j++){
                if(!check[i][j]) {
                    rowBingo = false;
                    break;
                }
            }
            if (rowBingo) bingoCount++;
        }

        //세로
        for(int j=0;j<5;j++){
            boolean colBingo = true;
            for(int i=0;i<5;i++){
                if(!check[i][j]) {
                    colBingo = false;
                    break;
                }
            }
            if (colBingo) bingoCount++;
        }

        //대각선
        boolean diag1 = true;
        boolean diag2 = true;
        for(int i=0;i<5;i++) {
            if (!check[i][i]) {
                diag1 = false;
            }
            if(!check[i][4-i]){
                diag2 = false;
            }
        }
        if (diag1) bingoCount++;
        if (diag2) bingoCount++;

        return bingoCount;
    }
}
