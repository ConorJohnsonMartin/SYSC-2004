/**
 * @author Conor Johnson Martin 101106217
 * @date February 15th, 2021
 * @version Version 1
 */

/**
 * Package mymath contains Poly.java and PolyCalc.java.
 */
package mymath;

/**
 * A class titled Poly that models a Polynomial of the form Ax^n-1 + Bx^n-2 ... Ux^3 + Wx^2 + Y^x + Z.
 * This class uses an array of doubles to model the polynomial's coefficients.
 */
public class Poly {
    private double[] polynomial;

    /**
     * Constructor for the Poly class that initializes an array of doubles.
     * @param polynomial is the reference to the array of doubles.
     */
    public Poly(double[] polynomial) {
        this.polynomial = polynomial;
    }

    /**
     * A method that evaluates the polynomial at a given value x.
     * @param x is the value a user will pass into the polynomial.
     * @return double count, the calculated y value for a given x.
     */
    public double evaluate(int x) {
        int polyLength = polynomial.length;
        double count = 0.0;
        for (int i = 0; i < polyLength; i++) {
            double newCount = polynomial[i] * Math.pow(x, ((polyLength - 1) - i));
            count += newCount;
        }
        return count;
    }

    /**
     * A method that prints the polynomial passed in the array of doubles in the correct format.
     */
    public void printPoly(){
        String poly = null;
        String addSub = null;
        int polyLength = polynomial.length;
        int count = 0;
        for (int i = 0; i < polyLength; i++) {
            if (i == 0 || count == 0) {
                addSub = "";
            }
            else if(polynomial[i] < 0) {
                addSub = " ";
            }else{
                addSub = " + ";
            }
            if(i == (polyLength-1) && !(polynomial[i]==0)) {
                String newPoly = addSub + polynomial[i];
                System.out.print(newPoly);
                count++;
            }
            else if(!(polynomial[i]==0)) {
                String newPoly = addSub + polynomial[i] + "x^" + ((polyLength - 1)-i);
                System.out.print(newPoly);
                count++;
            }else{
                System.out.print("");
            }
        }
    }

    /**
     * Accesses the array of doubles, polynomial.
     * @return the array of doubles.
     */
    public double[] getPolynomial() {
        return polynomial;
    }
}
