import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (freq.get(c) == 1) return c;
        }

        return '\0';
    }

    public static void main(String[] args) {
        String[] testInputs = {"swiss", "aabbcc"};

        for (String text : testInputs) {
            char result = findFirstNonRepeatingChar(text);
            System.out.println("Input: \"" + text + "\"");
            if (result != '\0') {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
            System.out.println();
        }
    }s
}