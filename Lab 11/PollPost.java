/**
 * @author Conor Johnson Martin 101106217
 * @date April 11th, 2021
 * @version Version 1
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A class that builds a post capable of polling a variety of pollAnswers and displaying each pollAnswers frequency.
 */
public class PollPost implements Post {

    private final String author;
    private final String content;
    private final List<StringIntPair> pollAnswers = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private final int[] reactions = new int[4];
    private final String time = Calendar.getInstance().getTime().toString();

    /**
     * A constructor for the PollPost class that initializes attributes.
     * @param authors is the author of the post.
     * @param contents is the content of the post.
     */
    public PollPost(String authors, String contents) {
        this.author = authors;
        this.content = contents;
    }

    /**
     * A method that correctly displays the information being posted.
     */
    public void display() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sc = new StringBuilder();
        for (StringIntPair pair : pollAnswers) {
            sb.append(pair.s).append(" (").append(pair.i).append(")\n");
        }

        for (Comment c : comments) {
            sc.append("-> ")
                    .append(c.getDisplay())
                    .append("\n");
        }

        String s = String.format(
                "%s on (%s):\n" +
                        "'%s'\n" +
                        "%s" +
                        "\uD83D\uDE00(%d) \uD83D\uDE43(%d) \uD83D\uDE12(%d) \uD83D\uDE2F(%d)\n" +
                        "Comments:\n" +
                        "%s",
                author, time, content, sb.toString(),
                reactions[0], reactions[1], reactions[2], reactions[3], sc.toString()
        );
        System.out.println(s);
    }

    /**
     * A method that takes pollAnswers and displays the frequency each pollAnswer is said.
     * @param s is teh reaction that is being added to the ArrayList pollAnswers.
     */
    public void react(String s) {
        for (int i = 0; i < pollAnswers.size(); i++) {
            StringIntPair pair = pollAnswers.get(i);
            if (s.equals(pair.s)) {
                pollAnswers.set(i, new StringIntPair(s, pair.i + 1));
                return;
            }
        }
        pollAnswers.add(new StringIntPair(s, 1));
    }

    /**
     * A method that increments the values associated with different elements in the reactions array.
     * @param r represents the index in the reactions array we are incrementing.
     *          reactions has a size of 4, therefore r must be from 0-3.
     */
    public void react(int r) {
        reactions[r]++;
    }

    /**
     * A method that adds a comment to the ArrayList comments.
     * @param cp is the comment that we are adding to comments.
     */
    public void addComment(Comment cp) {
        comments.add(cp);
    }
}
