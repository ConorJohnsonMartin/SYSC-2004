/**
 * @author Conor Johnson Martin 101106217
 * @date March 2nd, 2021
 * @version Version 1
 */

/**
 * A subclass that extends Post, specified for posts regarding video clips.
 * PLEASE NOTE: WHEN TESTING THE CLASS, IF THE FAKE URL CONTAINS "%" SYMBOLS, THE CODE WILL NOT EXECUTE CORRECTLY.
 * REMOVE THE "%" SYMBOLS FROM TEH URL AND THE METHOD WILL WORK PERFECTLY!!!
 */
public class VideoPost extends Post {

    /**
     * A constructor for the VideoPost class that utilizes super to update Post.java.
     * @param author is the author of the post.
     * @param content is teh content being posted.
     */
    public VideoPost(String author, String content) {
        super(author, content);
    }

    /**
     * A method that overrides the display method in post to add in a String above the display.
     * Then, calls super.display to access the display method in Post.java.
     */
    @Override
    public void display() {
        System.out.println("-VIEWER DISCRETION ADVISED-");
        super.display();
    }
}
