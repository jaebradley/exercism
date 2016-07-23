import java.util.HashSet;
import java.util.Set;

public class Pangrams {
  public static boolean isPangram(final String s) {
    if (s.length() < 26) {
      return false;
    }

    final Set<Character> distinctAlphabeticValues = new HashSet<>();
    for (char c : s.toLowerCase().toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        distinctAlphabeticValues.add(c);
      }
    }

    return distinctAlphabeticValues.size() == 26;
  }
}
