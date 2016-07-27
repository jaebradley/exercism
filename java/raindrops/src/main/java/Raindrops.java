public class Raindrops {
  public static String convert(final int value) {
    StringBuilder sb = new StringBuilder();
    if (value % 3 == 0) {
      sb.append("Pling");
    }

    if (value % 5 == 0) {
      sb.append("Plang");
    }

    if (value % 7 == 0) {
      sb.append("Plong");
    }

    if (sb.length() == 0) {
      return String.valueOf(value);
    }

    return sb.toString();
  }
}
