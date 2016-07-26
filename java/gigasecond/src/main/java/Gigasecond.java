import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {

  private static final int SECONDS_IN_GIGASECOND = 1000000000;
  private final LocalDateTime dateTime;

  public Gigasecond(final LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Gigasecond(final LocalDate date) {
    this(LocalDateTime.of(date, LocalTime.MIDNIGHT));
  }

  public LocalDateTime getDate() {
    return dateTime.plus(SECONDS_IN_GIGASECOND, ChronoUnit.SECONDS);
  }
}
