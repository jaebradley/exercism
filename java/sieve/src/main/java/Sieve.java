import java.util.ArrayList;
import java.util.List;

public class Sieve {
  private static final int STARTING_VALUE = 2;
  private final int limit;

  public Sieve(final int limit) {
    this.limit = limit;
  }

  public List<Integer> getPrimes() {
    final boolean[] markedPrimes = new boolean[limit + 1];
    for (int i = STARTING_VALUE; i < limit; i++) {
      if (!markedPrimes[i]) {
        for (int j = i + 1; j < limit + 1; j++) {
          if (i % j == 0) {
            markedPrimes[j] = true;
          }
        }
      }
    }
    final List<Integer> primes = new ArrayList<>();
    for (int i = STARTING_VALUE; i < limit + 1; i++) {
      if (!markedPrimes[i]) {
        primes.add(i);
      }
    }
    return primes;
  }
}
