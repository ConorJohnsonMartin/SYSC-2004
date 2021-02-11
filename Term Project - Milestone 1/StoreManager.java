/**
 * @author Conor Johnson Martin 101106217
 * @date February 10th, 2021
 * @version Version 1
 */

/**
 * A class that manages inventory.
 */
public class StoreManager {
    private Inventory inventory;

    /**
     * A constructor for the class StoreManage that initializes a new Inventory object called inventory.
     */
    public StoreManager(){
        inventory = new Inventory();
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
     * @return totalPrice is transaction goes through. If transaction does not go through, return -1.0 (type double).
     */
    public double transaction(int[][] t){
        int quantity;
        int productId;
        double totalPrice = 0.0;

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
            inventory.removeStock(productId, quantity);
            totalPrice += inventory.getProductInfo(productId).getPrice() * quantity;
        }
        return totalPrice;
    }
}
