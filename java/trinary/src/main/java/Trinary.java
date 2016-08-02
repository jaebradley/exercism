public class Trinary {
  public static int toDecimal(final String input) {
    return convertToBase10(input, 3);
  }

  private static int convertToBase10(final String input, final int fromBase) {
    int sum = 0;
    final int length = input.length();
    for (int i = 0; i < length; i++) {
      final char c = input.charAt(i);

      if (!Character.isDigit(c) || Character.getNumericValue(c) >= fromBase) {
        return 0;
      }

      sum += Character.getNumericValue(c) * Math.pow(fromBase, length - 1 - i);
    }
    return sum;
  }
}
