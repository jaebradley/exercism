public class Binary {
  private final String binaryRepresentation;

  public Binary(final String binaryRepresentation) {
    this.binaryRepresentation = binaryRepresentation;
  }

  public int getDecimal() {
    final int length = binaryRepresentation.length();
    int decimalValue = 0;
    for (int i = 0; i < length; i++) {
      final char c = binaryRepresentation.charAt(i);
      if (c != '0' && c != '1') {
        return 0;
      }

      decimalValue += Character.getNumericValue(c) * Math.pow(2, length - 1 - i);
    }
    return decimalValue;
  }
}
