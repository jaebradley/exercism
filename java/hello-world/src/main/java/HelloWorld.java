public class HelloWorld {

  private static final String baseGreeting = "Hello";

  public static String hello(String name) {
    if (name == null || name.isEmpty()) {
      return String.format("%s World", baseGreeting);
    }

    return String.format("%s %s", baseGreeting, name);
  }
}
