public class RnaTranscription {
  private static final char GUANINE = 'G';
  private static final char CYTOSINE = 'C';
  private static final char THYMINE = 'T';
  private static final char ADENINE = 'A';
  private static final char URACIL = 'U';

  public static String ofDna(final String dna) {
    if (dna == null) {
      throw new IllegalArgumentException("input must be non-null");
    }

    final StringBuilder sb = new StringBuilder();
    for (char c : dna.toUpperCase().toCharArray()) {
      switch (c) {
        case GUANINE :
          sb.append(CYTOSINE);
          break;

        case CYTOSINE:
          sb.append(GUANINE);
          break;

        case THYMINE:
          sb.append(ADENINE);
          break;

        case ADENINE:
          sb.append(URACIL);
          break;

        default:
          throw new IllegalArgumentException(String.format("%s is not a valid DNA nucleotide", c));
      }
    }
    return sb.toString();
  }
}
