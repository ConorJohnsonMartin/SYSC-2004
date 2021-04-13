/**
 * @name Conor Johnson Martin 101106217
 * @date April 13th, 2021
 */

package Store;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that maintains an inventory of type Products.
 * Implements the interface ProductStockContainer.
 * NOTE: THIS CLASS WAS PROVIDED AS PART OF A STARTING POINT FOR MILESTONE 5.
 * NOTE: Comments are my own because it is required I document code with Javadoc.
 */
public class Inventory implements ProductStockContainer {

    private final List<ProductStockPair> products = new ArrayList<>();
    private int numOfProducts = 0;

    /**
     * A constructor that initializes the inventory.
     */
    public Inventory() {
        initialize();
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
     * A method that adds products to form the inventory.
     */
    private void initialize() {
        // can add some default inventory stock here
        this.addProductQuantity(new Product(100.0, "SYSC2004", 0), 76);
        this.addProductQuantity(new Product(55.0, "SYSC4906", 1), 0);
        this.addProductQuantity(new Product(45.0, "SYSC2006", 2), 32);
        this.addProductQuantity(new Product(35.0, "MUSI1001", 3), 3);
        this.addProductQuantity(new Product(0.01, "CRCJ1000", 4), 12);
        this.addProductQuantity(new Product(25.0, "ELEC4705", 5), 132);
        this.addProductQuantity(new Product(145.0, "SYSC4907", 6), 322);
        this.addProductQuantity(new Product(1.0, "SYSC1005", 7), 7);
        this.addProductQuantity(new Product(15.0, "ECOR1010", 8), 10);
        this.addProductQuantity(new Product(99.0, "SYSC4805", 9), 332);
        this.addProductQuantity(new Product(32.0, "STAT3501", 10), 4);
        this.addProductQuantity(new Product(99.99, "MATH3501", 11), 1);
        this.addProductQuantity(new Product(19.99, "ELEC3500", 12), 13);
        this.addProductQuantity(new Product(145.99, "ELEC2501", 13), 22);
        this.addProductQuantity(new Product(0.29, "SYSC3601", 14), 42);

        numOfProducts = 15;
    }
}

