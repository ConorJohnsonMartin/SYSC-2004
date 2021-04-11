/**
 * @author Conor Johnson Martin 101106217
 * @date April 11th, 2021
 * @version Version 1
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A class that builds a post whose content is a message (String).
 */
public class MessagePost implements Post {

    private final String author;
    private final String content;
    private final List<Comment> comments = new ArrayList<>();
    private final int[] reactions = new int[4];
    private final String time = Calendar.getInstance().getTime().toString();

    /**
     * A constructor for the MessagePost class that initializes attributes.
     * @param authors is the author of the post.
     * @param contents is the content of the post.
     */
    public MessagePost(String authors, String contents) {
        this.author = authors;
        this.content = contents;
    }

    /**
     * A method that adds a comment to the ArrayList comments.
     * @param cp is the comment that we are adding to comments.
     */
    public void addComment(Comment cp) {
        comments.add(cp);
    }

    /**
     * A method that correctly displays the information being posted.
     */
    public void display() {
        StringBuilder sb = new StringBuilder();
        for (Comment c : comments) {
            sb.append("-> ")
                    .append(c.getDisplay())
                    .append("\n");
        }

        String s = String.format(
                "%s on (%s):\n" +
                        "'%s'\n" +
                        "\uD83D\uDE00(%d) \uD83D\uDE43(%d) \uD83D\uDE12(%d) \uD83D\uDE2F(%d)\n" +
                        "Comments:\n" +
                        "%s",
                author, time, content, reactions[0], reactions[1], reactions[2], reactions[3], sb.toString()
        );
        System.out.println(s);
    }

    /**
     * A method that increments the values associated with different elements in the reactions array.
     * @param r represents the index in the reactions array we are incrementing.
     *          reactions has a size of 4, therefore r must be from 0-3.
     */
    public void react(int r) {
        reactions[r]++;
    }
}
