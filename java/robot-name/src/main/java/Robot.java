public class Robot {

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
    int alphabeticIndex = new Double(Math.floor(Math.random() * 26)).intValue() + 'A';
    if (!Character.isLetter(alphabeticIndex) && Character.isUpperCase(alphabeticIndex)) {
      throw new IllegalStateException(String.format("%s does not point to an upper-case letter", alphabeticIndex));
    }
   return (char) alphabeticIndex;
  }
}
