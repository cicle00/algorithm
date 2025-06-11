import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] garden;
	static int[][] fee;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	
	static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, -1, 1, 0, 0};
	
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
        
        visited = new boolean[N][N];
         minFee();
        
        System.out.println(min);
        
	}

    private static void minFee() {
        int size = N - 2;
        for (int i1 = 0; i1 < size; i1++) {
            for (int j1 = 0; j1 < size; j1++) {
                if (!canPlace(i1 + 1, j1 + 1)) continue;
                mark(i1 + 1, j1 + 1, true); // 꽃1

                for (int i2 = 0; i2 < size; i2++) {
                    for (int j2 = 0; j2 < size; j2++) {
                        if (!canPlace(i2 + 1, j2 + 1)) continue;
                        mark(i2 + 1, j2 + 1, true); 
                        
                        for (int i3 = 0; i3 < size; i3++) {
                            for (int j3 = 0; j3 < size; j3++) {
                                if (!canPlace(i3 + 1, j3 + 1)) continue;

                                int cost = fee[i1][j1] + fee[i2][j2] + fee[i3][j3];
                                min = Math.min(min, cost);
                            }
                        }

                        mark(i2 + 1, j2 + 1, false); 
                    }
                }

                mark(i1 + 1, j1 + 1, false); 
            }
        }
    }

    private static boolean canPlace(int x, int y) {
        for (int k = 0; k < 5; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (visited[nx][ny]) return false;
        }
        return true;
    }

    private static void mark(int x, int y, boolean flag) {
        for (int k = 0; k < 5; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            visited[nx][ny] = flag;
        }
    }

}
