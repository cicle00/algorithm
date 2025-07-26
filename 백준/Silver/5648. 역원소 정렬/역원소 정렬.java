import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Long> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            long num = sc.nextLong();
            list.add(reverseNum(num));
        }

        Collections.sort(list);

        for(long a: list){
            System.out.println(a);
        }
    }

    static long reverseNum(long num){
        long reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
