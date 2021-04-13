/**
 * @name Conor Johnson Martin 101106217
 * @date April 13th, 2021
 */

package Store;

/**
 * A class that organizes a product and pairs it with the stock of this product.
 * NOTE: THIS CLASS WAS PROVIDED AS PART OF A STARTING POINT FOR MILESTONE 5
 * NOTE: Comments are my own because it is required I document code with Javadoc
 */
public class ProductStockPair {

    public final Product product;
    public final int stock;

    /**
     * A constructor for the ProductStockPair class.
     * @param product is the product being paired with stock.
     * @param stock is the number of stock added to the product.
     */
    public ProductStockPair(Product product, int stock) {
        this.product = product;
        this.stock = stock;
    }
}

