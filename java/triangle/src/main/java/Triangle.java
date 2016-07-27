import java.math.BigDecimal;

public class Triangle {
  private final BigDecimal firstSide;
  private final BigDecimal secondSide;
  private final BigDecimal thirdSide;

  public Triangle(final BigDecimal firstSide, final BigDecimal secondSide, final BigDecimal thirdSide) throws TriangleException {
    if (firstSide.compareTo(BigDecimal.ZERO) <= 0) {
      throw new TriangleException();
    }

    if (secondSide.compareTo(BigDecimal.ZERO) <= 0) {
      throw new TriangleException();
    }

    if (thirdSide.compareTo(BigDecimal.ZERO) <= 0) {
      throw new TriangleException();
    }

    if (!checkTriangleInequality(firstSide, secondSide, thirdSide)) {
      throw new TriangleException();
    }

    this.firstSide = firstSide;
    this.secondSide = secondSide;
    this.thirdSide = thirdSide;
  }

  public Triangle(final int firstSide, final int secondSide, final int thirdSide) throws TriangleException {
    this(new BigDecimal(firstSide), new BigDecimal(secondSide), new BigDecimal(thirdSide));
  }

  public Triangle(final double firstSide, final double secondSide, final double thirdSide) throws TriangleException {
    this(new BigDecimal(firstSide), new BigDecimal(secondSide), new BigDecimal(thirdSide));
  }

  public TriangleKind getKind() {
    final boolean firstSideEqualsSecondSide = firstSide.compareTo(secondSide) == 0;
    final boolean firstSideEqualsThirdSide = firstSide.compareTo(thirdSide) == 0;
    final boolean secondSideEqualsThirdSide = secondSide.compareTo(thirdSide) == 0;

    if (firstSideEqualsSecondSide && !firstSideEqualsThirdSide ||
        !firstSideEqualsSecondSide && firstSideEqualsThirdSide ||
        firstSideEqualsThirdSide && !secondSideEqualsThirdSide ||
        secondSideEqualsThirdSide && !firstSideEqualsSecondSide) {
      return TriangleKind.ISOSCELES;
    }

    if (firstSideEqualsSecondSide && firstSideEqualsThirdSide) {
      return TriangleKind.EQUILATERAL;
    }

    return TriangleKind.SCALENE;
  }

  private static boolean checkTriangleInequality(final BigDecimal firstSide, final BigDecimal secondSide, final BigDecimal thirdSide) {
    return firstSide.add(secondSide).compareTo(thirdSide) > 0 &&
            secondSide.add(thirdSide).compareTo(firstSide) > 0 &&
            thirdSide.add(firstSide).compareTo(secondSide) > 0;
  }
}
