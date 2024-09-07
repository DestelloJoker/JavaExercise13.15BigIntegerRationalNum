/*Program Name: RationalBigIntegerTest.java
 * Authors: Austin P
 * Date last Updated: 9/6/2024
 * Purpose: This program is the driver class for the redesigned Rational class
 * that uses BigInteger for the numerator and denominator and displays the result of the division
 */
import java.math.BigInteger;
import java.util.Scanner;

public class RationalBigIntegerTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two numerators and two denominators
        System.out.print("Enter a numerator: ");
        BigInteger numerator1 = new BigInteger(input.next());
        System.out.print("Enter a denominator: ");
        BigInteger denominator1 = new BigInteger(input.next());

        System.out.print("Enter a second numerator: ");
        BigInteger numerator2 = new BigInteger(input.next());
        System.out.print("Enter a second denominator: ");
        BigInteger denominator2 = new BigInteger(input.next());

        // Create the two new rational objects
        Rational rationalnum1 = new Rational(numerator1, denominator1);
        Rational rationalnum2 = new Rational(numerator2, denominator2);

        // Display results of arithmetic operations
        System.out.println("First rational number: " + rationalnum1);
        System.out.println("Second rational number: " + rationalnum2);

        System.out.println(rationalnum1 + " + " + rationalnum2 + " = " + rationalnum1.add(rationalnum2));
        System.out.println(rationalnum1 + " - " + rationalnum2 + " = " + rationalnum1.subtract(rationalnum2));
        System.out.println(rationalnum1 + " * " + rationalnum2 + " = " + rationalnum1.multiply(rationalnum2));
        System.out.println(rationalnum1 + " / " + rationalnum2 + " = " + rationalnum1.divide(rationalnum2));

        // Compare the two rational numbers
        if (rationalnum1.compareTo(rationalnum2) == 0) {
            System.out.println(rationalnum1 + " is equal to " + rationalnum2);
        } else if (rationalnum1.compareTo(rationalnum2) > 0) {
            System.out.println(rationalnum1 + " is greater than " + rationalnum2);
        } else {
            System.out.println(rationalnum1 + " is less than " + rationalnum2);
        }

        input.close();
    }
}
