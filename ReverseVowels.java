import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseVowels {
    public static String reverseVowels(String s) {
        // find all vowels and their indices
        char[] str = s.toCharArray();
        List<Character> vowels = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < str.length; i++) {
            if(testVowel(str[i])) {
                indices.add(i);
                vowels.add(str[i]);
            }
        }
        // reverse the vowels array, keeping indices array the same
        for(int i = 0, j = vowels.size() - 1; i<j; i++, j--) {
            Character swap = vowels.get(i);
            vowels.set(i, vowels.get(j));
            vowels.set(j, swap);
        }
        // remap the vowels int the string in reversed order
        for(int i = 0; i < vowels.size(); i++) {
            str[indices.get(i)] = vowels.get(i);
        }
        return new String(str);
    }

    private static boolean testVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String result = reverseVowels("IceCreAm");
        String[] lol = "a good   example".split(" ");
        System.out.println(Arrays.toString(lol));
    }
}
