/**
 * @author Conor Johnson Martin 101106217
 * @date April 11th, 2021
 * @version Version 1
 */

/**
 * Post interface that initializes three necessary methods.
 */
public interface Post {

    /**
     * A method that increments the values associated with different elements in the reactions array.
     * @param r represents the index in the reactions array we are incrementing.
     *          reactions has a size of 4, therefore r must be from 0-3.
     */
    void react(int r);

    /**
     * A method that adds a comment to the ArrayList comments.
     * @param cp is the comment that we are adding to comments.
     */
    void addComment(Comment cp);

    /**
     * A method that correctly displays the information being posted.
     */
    void display();
}
