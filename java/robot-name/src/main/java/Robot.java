import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robot {

  private static final List<Character> ALPHABET = new ArrayList<Character>(
          Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                        'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
  );

  private String name;

  public Robot() {
    this.name = generateName();
  }

  public String getName() {
    return name;
  }

  public void reset() {
    name = generateName();
  }

  private String generateName() {
    return String.format("%s%s%s", generateRandomAlphabeticChar(), generateRandomAlphabeticChar(), generateRandomThreeDigitInteger());
  }

  private int generateRandomThreeDigitInteger() {
    return new Double(Math.floor(Math.random() * 1000)).intValue();
  }

  private char generateRandomAlphabeticChar() {
    int alphabeticIndex = new Double(Math.floor(Math.random() * 26)).intValue();
    return ALPHABET.get(alphabeticIndex);
  }
}
