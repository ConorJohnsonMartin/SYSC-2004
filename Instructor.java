/**
 * @author Conor Johnson Martin 101106217
 * @date January 19th, 2021
 * @version Version 1
 */

public class Instructor {
    private String name;           //the instructors name
    private String department;     //the instructors department
    private boolean tenure;        //does the instructor have tenure?
    private int numStudents;       //the number of students an instructor teaches

    /**
     * Constructor for instructor class.
     */
    public Instructor(String name, String department){
        this.name = name;
        this.department = department;
        tenure = false;
        numStudents = 0;
    }

    /**
     * Get the name of this instructor.
     */
    public String getName(){
        return name;
    }

    /**
     * Get the department of this instructor.
     */
     public String getDepartment(){
         return department;
    }

    /**
     * Get the tenure status of this instructor.
     */
    public boolean getTenure(){
        return tenure;
    }

    /**
     * Set the tenure status of this instructor.
     */
    public void setTenure(boolean newTenure){
        tenure = newTenure;
    }

    /**
     * Get the number of students this instructor teaches.
     */
    public int getNumStudents(){
        return numStudents;
    }

    /**
    * Method to assign new course.
    */
    public boolean assignNewCourse(int newNumStudents){
        if((numStudents + newNumStudents) > 500){
            return false;

        }else{
            numStudents = numStudents + newNumStudents;
            return true;
        }
    }
}