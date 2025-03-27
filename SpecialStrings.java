import java.util.HashMap;
import java.util.Map;

public class SpecialStrings {

    public static void main(String[] args) {
        int count1 = numberOfSpecialSubstrings("ababab");
        System.out.println(count1);
        int count2 = numberOfSpecialSubstrings("bddqc");
        System.out.println(count2);
        int count3 = numberOfSpecialSubstrings("ooo");
        System.out.println(count3);
        int count4 = numberOfSpecialSubstrings("o");
        System.out.println(count4);
    }

    public static int numberOfSpecialSubstrings(String s) {
        int len = s.length();
        int[] chcount = new int[26];

        int left = 0;
        int result = 0;

        for (int right = 0; right < len; right++) {
            chcount[s.charAt(right) - 'a'] += 1;

            while (chcount[s.charAt(right) - 'a'] > 1) {
                chcount[s.charAt(left) - 'a'] -= 1;
                left += 1;
            }

            result += (right - left + 1);
        }

        return result;
    }
}
