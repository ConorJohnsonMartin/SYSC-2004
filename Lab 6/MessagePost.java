/**
 * @author Conor Johnson Martin 101106217
 * @date March 2nd, 2021
 * @version Version 1
 */

import java.util.ArrayList;
import java.util.Date;

/**
 * A class that represents a Post whose content is simply a message.
 */
public class MessagePost extends Post{

    private int reactions[] = {0,0,0,0};
    private ArrayList<Comment> comments;
    private Date time;

    /**
     * A constructor for the MessagePost class that initializes parameters and attributes.
     * @param author is the author of the post.
     * @param content is the content that is being posted.
     */
    public MessagePost(String author, String content) {
        super(author, content);
        time = new Date();
        comments = new ArrayList<Comment>();
    }

    /**
     * An accessor method that gets the time the post is made.
     * @return the date and time the post is made.
     */
    public Date getTime() {
        return time;
    }

    /**
     * A method that stores the number of times a specific reaction is used.
     * @param value is the int that represents each reaction. ex. =) is value 0, =| is value 1, etc...
     */
    public void react(int value) {
        if(value == 0) {
            reactions[0]++;
        }
        if(value == 1) {
            reactions[1]++;
        }
        if(value == 2) {
            reactions[2]++;
        }
        if(value == 3) {
            reactions[3]++;
        }
    }

    /**
     * A method that adds a comment to the ArrayList comments.
     * @param comment is the comment being added to the ArrayList comments.
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * A method that displays the Post.
     */
    public void display() {

        String s = String.format(
                getAuthor() + " on ("+ getTime() + "): \n" +
                        "'" + getContent() + "'\n" +
                        "=)(" + (reactions[0]) + ") =|(" + (reactions[1]) + ") =((" + (reactions[2])+ ") =O(" + (reactions[3]) + ")\n" +
                        "Comments:"
        );
        System.out.println(s);
        for(Comment comment: comments){
            System.out.println(comment.toString());
        }
    }
}

