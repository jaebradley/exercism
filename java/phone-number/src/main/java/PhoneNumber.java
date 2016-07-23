import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
  private final static String BAD_NUMBER = "0000000000";

  private final String number;

  public PhoneNumber(final String number) {
    this.number = number;
  }

  public static class ParsedPhoneNumber {
    private final List<Character> firstThreeDigits;
    private final List<Character> nextThreeDigits;
    private final List<Character> finalFourDigits;

    public ParsedPhoneNumber(final List<Character> firstThreeDigits, final List<Character> nextThreeDigits, final List<Character> finalFourDigits) {
      this.firstThreeDigits = firstThreeDigits;
      this.nextThreeDigits = nextThreeDigits;
      this.finalFourDigits = finalFourDigits;
    }

    public List<Character> getFirstThreeDigits() {
      return firstThreeDigits;
    }

    public List<Character> getNextThreeDigits() {
      return nextThreeDigits;
    }

    public List<Character> getFinalFourDigits() {
      return finalFourDigits;
    }

  }

  public String getNumber() {
    final List<Character> digits = getDigits(number);

    if (!isValidDigits(digits)) {
      return BAD_NUMBER;
    }

    List<Character> lastTenDigits = digits.subList(digits.size() - 10, digits.size());

    final StringBuilder sb = new StringBuilder();
    lastTenDigits.forEach(sb::append);

    return sb.toString();
  }

  public String getAreaCode() {
    final StringBuilder sb = new StringBuilder();
    getAreaCodeDigits().forEach(sb::append);

    return sb.toString();
  }

  public String pretty() {
    final StringBuilder sb = new StringBuilder();
    final ParsedPhoneNumber parsedPhoneNumber = getParsedPhoneNumber();

    sb.append("(");

    parsedPhoneNumber.getFirstThreeDigits().forEach(sb::append);

    sb.append(") ");

    parsedPhoneNumber.getNextThreeDigits().forEach(sb::append);

    sb.append("-");

    parsedPhoneNumber.getFinalFourDigits().forEach(sb::append);

    return sb.toString();
  }

  private ParsedPhoneNumber getParsedPhoneNumber() {
    final List<Character> digits = getDigits(number);
    final List<Character> lastTenDigits = digits.subList(digits.size() - 10, digits.size());
    final List<Character> firstThree = lastTenDigits.subList(0, 3);
    final List<Character> nextThree = lastTenDigits.subList(3, 6);
    final List<Character> lastFour = lastTenDigits.subList(6, 10);
    return new ParsedPhoneNumber(firstThree, nextThree, lastFour);
  }

  private List<Character> getAreaCodeDigits() {
    final List<Character> digits = getDigits(number);
    final List<Character> lastTenDigits = digits.subList(digits.size() - 10, digits.size());
    return lastTenDigits.subList(0, 3);
  }

  private static List<Character> getDigits(final String phoneNumber) {
    final List<Character> digits = new ArrayList<>();
    for (char c : phoneNumber.toCharArray()) {
      if (Character.isDigit(c)) {
        digits.add(c);
      }
    }
    return digits;
  }

  private static boolean isValidDigits(final List<Character> digits) {
    return digits.size() == 10 || (digits.size() == 11 && digits.get(0) == '1');
  }
}
