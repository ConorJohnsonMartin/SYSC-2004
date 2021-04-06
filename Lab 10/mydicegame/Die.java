/**
 * @author Conor johnson Martin 101106217
 * @date April 4th, 2021
 * @version Version 1
 */

import java.util.Random;

/**
 * A class that represents a die.
 */
public class Die {

    private int numberOfSides;

    /**
     * A default constructor for the Die class that sets the default numberOfSides to 6.
     */
    public Die(){
        this.numberOfSides = 6;
    }

    /**
     * A constructor for the Die class that initializes a provided value for the number of sides of a die.
     * @param numOfSides is the number of sides provided.
     */
    public Die(int numOfSides) {
        this.numberOfSides = numOfSides;
    }

    /**
     * A method that creates a random number simulating the roll of a die.
     * @return a random integer between the range 1 - numOfSides.
     */
    public int roll() {
        Random random = new Random();
        int randomRoll = random.nextInt(numberOfSides) + 1; //sets random numbers be in range from 1 - numOfSides
        return randomRoll;
    }
}