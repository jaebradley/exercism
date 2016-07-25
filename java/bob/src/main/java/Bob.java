public class Bob {

  private static final String DEFAULT_RESPONSE = "Whatever.";
  private static final String QUSTION_RESPONSE = "Sure.";
  private static final String EXCLAMATION_RESPONSE = "Whoa, chill out!";
  private static final String EMPTY_RESPONSE = "Fine. Be that way!";

  public Bob() {
  }

  public String hey(final String s) {
    if (s.contains("?")) {
      return QUSTION_RESPONSE;
    }

    if (s.contains("!")) {
      return EXCLAMATION_RESPONSE;
    }

    if (s.isEmpty()) {
      return EMPTY_RESPONSE;
    }

    return DEFAULT_RESPONSE;
  }
}
