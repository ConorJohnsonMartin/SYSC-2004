import java.util.ArrayList;

/**
 * A Virus.
 */
public class Virus {

    private String family;
    private String species;
    private double r0;
    private ArrayList<String> symptoms;

    /**
     * Default constructor.
     */
    public Virus() {
        this("", "", 1.0, new ArrayList<String>());
    }

    /**
     * Constructor for a Virus.
     *
     * @param family    String, the family
     * @param species   String, the species
     */
    public Virus(String family, String species) {
        this(family, species, 1.0, new ArrayList<String>());
    }

    /**
     * Constructor for a Virus.
     *
     * @param family    String, the family
     * @param species   String, the species
     * @param r0        double, the r0 rate
     */
    public Virus(String family, String species, double r0) {
        this(family, species, r0, new ArrayList<String>());
    }

    /**
     * Constructor for a Virus.
     *
     * @param family    String, the family
     * @param species   String, the species
     * @param symptoms  ArrayList<String>, list of symptoms
     */
    public Virus(String family, String species, ArrayList<String> symptoms) {
        this(family, species, 1.0, symptoms);
    }

    /**
     * Constructor for a Virus.
     *
     * @param family    String, the family
     * @param species   String, the species
     * @param r0        double, the r0 rate
     * @param symptoms  ArrayList<String>, list of symptoms
     */
    public Virus(String family, String species, double r0, ArrayList<String> symptoms) {
        this.family = family;
        this.species = species;
        this.r0 = r0;
        this.symptoms = symptoms;
    }

    /**
     * Update characteristics of the Virus.
     *
     * @param newR0         double, the new r0 value
     * @param newSymptoms   ArrayList<String>, new list of symptoms
     */
    public void evolve(double newR0, ArrayList<String> newSymptoms) {
        r0 = newR0;
        symptoms = newSymptoms;
    }

    /**
     * Get Virus symptoms.
     *
     * @return  String, list of symptoms
     */
    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    /**
     * Get Virus r0.
     *
     * @return  double, the r0 value
     */
    public double getR0() {
        return r0;
    }

    /**
     * Get Virus family.
     *
     * @return  String, the family
     */
    public String getFamily() {
        return family;
    }

    /**
     * Set Virus family.
     *
     * @param newFamily String, new family
     */
    public void setFamily(String newFamily) {
        family = newFamily;
    }

    /**
     * Get Virus species.
     *
     * @return  String, the species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Set Virus species.
     *
     * @param newSpecies    String, new species
     */
    public void setSpecies(String newSpecies) {
        species = newSpecies;
    }
}
