import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

  private final String value;

  public Anagram(final String value) {
    this.value = value;
  }

  public List<String> match(final List<String> potentialMatches) {
    if (potentialMatches == null) {
      throw new IllegalArgumentException();
    }

    final List<String> matches = new ArrayList<>();
    final Map<Character, Integer> anagramCharacterCounts = generateCharacterCount(value);
    for (final String potentialMatch : potentialMatches) {
      if (!potentialMatch.equals(value) && isMatch(anagramCharacterCounts, generateCharacterCount(potentialMatch))) {
        matches.add(potentialMatch);
      }
    }
    return matches;
  }

  private static boolean isMatch(final Map<Character, Integer> anagramCharacterCount, final Map<Character, Integer> potentialMatchCharacterCount) {
    for (Map.Entry<Character, Integer> entry : anagramCharacterCount.entrySet()) {
      Integer value = null;

      if (potentialMatchCharacterCount.containsKey(Character.toUpperCase(entry.getKey()))) {
        value = potentialMatchCharacterCount.get(Character.toUpperCase(entry.getKey()));
      }

      if (potentialMatchCharacterCount.containsKey(Character.toLowerCase(entry.getKey()))) {
        value = potentialMatchCharacterCount.get(Character.toLowerCase(entry.getKey()));
      }

      if (value == null || value.compareTo(entry.getValue()) != 0) {
        return false;
      }
    }

    for (Map.Entry<Character, Integer> entry : potentialMatchCharacterCount.entrySet()) {
      Integer value = null;

      if (anagramCharacterCount.containsKey(Character.toUpperCase(entry.getKey()))) {
        value = anagramCharacterCount.get(Character.toUpperCase(entry.getKey()));
      }

      if (anagramCharacterCount.containsKey(Character.toLowerCase(entry.getKey()))) {
        value = anagramCharacterCount.get(Character.toLowerCase(entry.getKey()));
      }

      if (value == null || value.compareTo(entry.getValue()) != 0) {
        return false;
      }
    }

    return true;
  }

  private static Map<Character, Integer> generateCharacterCount(final String value) {
    if (value == null) {
      throw new IllegalArgumentException();
    }

    final Map<Character, Integer> characterCountMap = new HashMap<>();
    for (char c : value.toCharArray()) {
      final Integer count = characterCountMap.get(c);
      if (count == null) {
        characterCountMap.put(c, 1);
      } else {
        characterCountMap.put(c, count + 1);
      }
    }
    return characterCountMap;
  }
}
