/**
 * @author Conor Johnson Martin 101106217
 * @date April 13th, 2021
 * @version Version 1
 */

package Store;

/**
 * An interface that defines behaviours that need to be apart of classes that manage the Product-Stock collection.
 */
public interface ProductStockContainer {

    /**
     * Get the quantity of the stock of the product.
     * @param p is the product checked for quantity.
     * @return the stock of the product if it exists in the ArrayList products.
     */
    int getProductQuantity(Product p);

    /**
     * A method that adds stock to the ArrayList products.
     * @param p is the product being added.
     * @param i is the stock of the product being added.
     */
    void addProductQuantity(Product p, int i);

    /**
     * A method that removes stock from the ArrayList products.
     * @param p is the product being removed.
     * @param i is the stock of the product being removed.
     * @return true if the product's stock gets removed.
     */
    boolean removeProductQuantity(Product p, int i);

    /**
     * Get the number of products in the ArrayList products.
     * @return numOfProducts which is incremented everytime a product is added to products ArrayList.
     */
    int getNumOfProducts();

}
