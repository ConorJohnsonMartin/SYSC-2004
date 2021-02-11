/**
 * @author Conor Johnson Martin 101106217
 * @date February 10th, 2021
 * @version Version 1
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
        this.inventory = new HashMap<>();   //Inventory HashMap that stores a product's stock accessible by passing the product's id.
        this.products = new HashMap<>();    //Products HashMap that stores a product's information from the Product class that is accessible by passing the product's id.
        addStock(new Product("Bananas", 55, 3.10), 60);
        addStock(new Product("Doritos", 56, 3.99), 1000);
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
    public void addStock(Product product, int stock) {
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
    public void removeStock(Integer id, int stock) {
        if(stock < inventory.get(id)) {
            int newStock = inventory.get(id) - stock;
            inventory.put(id, newStock);
        }else{
            int newStock = 0;
            inventory.put(id, newStock);
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
}
