/**
 * @author Conor Johnson Martin 101106217
 * @date February 28th, 2021
 * @version Version 1
 */

/**
 * A class that represents a Person.
 */
public class Person {
    private String name;
    private int age;

    /**
     * A default constructor for the Person class.
     */
    public Person(){
        this("", 0);
    }

    /**
     * A constructor for the Person class that initializes attributes name and age.
     * @param name represents the name of a person.
     * @param age represents the age of a person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * A method to access the name of a person.
     * @return the name of a person.
     */
    public String getName() {
        return name;
    }

    /**
     * A method to mutate the name of a person.
     * @param name is the name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method to access the age of a person.
     * @return the age of a person.
     */
    public int getAge() {
        return age;
    }

    /**
     * A method to mutate the age of a person.
     * @param age is the age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }
}
