/**
 * @author Conor Johnson Martin 101106217
 * @date February 15th, 2021
 * @version Version 1
 */

/**
 * Package mymath contains Poly.java and PolyCalc.java.
 */
package mymath;
import java.util.Arrays;

/**
 * A utility class that can differentiate or integrate the polynomial passed.
 */
public class PolyCalc {

    /**
     * A method to differentiate a polynomial, which has been stored in an array of doubles.
     * @param poly of type Poly represents an array of doubles that is passed to method.
     * @return a differentiated version of the original polynomial of type Poly.
     */
    public static Poly differentiate(Poly poly) {
        double[] polynomial = poly.getPolynomial();
        int polyLength = polynomial.length;
        for (int i = 0; i < polyLength; i++) {
            polynomial[i] = polynomial[i] * ((polyLength - 1) - i);
        }
        Poly newPoly = new Poly(polynomial);
        return newPoly;
    }

    /**
     * A method to integrate a polynomial, which has been stored in an array of doubles.
     * @param poly of type Poly represents an array of doubles that is passed to method.
     * @return an integrated version of the original polynomial stored in a new array of doubles that accommodates for a growing during integration of type Poly.
     */
    public static Poly integrate(Poly poly) {
        double[] polynomial = poly.getPolynomial();
        int polyLength = polynomial.length;
        for (int i = 0; i < polyLength; i++) {
            double j = 1.0 / (polyLength - i);
            polynomial[i] = polynomial[i] * (j);
        }
        double[] integratedPoly = Arrays.copyOf(polynomial, (polyLength + 1));
        integratedPoly[polyLength] = 0;
        Poly newPoly = new Poly(integratedPoly);
        return newPoly;
    }
}