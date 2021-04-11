/**
 * @author Conor Johnson Martin 101106217
 * @date April 11th, 2021
 * @version Version 1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * A class that organizes the posts so that they are displayed correctly.
 */
public class PostWall {
    private final List<Post> wall = new ArrayList<>();

    /**
     * A method that calls the display method and then separates each post with a dashed line.
     */
    public void generate() {
        StringBuilder sb = new StringBuilder();
        for (Post p : wall) {
            p.display();
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * A method that adds a post to teh ArrayList wall.
     * @param p is the post being added to wall.
     */
    public void addPost(Post p) {
        wall.add(p);
    }
}
