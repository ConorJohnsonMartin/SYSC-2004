/**
 * @author Conor Johnson Martin
 * @date March 17th, 2021
 * @version Version 1
 */

import mymath.Poly;
import mymath.PolyCalc;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * A class to test the PolyCalc class.
 */
public class PolyCalcTest {
    Poly poly;
    PolyCalc polyCalc;
    ArrayList<double[]> testCases;
    ArrayList<double[]> differentiatedTestCases;
    ArrayList<double[]> integratedTestCases;

    /**
     * Initializes three ArrayLists containing arrays of doubles.
     * ArrayLists for testCases, differenitiatedTestCases, and integratedTestCases.
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
        ArrayList<double[]> differentiatedTestCases = new ArrayList<>();
        testCases.add(new double[]{5.0, 8.0, 9.0, 8.0, 5.0});
        testCases.add(new double[]{-5.0, 8.0, -9.0, 8.0, -5.0});
        testCases.add(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        testCases.add(new double[]{5.0, 8.0, 0.0, 8.0, 5.0});
        testCases.add(new double[]{0.0, 0.0, 2.0, 2.0});
        ArrayList<double[]> integratedTestCases = new ArrayList<>();
        testCases.add(new double[]{0.166, 0.4, 0.75, 1.333, 2.5, 6.0, 0.0});
        testCases.add(new double[]{-0.166, 0.4, -0.75, 1.333, -2.5, 6.0, 0.0});
        testCases.add(new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0});
        testCases.add(new double[]{0.166, 0.4, 0.0, 1.333, 2.5, 6.0, 0.0});
        testCases.add(new double[]{0.0, 0.0, 0.333, 1.0, 3.0, 0.0});
    }

    /**
     * This tests the PolyCalc differentiate method.
     * This test iterates through the ArrayList of testCases, passing the first element of the ArrayList (an array of doubles) to the newly created Poly object.
     * Asserts if the PolyCalc.differentiate function's returned array of doubles matches the expected solution.
     * The solution is stored in the differentiatedTestCases ArrayList at the corresponding index.
     */
    @Test
    public void differentiateTest() {
        for(int i = 0; i < testCases.size(); i++) {
            Poly poly = new Poly(testCases.get(i));
            Assert.assertEquals(PolyCalc.differentiate(poly), differentiatedTestCases.get(i));
        }
    }

    /**
     * This tests the PolyCalc integrate method.
     * This test iterates through the ArrayList of testCases, passing the first element of the ArrayList (an array of doubles) to the newly created Poly object.
     * Asserts if the PolyCalc.integrate function's returned array of doubles matches the expected solution.
     * The solution is stored in the integratedTestCases ArrayList at the corresponding index.
     */
    @Test
    public void integrateTest() {
        for(int i = 0; i < testCases.size(); i++) {
            Poly poly = new Poly(testCases.get(i));
            Assert.assertEquals(PolyCalc.integrate(poly), integratedTestCases.get(i));
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