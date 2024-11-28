import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueSymbolIndex {

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

    public static void main(String[] args) {
        int ea1 = firstUniqChar("leetcode");
        int ea2 = firstUniqChar("loveleetcode");
    }
}
