/**
 * @author Conor Johnson Martin 101106217
 * @date January 27th, 2021
 * @version Version 2
 */

public class RobotBouncer {
    private String line1;
    private String line2;
    private String line3;

    /**
     * Constructor that sets line1, line2, and line3 to their specific Robot pass-phrase
     */
    public RobotBouncer(String line1, String line2, String line3) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    /**
     * Method fixRobot determines if the selected robot is an imposter by comparing its stored line to lines 1, 2, or 3.
     * If the Robot's line is equal to line 1, 2, or 3, then we check first if this robot has a friend.
     * If the Robot has a friend, then we check the friends line to assess if the friends line is equal to line 1, 2 or 3.
     * If the Robots friends line is equal to line 1, 2, or 3, we return the original robot.
     * If the Robots friend does not pass, we remove this robot as a friend by setting the robots friend to null.
     * Then, we return the Robot.
     * If the original Robots line is not equal to line 1, 2, or 3, then we create a new robot that has the same name, except we append a " - fixed" to their name.
     * We also set this new Robots friends to its original friend, and replace the wrong line with one of the correct lines, line 1, 2, or 3.
     * If the new Robots friend is not null, then we will test the new Robots friend and see if teh friends line is equal to line 1, 2, or 3.
     * If the friends line is equal to 1, 2, or 3, then return the new Robot, in this case, "roboto". If the friends line is not equal, then reset friend to null.
     * @param robot the robot that is assessed.
     * @return robot and roboto, roboto only if the original robot we are passed does not have an equal line to line 1, 2 or 3.
     */

    public Robot fixRobot(Robot robot) {
        if (robot.getLine().equals(line1) || robot.getLine().equals(line2) || robot.getLine().equals(line3)) {
            if (!(robot.getFriend().equals(null))) {
                if (robot.getFriend().getLine().equals(line1) || robot.getFriend().getLine().equals(line2) || robot.getFriend().getLine().equals(line3)) {
                    return robot;
                } else {
                    robot.makeNewFriend(null);
                    return robot;
                }
            }else{
                return robot;
            }
        }else {
            Robot roboto = new Robot(robot.getName() + " - fixed", robot.getFriend(), line1);
            if (!(robot.getFriend().equals(null))) {
                if (robot.getFriend().getLine().equals(line1) || robot.getFriend().getLine().equals(line2) || robot.getFriend().getLine().equals(line3)) {
                    return roboto;
                } else {
                    roboto.makeNewFriend(null);
                    return roboto;
                }
            } else {
                return roboto;
            }
        }
    }
}
