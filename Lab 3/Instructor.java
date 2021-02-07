import java.util.ArrayList;

/**
 * @author Conor Johnson Martin 101106217
 * @date February 3rd, 2021
 * @version Version 1
 */

public class Instructor {
    private String name;
    private String department;
    private boolean tenure;
    private ArrayList<Student> numStudents = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public Instructor(String name, String department, boolean tenure) {
        this.name = name;
        this.department = department;
        this.tenure = tenure;
    }

    public Instructor(String name, String department, boolean tenure, ArrayList<Student> numStudents, ArrayList<Course> courses) {
        this.name = name;
        this.department = department;
        this.tenure = tenure;
        this.numStudents = numStudents;
        this.courses = courses;
    }

    /**
     * Accessor to get name of instructor.
     * @return name.
     */

    public String getName() {
        return name;
    }

    /**
     * Accessor to get the department of the instructor.
     * @return department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Accessor to get the tenure of the instructor.
     * @return tenure.
     */
    public boolean getTenure() {
        return tenure;
    }

    /**
     * Mutator to set tenure;
     * @param newValue of type boolean.
     */
    public void setTenure(boolean newValue) {
        tenure = newValue;
    }

    /**
     * This method assigns a new course to the instructor depending on if:
     * 1. if the instructor is already assigned to the course.
     * 2. if the new course does not bring the total number of students over 500.
     * This function also adds all students to the ArrayList numStudents.
     * Instructor is assigned to the course.
     * @param course
     * @return true if course is assigned to the instructor. Otherwise, false.
     */
    public boolean assignNewCourse(Course course) {
        if(!courses.contains(course)) {
            if(getNumStudents() + course.countStudents() <= 500) {
                courses.add(course);
                numStudents.addAll(course.getEnrolledStudents());
                Instructor instructor = new Instructor(name, department, tenure);
                course.setInstructor(instructor);
                return true;
            }
        }
        return false;
    }

    /**
     * Gets number of students already in numStudents.
     * @return count of number of students in ArrayList numStudents.
     */
    public int getNumStudents(){
        int count = 0;
        for(Student s: numStudents){
            count++;
        }
        return count;
    }
}