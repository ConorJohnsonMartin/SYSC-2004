/**
 * @author Conor Johnson Martin 101106217
 * @date March 20th, 2021
 * @version Version 1
 */

package storetest;
import Store.Product;
import Store.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * A class to test the Store.Inventory class.
 */
public class InventoryTest {
    Inventory inventory;
    Product product;
    Product product1;
    Product product2;

    /**
     * Initializes objects used for testing.
     * These objects include an Inventory and Product object.
     */
    @Before
    public void init() {
        inventory  = new Inventory();
        product = (new Product("banana", 188, 1.99));    //Create products
        product1 = (new Product("doritos", 189, 3.99));
        product2 = (new Product("mango", 190, 0.99));
        inventory.getInventory().put(product.getId(), 6);               //Add product to the inventory, passing in product id and stock
    }

    /**
     * Testing addStock method in the Inventory class.
     * The first case being tested: if you are adding stock of a product that already exists in the inventory.
     * The second case being tested: if you are adding a new product to the inventory that does not already exist.
     * @throws Exception if a negative stock is attempted to be added to the inventory.
     */
    @Test
    public void addStockTest() throws Exception {
        inventory.addStock(product, 7);
        Assert.assertEquals(inventory.getInventory().get(188), inventory.getStock(product.getId()));  //Testing if adding stock works when a product is already stored in the inventory. Expecting stock = 13.

        inventory.addStock(product1, 8);
        Assert.assertEquals(inventory.getInventory().get(189), inventory.getStock(product1.getId()));  //Testing to make sure adding a new product with new stock works. Expecting stock = 8.
    }

    /**
     * Testing the removeStock method in the Inventory class.
     * @throws Exception if the amount of stock being removed would result in negative inventory.
     */
    @Test
    public void removeStockTest() throws Exception {
        inventory.removeStock(product.getId(), 3); //Testing to see if removing stock
        Assert.assertEquals(inventory.getInventory().get(188), inventory.getStock(product.getId()));
    }

    /**
     * Nullifies the objects used to test.
     */
    @After
    public void tearDown() {
        product = null;
        product1 = null;
        product2 = null;
        inventory = null;
    }









































}
