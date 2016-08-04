public class Hexadecimal {
  public static int toDecimal(final String input) {
    return convertToDecimal(16, input);
  }

  private static int convertToDecimal(final int base, final String input) {
    if (base < 2) {
      throw new IllegalArgumentException();
    }

    if (base > 36) {
      throw new IllegalArgumentException();
    }

    if (input == null) {
      throw new IllegalArgumentException();
    }

    final String formattedInput = input.toUpperCase();
    final int length = formattedInput.length();
    int sum = 0;
    for (int i = 0; i < length; i++) {
      final char c = formattedInput.charAt(i);
      try {
        final int digitValue = calculateCharacterValue(c, base);
        if (digitValue < base && digitValue > 0) {
          sum += digitValue * Math.pow(base, length - 1 - i);
        }
      } catch (IllegalArgumentException e) {
        return 0;
      }
    }

    return sum;
  }

  private static int calculateCharacterValue(final char c, final int base) {
    if (base < 2) {
      throw new IllegalArgumentException();
    }

    if (base > 36) {
      throw new IllegalArgumentException();
    }
    
    if (Character.isDigit(c)) {
      return Character.getNumericValue(c);
    }

    else if (Character.isAlphabetic(c) && base > 10) {
      final int alphabetValue = Character.toUpperCase(c) - 'A' + 10;
      if (alphabetValue > base) {
        throw new IllegalArgumentException();
      }

      return alphabetValue;
    }

    throw new IllegalArgumentException();
  }
}
