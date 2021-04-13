/**
 * @name Conor Johnson Martin 101106217
 * @date April 13th, 2021
 */

package Store;

/**
 * A class that stores information about products being sold in a store.
 * NOTE: THIS CLASS WAS PROVIDED AS PART OF A STARTING POINT FOR MILESTONE 5
 * NOTE: Comments are my own because it is required I document code with Javadoc
 */
public class Product {
    public final double price;
    public final String name;
    public final int id;

    /**
     *A constructor for the class Store.Product.
     * @param price is the price of the product.
     * @param name is the name of the product.
     * @param id is the id of the product.
     */
    public Product(double price, String name, int id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }
}
