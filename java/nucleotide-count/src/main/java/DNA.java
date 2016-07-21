import java.util.*;

public class DNA {

  private static final char ADENINE = 'A';
  private static final char CYTOSINE = 'C';
  private static final char GUANINE = 'G';
  private static final char THYMINE = 'T';
  private static final Set<Character> NUCLEOTIDES = new HashSet<>(Arrays.asList(ADENINE, CYTOSINE, GUANINE, THYMINE));

  private final String dna;

  public DNA(final String dna) {
    this.dna = dna;
  }

  public Map<Character, Integer> nucleotideCounts() {
    final Map<Character, Integer> counts = new HashMap<>();
    NUCLEOTIDES.stream().forEach(nucleotide -> counts.put(nucleotide, 0));

    for (char c : dna.toUpperCase().toCharArray()) {
      if (NUCLEOTIDES.contains(c)) {
        Integer currentCount = counts.get(c);
        // could be argued that this is redundant, but I would argue that covers any future changes
        if (currentCount == null) {
          counts.put(c, 1);
        } else {
          counts.put(c, ++currentCount);
        }
      }
    }

    return counts;
  }

  public int count(char nucleotide) {
    if (!NUCLEOTIDES.contains(nucleotide)) {
      throw new IllegalArgumentException();
    }

    return nucleotideCounts().get(nucleotide);
  }
}
