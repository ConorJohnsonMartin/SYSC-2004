/**
 * @name Conor Johnson Martin 101106217
 * @date April 13th, 2021
 */

package Store;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a user's Shopping Cart.
 * NOTE: THIS CLASS WAS PROVIDED AS PART OF A STARTING POINT FOR MILESTONE 5.
 * NOTE: Comments are my own because it is required I document code with Javadoc.
 */
public class ShoppingCart implements ProductStockContainer{
    private final List<ProductStockPair> products = new ArrayList<>();
    private int numOfProducts = 0;
    private final int cartID;
    private double total = 0.0;

    /**
     * A constructor for the ShoppingCart class that initializes a cartID.
     * @param cartID is the ID of the User's cart.
     */
    public ShoppingCart(int cartID) {
        this.cartID = cartID;
    }

    /**
     * Get the quantity of the stock of the product.
     * @param p is the product checked for quantity.
     * @return the stock of the product if it exists in the ArrayList products.
     */
    @Override
    public int getProductQuantity(Product p) {
        for (ProductStockPair pair : products) {
            if (pair.product.id == p.id) {
                return pair.stock;
            }
        }
        return -1;
    }

    /**
     * A method that adds stock to the ArrayList products.
     * @param p is the product being added.
     * @param q is the stock of the product being added.
     */
    @Override
    public void addProductQuantity(Product p, int q) {
        // no negative ids please
        if (p.id < 0) return;

        total += p.price * q;

        for (int i = 0; i < products.size(); i++) {
            ProductStockPair pair = products.get(i);
            if (pair.product.id == p.id) {
                products.set(i, new ProductStockPair(p, pair.stock + q));
                return;
            }
        }
        products.add(new ProductStockPair(p, q));
        numOfProducts++;
    }

    /**
     * A method that removes stock from the ArrayList products.
     * @param p is the product being removed.
     * @param q is the stock of the product being removed.
     * @return true if the product's stock gets removed.
     */
    @Override
    public boolean removeProductQuantity(Product p, int q) {
        for (int i = 0; i < products.size(); i++) {
            ProductStockPair pair = products.get(i);
            if (pair.product.id == p.id) {
                if (pair.stock >= q) {
                    products.set(i, new ProductStockPair(pair.product, pair.stock - q));
                    total -= p.price * q;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * Get the number of products in the ArrayList products.
     * @return numOfProducts which is incremented everytime a product is added to products ArrayList.
     */
    @Override
    public int getNumOfProducts() {
        return numOfProducts;
    }

    /**
     * Get ArrayList containing products.
     * @return a new ArrayList containing products.
     */
    public List<ProductStockPair> getProducts() {
        return new ArrayList<>(products);
    }

    /**
     * Get the total price of the cart.
     * @return the total cost of all products in the cart.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Get the ID of the cart.
     * @return the integer representing the cartID.
     */
    public int getCartID() { return cartID; }
}
