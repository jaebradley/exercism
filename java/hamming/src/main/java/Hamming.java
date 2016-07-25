public class Hamming {

  public static int compute(final String dnaStrand1, final String dnaStrand2) {
    if (dnaStrand1.length() != dnaStrand2.length()) {
      throw new IllegalArgumentException();
    }

    int count = 0;
    for (int i = 0; i < dnaStrand1.length(); i++) {
      if (dnaStrand1.charAt(i) != dnaStrand2.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}
