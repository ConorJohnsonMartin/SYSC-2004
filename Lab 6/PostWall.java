/**
 * @author Conor Johnson Martin 101106217
 * @date March 2nd, 2021
 * @version Version 1
 */

import java.util.ArrayList;

/**
 * A class that combines multiple posts and will separate them by a dashed line.
 */
public class PostWall {

    private ArrayList<Post> postWall;

    /**
     * A constructor for the PostWall class that initializes an ArrayList that will contain all of the Post objects.
     */
    public PostWall() {
        postWall = new ArrayList<>();
    }

    /**
     * A mutator method that adds the Post object to the ArrayList.
     * @param post is the post that is being added to the ArrayList.
     */
    public void addPost(Post post) {
        postWall.add(post);
    }

    /**
     * A method that alters the display of the posts to add a dashed line in between posts
     */
    public void generate() {
        for(Post post: postWall){
            post.display();
            System.out.println("--------------------------------------------------");
        }
    }
}
