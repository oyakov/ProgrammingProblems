public class StringGCD {
    public static String gcdOfStrings(String str1, String str2) {
        for(int i = Math.min(str1.length(), str2.length()); i > 0; i--) {
            String sub1 = str1.substring(0, i);
            String sub2 = str2.substring(0, i);
            if(sub1.equals(sub2)) {
                if(tryDivide(str1, sub1) && tryDivide(str2, sub2)) {
                    return sub1;
                }
            }
        }
        return "";
    }

    private static boolean tryDivide(String str, String divisor) {
        if(str.length() % divisor.length() != 0) return false;
        boolean result = true;
        for(int j = 0; j < str.length(); j+=divisor.length()) {
            result &= str.startsWith(divisor, j);
        }
        return result;
    }

    public static void main(String[] args) {
        String gcd = gcdOfStrings("ABABAB", "ABAB");
    }
}
