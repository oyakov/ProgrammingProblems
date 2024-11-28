import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueSymbolIndex {

    // My first solution
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charFirstOccurrence = new HashMap<>();
        Set<Character> repeatingCharacters = new HashSet<>();
        char[] characters = s.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            // If char existed before, add it to repeating
            if (charFirstOccurrence.containsKey(characters[i])) repeatingCharacters.add(characters[i]);
            // Add char to existing letters map
            if (!charFirstOccurrence.containsKey(characters[i])) charFirstOccurrence.put(characters[i], i);
        }
        Set<Character> existingCharacters = charFirstOccurrence.keySet();
        Set<Character> nonRepeatingCharacters = new HashSet<>(existingCharacters);
        nonRepeatingCharacters.removeAll(repeatingCharacters);
        if(nonRepeatingCharacters.isEmpty()) return -1;

        Integer earliestOccurrence = s.length();
        for (Character c : nonRepeatingCharacters) {
            if(charFirstOccurrence.get(c) < earliestOccurrence) earliestOccurrence = charFirstOccurrence.get(c);
        }
        return earliestOccurrence;
    }

    public int firstUniqChar_most_efficient(String s) {
        // Premade array for all chars in english
        int[] ar = new int[26];
        char[] c = s.toCharArray();

        // Number of occurrences for each element
        for (int i = 0; i < c.length; i++) {
            // Encoding index of the char as its code relative to 'a's in ASCII
            ar[((int) (c[i])) - ((int) ('a'))]++;
        }

        // First element in the string that has one occurrence
        for (int i = 0; i < c.length; i++) {
            if (ar[((int) (c[i])) - ((int) ('a'))] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ea1 = firstUniqChar("leetcode");
        int ea2 = firstUniqChar("loveleetcode");
    }
}
