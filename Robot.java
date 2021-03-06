/**
 * @author Conor Johnson Martin 101106217
 * @date January 27th, 2021
 * @version Version 4
 */

public class Robot {

    private String name;                                                            // name of Robot
    private Robot friend = null;                                                    // this Robot's friend
    private String line = "You ain't nothin' but a hound dog, cryin' all the time"; // lines this Robot knows

    /**
     * Constructor for the Robot class that initializes parameter name.
     * @param name represents the name of the robot, type string.
     */

    public Robot(String name) {
        this.name = name;
    }

    /**
     * Constructor for the Robot class that initializes parameters name and friend.
     * @param name represents the name of the robot, type string.
     * @param friend represents the friend of this robot, type robot.
     */

    public Robot(String name, Robot friend){
        this.name = name;
        this.friend = friend;
    }

    /**
     * Constructor for the Robot class that initializes parameters name, friend, and line.
     * @param name represents the name of the robot, type string.
     * @param friend represents the friend of this robot, type robot.
     * @param line represents the line associated to this robot, type string.
     */

    public Robot (String name, Robot friend, String line) {
        this.name = name;
        this.friend = friend;
        this.line = line;
    }

    /**
     * Appends a line to each robot.
     * @param line is of type string.
     */

    public void appendLine(String line) {
        this.line = line;
    }

    /**
     * Get this Robot to say its assigned line.
     * @return line.
     */

    public String speak() {
        return line;
    }

    /**
     * Get this Robot's friend to say its assigned line.
     * @return line.
     */

    public String friendSpeak() {
        if (friend == null) {
            return "I have no friend :(";
        }
        return friend.speak();
    }

    /**
     * Get the line associated with the Robot.
     * @return line of type string.
     */

    public String getLine() {
        return line;
    }

    /**
     * Get the friend of the current robot.
     * @return friend of type Robot.
     */

    public Robot getFriend() {
        return friend;
    }

    /**
     * Sets friend of robot.
     * @param friend is set to the desired friend.
     */

    public void makeNewFriend(Robot friend) {
        this.friend = friend;
    }

    /**
     * Get the name of the current robot.
     * @return the name.
     */

    public String getName() {
        return name;
    }

}
