/**
 * @author Conor Johnson Martin 101106217
 * @date February 10th, 2021
 * @version Version 3
 */

package Store;
import java.util.Scanner;

/**
 * A class that contains a GUI for the store system.
 */
public class StoreView {

    private StoreManager sm;

    /**
     * Constructor for Store.StoreView class.
     * @param sm is of type StoreManage.
     * @param assignNewCartID is the newly assigned CartId.
     */
    public StoreView(StoreManager sm, Integer assignNewCartID) {
        this.sm = sm;
    }

    /**
     * This is only the first section of the display, the BROWSE section.
     * Prints the display.
     * @return true.
     */
    public boolean displayGUI() {

        System.out.println("|----------------THE COURSE STORE-----------------|");
        System.out.println("|---------------------BROWSE----------------------|");
        System.out.println("Stock | Store.Product Name | Unit Price");

        Inventory inventory = sm.getInventory();

        for(Product ar: inventory.getProducts().values()) {
            System.out.println(inventory.getStock(ar.getId()) + "|" + ar.getName() + "|" + ar.getPrice());

        }
    return true;
    }

    /**
     * This is not my code. It was provided in Appendix A of Milestone 2 Doc.
     * Used to initiate display.
     * @param args
     */
    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreView sv1 = new StoreView(sm, sm.assignNewCartID());
        StoreView sv2 = new StoreView(sm, sm.assignNewCartID());
        StoreView sv3 = new StoreView(sm, sm.assignNewCartID());
        StoreView[] users = {sv1, sv2, sv3};
        int activeSV = users.length;
        Scanner sc = new Scanner(System.in);
        while (activeSV > 0) {
            System.out.print("CHOOSE YOUR STOREVIEW >>> ");
            int choice = sc.nextInt();
            if (choice < users.length && choice >= 0) {
                if (users[choice] != null) {
                    String chooseAnother = "";
                    while (!chooseAnother.equals("y") && !chooseAnother.equals("Y")) {
                        // this implementation of displayGUI waits for input and displays the page
// corresponding to the user's input. it does this once, and then returns
// true if the user entered 'checkout' or 'quit'.
                        if (users[choice].displayGUI()) {
                            users[choice] = null;
                            activeSV--;
                            break;
                        }
                        System.out.print("GO TO ANOTHER STOREVIEW? (y) >>> ");
                        chooseAnother = sc.next();
                    }
                } else {
                    System.out.println("MAIN > ERROR > BAD CHOICE\nTHAT STOREVIEW WAS DEACTIVATED");
                }
            } else {
                System.out.println(
                        String.format("MAIN > ERROR > BAD CHOICE\nPLEASE CHOOSE IN RANGE [%d, %d]",
                                0, users.length - 1)
                );
            }
        }
        System.out.println("ALL STOREVIEWS DEACTIVATED");
    }
}
