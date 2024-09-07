/*Program Name: Rational.java
 * Authors: Austin P
 * Date last Updated: 9/6/2024
 * Purpose: This program is the redesigned version of the Rational class provided by the java 
 * textbook to handle the use of BigInteger
 */
import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {

    // Data fields for BigInteger numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    /** Construct a rational with default properties */
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = (denominator.signum() > 0 ? BigInteger.ONE : BigInteger.valueOf(-1)).multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    /** Find GCD of two numbers */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        return n.gcd(d);
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return denominator;
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Multiply a rational number by this rational */
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Divide a rational number by this rational */
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    // Override the equals method in the Object class
    @Override
    public boolean equals(Object other) {
        if (other instanceof Rational) {
            return this.subtract((Rational) other).getNumerator().equals(BigInteger.ZERO);
        }
        return false;
    }

    // Implemented the intValue floatValue method to cast the double result to int
    @Override
    public int intValue() {
        return (int) doubleValue();  
    }

    // Implemented the abstract floatValue method to cast the double result to float
    @Override
    public float floatValue() {
        return (float) doubleValue();  
    }

    // Implemented the doubleValue method to calculate double value
    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();  
    }

    // Implemented longValue method that casts the double result to a long
    @Override
    public long longValue() {
        return (long) doubleValue();  
    }

    // Implemented the compareTo method from/in Comparable
    @Override
    public int compareTo(Rational o) {
        return this.subtract(o).getNumerator().compareTo(BigInteger.ZERO);
    }
}
