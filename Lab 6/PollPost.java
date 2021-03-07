/**
 * @author Conor Johnson Martin 101106217
 * @date March 2nd, 2021
 * @version Version 1
 */

import java.util.ArrayList;

/**
 * A class that represents a Post with and poll, including a question with answers.
 * This class utilizes the StringIntPair.java class which has been provided.
 */
public class PollPost extends Post {

    private ArrayList<StringIntPair> answers; //ArrayList of type StringIntPair class that will be used to display answers to the pool question.
    private String question;

    /**
     * A constructor for the PollPost class that initializes attributes.
     * @param author is the author of the post.
     * @param question is the question (a.k.a. the content) of the post.
     * @param answers is the ArrayList that stores the answers and is of type StringIntPair.
     */
    public PollPost(String author, String question, ArrayList<StringIntPair> answers) {
        super(author, question);
        this.answers = answers;
        this.question = question;
    }

    /**
     * A method that displays the PollPost in the correct format. This will override the display method in Post.java.
     */
    @Override
    public void display() {
        String line = "";
        for(StringIntPair answer: answers) {
            line += answer.s + " (" + answer.i + ")\n";
        }

        String s = String.format(
                getAuthor() + " on ("+ getTime() + "): \n" +
                        "'" + getContent() + "'\n" +
                        line +
                        "=)(" + (reactions[0]) + ") =|(" + (reactions[1]) + ") =((" + (reactions[2])+ ") =O(" + (reactions[3]) + ")\n" +
                        "Comments:"
        );
        System.out.println(s);
        for(Comment comment: comments){
            System.out.println(comment.toString());
        }
    }





}
