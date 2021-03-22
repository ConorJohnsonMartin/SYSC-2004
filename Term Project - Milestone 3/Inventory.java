package Store; /**
 * @author Conor Johnson Martin 101106217
 * @date February 10th, 2021
 * @version Version 3
 */

import java.util.HashMap;

/**
 * A class that maintains an inventory of type Products.
 * Can access and mutate stock within the inventory of products.
 */
public class Inventory {
    private HashMap<Integer, Integer> inventory;
    private HashMap<Integer, Product> products;

    /**
     * A constructor that initializes new HashMaps.
     */
    public Inventory() {
        this.inventory = new HashMap<>();   //Store.Inventory HashMap that stores a product's stock accessible by passing the product's id.
        this.products = new HashMap<>();    //Products HashMap that stores a product's information from the Store.Product class that is accessible by passing the product's id.
        try {
            addStock(new Product("Bananas", 55, 3.10), 60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            addStock(new Product("Doritos", 56, 3.99), 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that gets the current stock of a product from the inventory
     * @param id is the product id.
     * @return the amount of stock if the product's id is found in the inventory.
     */
    public Integer getStock(Integer id) {
        if(inventory.containsKey(id)) {
            return inventory.get(id);
        }
        return null;
    }

    /**
     * A method that adds stock to the inventory.
     * @param product stores the product's information.
     * @param stock is the amount of stock of a product stored in inventory.
     */
    public void addStock(Product product, int stock) throws Exception {
        if(stock < 0) {
            throw new Exception("Cannot add negative stock");
        }
        if(!(inventory.containsKey(product.getId()))) {
            inventory.put(product.getId(), stock);
            products.put(product.getId(), product);
        }else{
            int newStock = inventory.get(product.getId()) + stock;
            inventory.put(product.getId(), newStock);
        }
    }

    /**
     * A method that removes stock from a product's inventory.
     * If the stock removed from the inventory is greater or equal to the current stock of the product, the products stock is set to zero.
     * @param id is the product id.
     * @param stock is the amount of stock of a product stored in inventory.
     */
    public void removeStock(Integer id, int stock) throws Exception {
        if(stock < inventory.get(id)) {
            int newStock = inventory.get(id) - stock;
            inventory.put(id, newStock);
        }else{
            throw new Exception("Not enough stock");
        }
    }

    /**
     * A method that gets product info stored in the products HashMap
     * @param id is the products id.
     * @return information stored in products HashMap.
     */
    public Product getProductInfo(Integer id){
        if(products.containsKey(id)) {
            return products.get(id);
        }
        return null;
    }

    /**
     * Get the HashMap products.
     * @return products.
     */
    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    /**
     * Get the HashMap inventory. Used in inventoryTest.
     * @return the HashMap inventory.
     */
    public HashMap<Integer, Integer> getInventory() {
        return inventory;
    }
}
