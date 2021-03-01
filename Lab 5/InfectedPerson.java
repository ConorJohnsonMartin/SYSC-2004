/**
 * @author Conor Johnson Martin 101106217
 * @date February 28th, 2021
 * @version Version 1
 */

import java.util.ArrayList;

/**
 * A subclass of Person, this class describes an infected person that will compare symptoms to known viruses.
 */
public class InfectedPerson extends Person {
    private ArrayList<String> underlyingConditions;
    private ArrayList<String> symptoms;
    private Corona diagnosis;

    /**
     * An InfectedPerson constructor that initializes all fields and sets diagnosis to null.
     * @param underlyingConditions is an ArrayList of Strings containing a Person's underlying medical conditions.
     * @param symptoms is an ArrayList of Strings containing the symptoms a Person is feeling.
     */
    public InfectedPerson(ArrayList<String> underlyingConditions, ArrayList<String> symptoms) {
        this.underlyingConditions = underlyingConditions;
        this.symptoms = symptoms;
        diagnosis = null;
    }

    /**
     * An InfectedPerson constructor that initializes all fields and sets diagnosis to null.
     * @param underlyingConditions is an ArrayList of Strings containing a Person's underlying medical conditions.
     * @param symptoms is an ArrayList of Strings containing the symptoms a Person is feeling.
     * @param name is a String that represents the name of a person.
     * @param age is an int that represents the age of a person.
     */
    public InfectedPerson(ArrayList<String> underlyingConditions, ArrayList<String> symptoms, String name, int age) {
        super(name, age);   //assures Person parent class are passed the Name and Age.
        this.underlyingConditions = underlyingConditions;
        this.symptoms = symptoms;
        diagnosis = null;
    }

    /**
     * A method to access the ArrayList of Strings of underlyingConditions of a person.
     * @return the underlyingConditions.
     */
    public ArrayList<String> getUnderlyingConditions() {
        return underlyingConditions;
    }

    /**
     * A method to access the ArrayList of Strings of symptoms of a person.
     * @return the symptoms.
     */
    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    /**
     * A method to access the diagnosis of a person.
     * @return the diagnosis.
     */
    public Corona getDiagnosis() {
        return diagnosis;
    }

    /**
     * A method that can mutate the ArrayList of Strings of underlyingConditions.
     * If the condition is not already in underlyingConditions then it will be added.
     * @param condition is a condition of type String that may be added to the ArrayList.
     */
    public void setUnderlyingConditions(String condition) {
        if(!(underlyingConditions.contains(condition))) {
            underlyingConditions.add(condition);
        }
    }

    /**
     * A method that can mutate the ArrayList of Strings of symptoms.
     * If the new symptom is not already in symptoms then it will be added.
     * @param symptom is a symptom of type String that may be added to the ArrayList.
     */
    public void setSymptoms(String symptom) {
        if(!(symptoms.contains(symptom))) {
            symptoms.add(symptom);
        }
    }

    /**
     * Determines if a Person should or should not be diagnosed with Corona, based off if 75% of the symptoms are experienced.
     * @param corona is of type Corona is used to compare the person's active symptoms to the symptoms specific to Corona Virus.
     * @return true if a person has 75%  or more of the symptoms. false if they do not have 75% of the symptoms.
     */
    public boolean isSymptomatic(Corona corona) {
        double count = 0.0;
        ArrayList<String> coronaSymptoms = corona.getSymptoms();
        int size = coronaSymptoms.size();
        for (String symptom: coronaSymptoms) {
            if (symptoms.contains(symptom)) {
                count++;
            }
        }
        if (count / size >= 0.75) {
            diagnosis = corona;
            return true;
        } else {
            return false;
        }
    }

}


















