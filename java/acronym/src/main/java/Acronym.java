public class Acronym {
  public static String generate(final String phrase) {
    final StringBuilder sb = new StringBuilder();
    int index = 0;
    String substring = phrase;
    while (index < phrase.length()) {
      if (Character.isAlphabetic(phrase.charAt(index))) {
        sb.append(phrase.charAt(index));
      }

      index += getRelativeIndexForNextAcronymCharacter(substring);
      substring = phrase.substring(index);
    }
    return sb.toString().toUpperCase();
  }

  private static int getRelativeIndexForNextAcronymCharacter(final String substring) {
    for (int i = 0; i < substring.length() - 1; i++) {
      final char currentChar = substring.charAt(i);
      final char nextChar = substring.charAt(i + 1);
      if (isNextCharacterAnAcronymCharacter(currentChar, nextChar)) {
        return i + 1;
      }
    }
    return substring.length();
  }

  private static boolean isNextCharacterAnAcronymCharacter(final char currentChar, final char nextChar) {
    return (!Character.isAlphabetic(currentChar) && Character.isAlphabetic(nextChar)) ||
           (Character.isLowerCase(currentChar) && Character.isUpperCase(nextChar));
  }
}
