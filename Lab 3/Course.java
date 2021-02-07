/**
 * @author Conor Johnson Martin 101106217
 * @date February 3rd, 2021
 * @version Version 1
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
public class Course {

    private final String title;                     // title of the course
    private final String code;                      // course code
    private ArrayList<Student> enrolledStudents = new ArrayList<>();               // the number of students enrolled
    private Instructor instructor = null;                 // the name of the instructor of the course

    /**
     * Creates a new course with the supplied attributes. The number of students is by default 0.
     */
    public Course(String title, String code, ArrayList<Student> enrolledStudents, Instructor instructor) {
        this.title = title;
        this.code = code;
        this.enrolledStudents = enrolledStudents;
        this.instructor = instructor;
    }

    /**
     * Get this course's code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Get this course's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Increments the number of enrolled students.
     */
    public void addNewStudent(Student student) {
        if(enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    /**
     * Get the instructor of this course.
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Set the instructor of this course.
     */
    public void setInstructor(Instructor newInstructor) {
        instructor = newInstructor;
    }

    /**
     * A boolean that determines if course codes are the same.
     * @return true if they are equal. False otherwise.
     */
    public boolean isSameCourse(Course course) {
        if(this.code == course.code){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return the ArrayList of enrolledStudents.
     */
    public ArrayList<Student> getEnrolledStudents(){
        return enrolledStudents;
    }

    /**
     * Counts number of students in ArrayList enrolledStudents.
     * @return count, the number of students in the ArrayList.
     */
    public int countStudents(){
        int count = 0;
        for(Student s: enrolledStudents){
            count++;
        }
        return count;
    }
}