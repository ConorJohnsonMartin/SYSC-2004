/**
 * @author Conor Johnson Martin 101106217
 * @date February 10th, 2021
 * @version Version 3
 */

package Store;

/**
 * A class that stores information about products being sold in a store.
 */
public class Product {
    private String name;
    private int id;
    private double price;

    /**
     * A constructor for the class Store.Product.
     * @param name is the name of the product.
     * @param id is the id of the product.
     * @param price is the price of the product.
     */
    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    /**
     * A method that gets the id.
     * @return id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * A method that gets the name.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * A method that gets the price.
     * @return price.
     */
    public double getPrice() {
        return this.price;
    }

}
