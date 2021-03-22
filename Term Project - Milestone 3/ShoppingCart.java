/**
 * @author Conor Johnson Martin 101106217
 * @date February 10th, 2021
 * @version Version 3
 */
package Store;
import java.util.HashMap;
import java.util.Set;

/**
 * A class that represents a user's Shopping Cart.
 */
public class ShoppingCart {

    private HashMap<Product, Integer> cart;    //<Store.Product, stock>
    private int cartId;
    private Inventory inventory;

    /**
     * A constructor for the Store.ShoppingCart class that initializes a car HashMap and int cartId.
     * @param cartId is the ID of teh User's cart.
     */
    public ShoppingCart(int cartId) {
        this.cart = new HashMap<>();
        this.cartId = cartId;

    }

    /**
     * Get the Store.ShoppingCart HashMap containing the Store.Product and Stock of the product.
     * @return the cart HashMap.
     */
    public HashMap getShoppingCart() {
        return cart;
    }

    /**
     * Get the set of Products that have been added to the cart in the form of keys.
     * @return the Set<Store.Product> of keys from the HashMap cart.
     */
    public Set<Product> getCartContents() {
        return cart.keySet();
    }

    /**
     * Get the stock.
     * @param product is of type Store.Product.
     * @return the stock of the product accessed by passing the key into the HashMap cart.
     */
    public Integer getStock(Product product) {
        return cart.get(product);
    }

    /**
     * A method that adds a product to the cart HashMap.
     * @param product is the Store.Product being added.
     * @param stock is the stock of the product that is added to the HashMap.
     */
    public void addToCart(Product product, int stock) {
        if (!(cart.containsKey(product.getId()))) {                  //If the user adds a new item to the cart that has not been added yet.
            cart.put(product, stock);
            try {
                inventory.removeStock(product.getId(), stock);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {                                                      //If the user wants to add more quantity of the same product.
            int newStock = cart.get(product.getId()) + stock;
            cart.put(product, newStock);
        }
    }

    /**
     *A method that removes a product to the cart HashMap.
     * @param product is the Store.Product being removed.
     * @param stock is the stock of the product that is removed from the HashMap.
     */
    public void removeFromCart(Product product, int stock) {
        cart.remove(product.getId(), stock); //If the user removes an item from the cart.
        try {
            inventory.addStock(product, stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that takes the keySet and adds it to a String to display a list of Products in the cart HashMap.
     * @return String.
     */
    public String toString() {
        return "The contents of the cart: " + cart.keySet();
    }

    /**
     * Get the Id of the Cart.
     * @return cartId.
     */
    public Integer getId() {
        return this.cartId;
    }
}