/**
 * @author Conor Johnson Martin 101106217
 * @date February 10th, 2021
 * @version Version 1
 */

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * A class that manages inventory.
 */
public class StoreManager {
    private Inventory inventory;
    private ArrayList<ShoppingCart> shoppingCarts;


    /**
     * A constructor for the class StoreManage that initializes a new Inventory object called inventory.
     */
    public StoreManager(){
        inventory = new Inventory();
        shoppingCarts = new ArrayList<>();

    }

    /**
     * A method that assigns a new ID for a new Cart.
     * @return
     */
    public Integer assignNewCartID() {
        ShoppingCart shoppingCart= new ShoppingCart(shoppingCarts.size()+1);
        shoppingCarts.add(shoppingCart);
        return shoppingCart.getId();
    }

    /**
     * A method that checks the amount of stock of a given Product.
     * @param product is of type Product.
     * @return the amount of stock.
     */
    public int checkStock(Product product) {
        return inventory.getStock(product.getId());
    }

    /**
     * A method that performs a transaction if there is enough quantity of the products that are being purchased.
     * Once a transaction goes through, the quantity of a product that is purchased is subtracted from the inventory using removeStock.
     * @param t is a two dimensional array that contains integers. [[ProductID, quantity],[ProductID1, quantity]......etc].
     * @param shoppingCart is the shopping cart that is being processed for transaction.
     * @return totalPrice is transaction goes through. If transaction does not go through, return -1.0 (type double).
     */
    public double transaction(int[][] t, ShoppingCart shoppingCart) {
        double totalPrice = 0.0;
        int quantity;
        int productId;
        HashMap<Product, Integer> products = shoppingCart.getShoppingCart();

        for (int[] ints : t) {
            productId = ints[0];
            quantity = ints[1];
            if (inventory.getStock(productId) <= quantity) {
                System.out.println("Unable to fulfill transaction due to insufficient quantities");
                return -1.0;
            }
        }
        for (int[] ints : t) {
            productId = ints[0];
            quantity = ints[1];
            for (Product sc : shoppingCart.getCartContents()) {
                totalPrice += products.get(sc) * sc.getPrice();
                System.out.println(products.toString());
            }
            inventory.removeStock(productId, quantity);
        }
        return totalPrice;
    }

    /**
     * Get the Inventory object inventory.
     * @return inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }
}
