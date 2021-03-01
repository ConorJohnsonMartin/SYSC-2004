/**
 * @author Conor Johnson Martin 101106217
 * @date February 28th, 2021
 * @version Version 1
 */

import java.util.ArrayList;

public class Corona extends Virus {

    private double mortRate;
    private int yearOfEmergence;

    /**
     * Default constructor for a Corona.
     */
    public Corona() {
        super("coronavirus", "COVID-02");
        mortRate = 0.005;
        yearOfEmergence = 2002;
    }

    /**
     * Constructor for class Corona.
     * @param mortRate is the rate of mortality.
     * @param yearOfEmergence is the year of emergence.
     * @param symptoms is an ArrayList of Strings of symptoms that are a result of Corona Virus.
     */
    public Corona(double mortRate, int yearOfEmergence, ArrayList<String> symptoms) {
        super("coronavirus", "COVID-" + (yearOfEmergence % 100));
        this.mortRate = mortRate;
        this.yearOfEmergence = yearOfEmergence;
    }

    /**
     * Constructor for class Corona with R0.
     * @param mortRate is the rate of mortality.
     * @param yearOfEmergence is the year of emergence.
     * @param R0 is the R0 rate.
     * @param symptoms is an ArrayList of Strings of symptoms that are a result of Corona Virus.
     */
    public Corona(double mortRate, int yearOfEmergence, double R0, ArrayList<String> symptoms) {
        super("coronavirus", "COVID-" + (yearOfEmergence % 100));
        this.mortRate = mortRate;
        this.yearOfEmergence = yearOfEmergence;
    }
}
