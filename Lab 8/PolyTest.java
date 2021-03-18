/**
 * @author Conor Johnson Martin
 * @date March 17th, 2021
 * @version Version 1
 */

import mymath.Poly;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * A class to test the Poly class.
 */
public class PolyTest {
    Poly poly;
    ArrayList<double[]> testCases;
    double[] finalResults;

    /**
     * Initializes an ArrayList of testCases containing arrays of doubles.
     * Also initialized an array of doubles called finalResults that stores expected solutions for the evaluation method in Poly.
     *
     * finalResults[0] corresponds to the first array of doubles in testCases.
     * finalResults[1] corresponds to the second array of doubles in testCases.
     * finalResults[2] corresponds to the third array of doubles in testCases.
     * etc...
     *
     * I am testing 5 different cases:
     * -Regular coefficients
     * -Regular coefficients with negative values
     * -All coeffieicents are zeros
     * -Regular coefficients with one zero
     * -Leading zeros followed by regular coefficients
     */
    @Before
    public void init() {
        ArrayList<double[]> testCases = new ArrayList<>();
        testCases.add(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0});    //baseCaseCoefficients
        testCases.add(new double[]{-1.0, 2.0, -3.0, 4.0, -5.0, 6.0}); //baseCaseWithNegativeCoefficients
        testCases.add(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});         //arrayOfZeros
        testCases.add(new double[]{1.0, 2.0, 0.0, 4.0, 5.0, 6.0});    //arrayWithOneZero
        testCases.add(new double[]{0.0, 0.0, 1.0, 2.0, 3.0});         //arrayWithLeadingZeros
        double[] finalResults = {120.0, -12.0, 0.0, 96.0, 11.0};      //These results have been calculated when x = 2.0 and correspond to each array in testCases.
    }

    /**
     * This tests the constructor in Poly, ensuring coefficients are stored correctly.
     * This test iterates through the ArrayList of testCases, passing the first element of the ArrayList (an array of doubles) to the newly created Poly object.
     * Asserts if the array of coefficients passed to the newly created poly object match the array of coefficient in testCases.
     */
    @Test
    public void constructorTest() {
        for(int i = 0; i < testCases.size(); i++) {
            Poly poly = new Poly(testCases.get(i));
            Assert.assertArrayEquals(poly.getCoeffs(), testCases.get(i), 0.000000000001);
        }
    }

    /**
     * This tests the Poly evaluate method.
     * This test iterates through the ArrayList of testCases, passing the first element of the ArrayList (an array of doubles) to the newly created Poly object.
     * Asserts if the returned double matches the corresponding index in the array of finalResults.
     */
    @Test
    public void evaluateTest1() {
        double x = 2.0;
        for(int i = 0; i < testCases.size(); i++) {
            Poly poly = new Poly(testCases.get(i));
            Assert.assertEquals(poly.evaluate(x), finalResults[i]);
        }
    }

    /**
     * Nullifies the Poly objects that are created.
     */
    @After
    public void tearDown() {
        poly = null;
    }
}