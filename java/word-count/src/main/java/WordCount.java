import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordCount {

  private static final Set<Character> WORD_SEPARATORS = new HashSet<>(Arrays.asList(',', ' ', '|'));

  public Map<String, Integer> phrase(final String phrase) {
    final Map<String, Integer> wordCountMap = new HashMap<>();
    int nextWordTerminatorIndex = 0;
    int startIndexOfNextPhrase = 0;
    String substring = phrase;
    while (nextWordTerminatorIndex < phrase.length() && startIndexOfNextPhrase < phrase.length()) {
      startIndexOfNextPhrase = getRelativeIndexOfNextNonWordTerminator(substring.substring(startIndexOfNextPhrase));
      nextWordTerminatorIndex = getRelativeIndexOfNextWordTerminator(substring.substring(startIndexOfNextPhrase));

      if (startIndexOfNextPhrase == phrase.length() - 1 || nextWordTerminatorIndex == phrase.length() - 1) {
        return wordCountMap;
      }

      String word = substring.substring(startIndexOfNextPhrase, nextWordTerminatorIndex + 1);
      substring = substring.substring(startIndexOfNextPhrase);
      incrementWordCount(wordCountMap, word);
    }
    return wordCountMap;
  }

  public int getRelativeIndexOfNextWordTerminator(final String phraseSubstring) {
    char[] chars = phraseSubstring.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (WORD_SEPARATORS.contains(chars[i])) {
        return i;
      }
    }

    return chars.length - 1;
  }

  public int getRelativeIndexOfNextNonWordTerminator(final String phraseSubstring) {
    char[] chars = phraseSubstring.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (!WORD_SEPARATORS.contains(chars[i])) {
        return i;
      }
    }

    return chars.length - 1;
  }

  public void incrementWordCount(final Map<String, Integer> wordCountMap, final String word) {
    final Integer count = wordCountMap.get(word);
    if (count == null) {
      wordCountMap.put(word, 1);
    } else {
      wordCountMap.put(word, count + 1);
    }
  }
}
