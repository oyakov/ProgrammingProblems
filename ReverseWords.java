public class ReverseWords {
    public static String reverseWords(String s) {
        return revRec(s.trim());
    }

    public static String revRec(String s) {
        // Base case: if there's no space, it's a single word.
        if (s.indexOf(' ') == -1) return s;

        // Get first token (word)
        int i = 0;
        while (i < s.length() && s.charAt(i) != ' ') {
            i++;
        }
        String firstTok = s.substring(0, i);

        // Get last token (word)
        int k = s.length() - 1;
        while (k >= 0 && s.charAt(k) != ' ') {
            k--;
        }
        String lastTok = s.substring(k + 1);

        // Middle part between first and last token; trim it to remove extra spaces.
        String rest = s.substring(i, k + 1).trim();

        if (rest.isEmpty()) {
            return lastTok + " " + firstTok;
        } else {
            return lastTok + " " + revRec(rest) + " " + firstTok;
        }
    }

    // O(n) time, O(n) space
    public static String reverse1(String s) {
        // First trim the input and split on one-or-more spaces to avoid empty tokens
        // Trim and split are O(n) time, split need s separate storage so O(n) space
        String[] result = s.trim().split("\\s+");

        // Now just reverse the array
        // O(n)
        for (int i = 0, j = result.length - 1; i < j; i++, j--) {
            String swap = result[i];
            result[i] = result[j];
            result[j] = swap;
        }

        // Rejoin the reversed array and return
        // O(n)
        return String.join(" ", result);
    }

    public static void main(String[] args) {
//        System.out.println(reverseWords("the sky is blue"));
//        System.out.println(reverseWords("  hello world  "));
//        System.out.println(reverseWords("a good   example"));
//        System.out.println(reverseWords("EPY2giL"));
        System.out.println(reverseWords(" 3c      2zPeO dpIMVv2SG    1AM       o       VnUhxK a5YKNyuG     x9    EQ  ruJO       0Dtb8qG91w 1rT3zH F0m n G wU"));
    }
}
