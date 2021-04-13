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
public class StoreManager {
    private final Inventory storeInventory = new Inventory();
    private final List<ShoppingCart> shoppingCarts = new ArrayList<>();
    private int shoppingCartCounter = 0;

    /**
     * Get the quantity of the stock of the product.
     * @param p is the product checked for quantity.
     * @return the stock of the product if it exists in the Inventory object storeInventory.
     */
    public int getProductStock(Product p) {
        return storeInventory.getProductQuantity(p);
    }

    // makes a new cart and returns the cartid
    public int assignNewCartID() {
        int id = shoppingCartCounter++;
        shoppingCarts.add(new ShoppingCart(id));
        return id;
    }

    /**
     * Add a product to the ArrayList shoppingCarts.
     * @param cartID is the ID of the cart.
     * @param p is the product being added to the shopping cart with the correct ID.
     * @param amount is the amount of stock being added to the cart.
     * @return true if the product is successfully added to the shoppingCarts ArrayList.
     */
    public boolean addToCart(int cartID, Product p, int amount) {
        if (storeInventory.removeProductQuantity(p, amount)) {
            for (ShoppingCart cart : shoppingCarts) {
                if (cart.getCartID() == cartID) {
                    cart.addProductQuantity(p, amount);
                    return true;
                }
            }
            // put items back
            storeInventory.addProductQuantity(p, amount);
        }
        return false;
    }

    /**
     * Remove a product from the ArrayList shoppingCarts.
     * @param cartID is the ID of the cart.
     * @param p is the product being removed from the shopping cart with the correct ID.
     * @param amount is the amount of stock being removed from the cart.
     * @return true if the product is successfully removed from the shoppingCarts ArrayList.
     */
    public boolean removeFromCart(int cartID, Product p, int amount) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                if (cart.removeProductQuantity(p, amount)) {
                    storeInventory.addProductQuantity(p, amount);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * Get the products stored in the ArrayList storeInventory.
     * @return the ArrayList that contains the inventory of products.
     */
    public List<ProductStockPair> getAvailableProducts() {
        return storeInventory.getProducts();
    }

    /**
     * Get the products stored in the shoppingCart with the corresponding cartID.
     * @param cartID is the ID of the cart.
     * @return the products that have been added to the shopping cart with the corresponding cartID.
     */
    public List<ProductStockPair> getCartContents(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                List<ProductStockPair> contents = new ArrayList<>(cart.getProducts());
                // filtering out 0 stocks; unique to viewing cart contents
                contents.removeIf(productStockPair -> productStockPair.stock < 1);
                return contents;
            }
        }
        return null; // just give an empty ArrayList if not found
    }

    /**
     * Remove the contents stored in the shopping cart with the corresponding cartID.
     * @param cartID is the ID of the cart.
     */
    public void clearCartContents(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                List<ProductStockPair> stuffToPutBack = cart.getProducts();
                for (ProductStockPair pair : stuffToPutBack) {
                    storeInventory.addProductQuantity(pair.product, pair.stock);
                }
                // delete cart from shoppingCarts
                shoppingCarts.remove(cart);
                return;
            }
        }
    }

    /**
     * Get the total price of the cart.
     * @param cartID is the ID of the cart.
     * @return the total cost of all products in the cart.
     */
    public double getCartTotal(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                return cart.getTotal();
            }
        }
        return -1.0;
    }

    /**
     * Get the number of products in the inventory.
     * @return number of products in the inventory.
     */
    public int getNumOfProducts() {
        return storeInventory.getNumOfProducts();
    }

    /**
     * Determine if a product is in a cart.
     * @param cartID is the ID of the cart.
     * @param p is the product we are checking for.
     * @return true if the product is in the shopping cart, else false.
     */
    public boolean isInCart(int cartID, Product p) {
        for (ShoppingCart sC : shoppingCarts) {
            if (sC.getCartID() == cartID) {
                return sC.getProductQuantity(p) > 0;
            }
        }
        return false;
    }
}
