/**
 * @author Conor Johnson Martin 101106217
 * @date March 2nd, 2021
 * @version Version 1
 */

import java.util.Date;

/**
 * A class that represents a comment that can be made on a Post.
 */
public class Comment {

    private Date time;
    private String author;
    private String content;

    /**
     * A constructor for the Comment class that initializes attributes.
     * @param author is the author of the comment.
     * @param content is the actual comment that is being added to the post.
     */
    public Comment(String author, String content) {
        this.author = author;
        this.content = content;
        time = new Date();
    }

    /**
     * A method that formats the comment in teh appropriate way.
     * @return a String that includes the full comment, with authors name and the time the comment is made.
     */
    public String toString() {
        return "-> '" + this.content + "' - " + this.author + "(" + this.time + ")";
    }
}
