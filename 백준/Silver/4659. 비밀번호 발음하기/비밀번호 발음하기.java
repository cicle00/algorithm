import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String password = br.readLine();
            if(password.equals("end")) break;

            if(isAcceptable(password)){
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
    }

    static boolean isAcceptable(String pw) {
        return hasVowel(pw) && noThreeInRow(pw) && noBadDouble(pw);
    }

    static boolean hasVowel(String pw){
        for(char c : pw.toCharArray()){
            if(isVowel(c)) return true;
        }
        return false;
    }

    static boolean noThreeInRow(String pw){
        int vowelCnt = 0;
        int consonantCnt = 0;
        for(char c : pw.toCharArray()){
            if(isVowel(c)){
                vowelCnt++;
                consonantCnt = 0;
            } else {
                consonantCnt++;
                vowelCnt = 0;
            }

            if(vowelCnt == 3 || consonantCnt == 3) return false;
        }
        return true;
    }

    static boolean noBadDouble(String pw){
        for(int i=1; i<pw.length(); i++){
            char prev = pw.charAt(i-1);
            char curr = pw.charAt(i);
            if(prev == curr && !(curr == 'e' || curr == 'o')) return false;
        }
        return true;
    }

    static boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }
}
