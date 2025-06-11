import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] garden;
	static int[][] fee;
	static int min = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        garden = new int[N][N];
        fee = new int[N-2][N-2];
        
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		garden[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=1;i<N-1;i++) {
        	for(int j=1;j<N-1;j++) {
        		fee[i-1][j-1] = garden[i][j]+garden[i][j-1]+garden[i][j+1]+garden[i-1][j]+garden[i+1][j];
        	}
        }
        
        min = minFee(min);
        
        System.out.println(min);
        
	}

    private static int minFee(int min) {
        boolean[][] visited = new boolean[N][N];
        
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                for (int x = 1; x < N - 1; x++) {
                    for (int y = 1; y < N - 1; y++) {
                        for (int a = 1; a < N - 1; a++) {
                            for (int b = 1; b < N - 1; b++) {
                                int[][] pos = {{i, j}, {x, y}, {a, b}};
                                if (isValid(pos)) {
                                    int cost = getCost(pos);
                                    min = Math.min(min, cost);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return min;
    }
    
    private static boolean isValid(int[][] centers) {
        boolean[][] tempVisited = new boolean[N][N];
        
        for (int[] center : centers) {
            int x = center[0], y = center[1];
            int[] dx = {0, 0, 0, -1, 1};
            int[] dy = {0, -1, 1, 0, 0};
            
            for (int k = 0; k < 5; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if (tempVisited[nx][ny]) return false;
                tempVisited[nx][ny] = true;
            }
        }
        
        return true;
    }

    private static int getCost(int[][] centers) {
        int sum = 0;
        for (int[] center : centers) {
            int x = center[0], y = center[1];
            int[] dx = {0, 0, 0, -1, 1};
            int[] dy = {0, -1, 1, 0, 0};
            
            for (int k = 0; k < 5; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                sum += garden[nx][ny];
            }
        }
        return sum;
    }


}
