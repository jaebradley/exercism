import java.math.BigDecimal;

public class SpaceAge {
  private static final int EARTH_ORBIT_IN_SECONDS = 31557600;
  private static final BigDecimal MERCURY_ORBIT_IN_EARTH_YEARS = new BigDecimal(0.2408467);
  private static final BigDecimal VENUS_ORBIT_IN_EARTH_YEARS = new BigDecimal(0.61519726);
  private static final BigDecimal MARS_ORBIT_IN_EARTH_YEARS = new BigDecimal(1.8808158);
  private static final BigDecimal JUPITER_ORBIT_IN_EARTH_YEARS = new BigDecimal(11.862615);
  private static final BigDecimal SATURN_ORBIT_IN_EARTH_YEARS = new BigDecimal(29.447498);
  private static final BigDecimal URANUS_ORBIT_IN_EARTH_YEARS = new BigDecimal(84.016846);
  private static final BigDecimal NEPTUNE_ORBIT_IN_EARTH_YEARS = new BigDecimal(164.79132);

  private final long seconds;

  public SpaceAge(final long seconds) {
    this.seconds = seconds;
  }

  public double onEarth() {
    return getConvertedYears(BigDecimal.ONE);
  }

  public double onMercury() {
    return getConvertedYears(MERCURY_ORBIT_IN_EARTH_YEARS);
  }

  public double onVenus() {
    return getConvertedYears(VENUS_ORBIT_IN_EARTH_YEARS);
  }

  public double onMars() {
    return getConvertedYears(MARS_ORBIT_IN_EARTH_YEARS);
  }

  public double onJupiter() {
    return getConvertedYears(JUPITER_ORBIT_IN_EARTH_YEARS);
  }

  public double onSaturn() {
    return getConvertedYears(SATURN_ORBIT_IN_EARTH_YEARS);
  }

  public double onUranus() {
    return getConvertedYears(URANUS_ORBIT_IN_EARTH_YEARS);
  }

  public double onNeptune() {
    return getConvertedYears(NEPTUNE_ORBIT_IN_EARTH_YEARS);
  }

  public long getSeconds() {
    return seconds;
  }

  private double getConvertedYears(final BigDecimal planetOrbitInEarthYears) {
    return new BigDecimal(seconds)
            .divide(planetOrbitInEarthYears.multiply(new BigDecimal(EARTH_ORBIT_IN_SECONDS)), 2, BigDecimal.ROUND_HALF_UP)
            .doubleValue();
  }
}
