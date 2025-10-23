import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> press = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int count = i + 1; 

                if (!press.containsKey(c)) {
                    press.put(c, count);
                } else {
                    press.put(c, Math.min(press.get(c), count));
                }
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String word = targets[i];
            int total = 0;
            boolean possible = true;

            for (char c : word.toCharArray()) {
                if (!press.containsKey(c)) {
                    possible = false; 
                    break;
                }
                total += press.get(c);
            }

            answer[i] = possible ? total : -1;
        }

        return answer;
    }
}
