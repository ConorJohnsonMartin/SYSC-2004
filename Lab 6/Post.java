/**
 * @author Conor Johnson Martin 101106217
 * @date March 2nd, 2021
 * @version Version 1
 */

import java.util.ArrayList;
import java.util.Date;

/**
 * A class that represents a media Post.
 */
public class Post {

    private String author;       //name of the author of the post
    private Date time;           //time the post is made
    private String content;      //the content that is being posted
    int reactions[] = {0,0,0,0}; //an array that stores the number of times certain reactions are reacted to
    ArrayList<Comment> comments; //an ArrayList that stores all of the comments from the Comment class

    /**
     * A constructor for the Post class that initializes parameters and attributes.
     * @param author is the author of the post.
     * @param content is the content that is being posted.
     */
    public Post(String author, String content) {
        this.author = author;
        this.content = content;
        time = new Date();
        comments = new ArrayList<Comment>();
    }

    /**
     * An accessor method that gets the author of the post.
     * @return the name of the author of the post, type String.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * An accessor method that gets the time the post is made.
     * @return the date and time the post is made.
     */
    public Date getTime() {
        return time;
    }

    /**
     * An accessor method that gets the content of the post that is being shared.
     * @return the content of the post.
     */
    public String getContent() {
        return content;
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

