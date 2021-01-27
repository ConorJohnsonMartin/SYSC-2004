/**
 * @author Conor Johnson Martin 101106217
 * @date january 27th, 2021
 * @version Version 1
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

    public Robot fixRobot(Robot robot) {
        if (robot.getLine().equals(line1) || robot.getLine().equals(line2) || robot.getLine().equals(line3)) {
            if (!(robot.getFriend().equals(null))) {
                if (robot.getFriend().getLine().equals(line1) || robot.getFriend().getLine().equals(line2) || robot.getFriend().getLine().equals(line3)) {
                    return robot;
                } else {
                    robot.makeNewFriend(null);
                    return robot;
                }
            }
        }else{
            Robot roboto = new Robot(robot.getName()+ " - fixed", robot.getFriend(), line1);
            if (!(robot.getFriend().equals(null))) {
                if (robot.getFriend().getLine().equals(line1) || robot.getFriend().getLine().equals(line2) || robot.getFriend().getLine().equals(line3)) {
                    return roboto;
                } else {
                    roboto.makeNewFriend(null);
                    return roboto;
                }
            }
        }
        return null;
    }
}