/**
 * @author Conor Johnson Martin 101106217
 * @date March 20th, 2021
 * @version Version 1
 */

package storetest;
import Store.Product;
import Store.ShoppingCart;
import Store.StoreManager;
import Store.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class StoreManagerTest {
    StoreManager storeManager;
    Inventory inventory;
    ShoppingCart shoppingCart;
    Product product;
    Product product1;

    @Before
    public void init() {
        storeManager = new StoreManager();
        inventory = new Inventory();
        shoppingCart = new ShoppingCart(1);
        product = new Product("banana", 188, 1.99);
        product1 = new Product("doritos", 189, 3.99);
        storeManager.getShoppingCarts().add(shoppingCart);
    }

    @Test
    public void assignNewCartIdTest() {
        storeManager.assignNewCartID();
        Assert.assertEquals(java.util.Optional.ofNullable(storeManager.assignNewCartID()), storeManager.getShoppingCarts().size());
    }

    @Test
    public void checkStockTest() throws Exception {
        inventory.addStock(product, 8);
        Assert.assertEquals(java.util.Optional.of(storeManager.checkStock(product)), inventory.getStock(188));
    }

    @Test
    public void transactionTest() throws Exception {
        shoppingCart.addToCart(product, 3);
        shoppingCart.addToCart(product1, 5);
        int[][] t = {{product.getId(), 3}, {product1.getId(), 5}};
        Assert.assertEquals(storeManager.transaction(t,shoppingCart), 25.92);
    }

    @After
    public void tearDown() {
        storeManager = null;
        inventory = null;
        shoppingCart = null;
    }
}
