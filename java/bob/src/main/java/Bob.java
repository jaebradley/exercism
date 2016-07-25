public class Bob {

  private static final String DEFAULT_RESPONSE = "Whatever.";
  private static final String QUSTION_RESPONSE = "Sure.";
  private static final String EXCLAMATION_RESPONSE = "Whoa, chill out!";
  private static final String EMPTY_RESPONSE = "Fine. Be that way!";

  public Bob() {
  }

  public String hey(final String s) {
    String trimmedStatement = s.trim();

    if (isQuestion(trimmedStatement)) {
      return QUSTION_RESPONSE;
    }

    if (isYelling(trimmedStatement)) {
      return EXCLAMATION_RESPONSE;
    }

    if (trimmedStatement.isEmpty()) {
      return EMPTY_RESPONSE;
    }

    return DEFAULT_RESPONSE;
  }

  private static boolean isQuestion(final String s) {
    return s.contains("?") && !isYelling(s);
  }

  private static boolean isYelling(final String s) {
    return s.contains("!") || allAlphabeticCharactersAreUpperCase(s);
  }

  private static boolean allAlphabeticCharactersAreUpperCase(final String s) {
    for (char c : s.toCharArray()) {
      if (Character.isAlphabetic(c) && !Character.isUpperCase(c)) {
        return false;
      }
    }

    return true;
  }
}
