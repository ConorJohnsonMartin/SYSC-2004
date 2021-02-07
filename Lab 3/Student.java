/**
 * @author Conor Johnson Martin 101106217
 * @date February 3rd, 2021
 * @version Version 1
 */

import java.util.ArrayList;

public class Student {
    private String name;                                        // the student's name
    private String id;                                          // the student's id number
    private ArrayList<Course> courses = new ArrayList<>();      // courses the student is enrolled in
    private boolean fullLoad = false;                           // does the student have a full course load?

    /**
     * Create a new student with the supplied attributes. Courses and fullLoad are defaulted to 0/false.
     */
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Get the name of this student.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this student.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Get the id of this student.
     */
    public String getID() {
        return id;
    }

    /**
     * Set the id of this student.
     */
    public void setID(String newID) {
        id = newID;
    }

    /**
     * Add a course to this student's course list. A student can only be enrolled in 5 courses at a time.
     */
    public void addCourse(Course course) {
        if (!(this.courses.contains(course))) {
            if (!fullLoad) {
                courses.add(course);
                if (courses.size() == 5) fullLoad = true;
            }
        }
    }

    /**
     * Remove a course from this student's course list.
     */
    public void removeCourse(Course course) {
        if(this.courses.contains(course)){
            courses.remove(course);
            fullLoad = false;
        }
        if (courses.remove(course)) {
            fullLoad = false;
        }
    }

    /**
     * Print out the courses field.
     */
    public void printCourseList() {
        for (Course c : courses) {
            System.out.println(c.getTitle() + " " + c.getCode() + " Instructor:" + c.getInstructor());
        }
    }
}
