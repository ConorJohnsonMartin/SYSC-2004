/**
 * @author Conor Johnson Martin 101106217
 * @date April 4th, 2021
 * @version Version 4
 */

package Store;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

/**
 * A class that implements a GUI to operate the Store View.
 * My GUI operates a Farmer's Market.
 */
public class StoreView {
    private final JFrame frame;
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JLabel headerLabel;
    private JPanel bodyPanel;
    private JPanel footerPanel;
    private ArrayList<JPanel> produce;
    private ArrayList<JButton> addButtons;
    private ArrayList<JButton> removeButtons;
    private Inventory inventory;
    private ShoppingCart sc;

    /**
     * Constructor for the StoreView class that initializes all necessary elements.
     * @throws Exception that handles the addStock method in ShoppingCart.java
     */
    public StoreView() throws Exception {
        this.frame = new JFrame("Store View");
        this.mainPanel = new JPanel(new BorderLayout());
        this.headerPanel = new JPanel(new BorderLayout());
        this.headerLabel = new JLabel("Farmer's Market");
        this.bodyPanel = new JPanel(new GridLayout(1, 6, 25, 1));
        this.footerPanel = new JPanel(new GridBagLayout());
        this.produce = new ArrayList<JPanel>();
        produce.add(new JPanel(new BorderLayout()));
        produce.add(new JPanel(new BorderLayout()));
        produce.add(new JPanel(new BorderLayout()));
        produce.add(new JPanel(new BorderLayout()));
        produce.add(new JPanel(new BorderLayout()));
        this.addButtons = new ArrayList<JButton>();
        this.removeButtons = new ArrayList<JButton>();
        this.inventory = new Inventory();
        inventory.addStock(new Product("Bananas", 0, 1.99), 40);
        inventory.addStock(new Product("Strawberries", 1, 3.99), 50);
        inventory.addStock(new Product("Grapes", 2, 2.99), 60);
        inventory.addStock(new Product("Broccoli", 3, 2.49), 30);
        inventory.addStock(new Product("Avocados", 4, 0.99), 10);
        ShoppingCart sc = new ShoppingCart(1);

    }

    /**
     * A button designed to add a quantity of 1 item to the cart.
     * @return the addToCart button.
     */
    private JButton addToCartButton() {
        JButton addToCart = new JButton("+");
        addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        addToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JPanel product: produce){
                    if(addToCart.getModel().isPressed()) {
                        sc.addToCart(inventory.getProductInfo(produce.indexOf(product)), 1);
                    }
                }
            }
        });
        return addToCart;
    }

    /**
     * A button designed to remove a quantity of 1 item from the cart.
     * @return the removeFromCart button.
     */
    private JButton removeFromCartButton() {
        JButton removeFromCart = new JButton("-");
        removeFromCart.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        removeFromCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JPanel product: produce) {
                    if (removeFromCart.getModel().isPressed()) {
                        sc.removeFromCart(inventory.getProductInfo(produce.indexOf(product)), 1);
                    }
                }
            }
        });
        return removeFromCart;
    }

    /**
     * I have not been able to fully implement this button so it will not actually work.
     * The idea behind this button was that once it was clicked, a new JPanel in this case called the viewCart would be opened up and information from the cart would be displayed.
     * @return the viewCart JButton
     */
    private JButton viewCartButton() {
        JButton viewCart = new JButton("View Cart");
        viewCart.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel viewCartPanel = new JPanel(new GridLayout());
                for(JPanel product: produce) {
                    if (addToCartButton().getModel().isPressed()) {
                        JLabel products = new JLabel();
                        viewCartPanel.add(products);
                    }
                }
                frame.add(viewCartPanel);
                frame.setVisible(true);
            }
        });
        return viewCart;
    }

    /**
     * I have not been able to fully implement this button so it will not actually work.
     * The idea behind this button was that once it was clicked, a new JPanel in this case called the checkOutPanel would be opened up and information from the cart would be displayed.
     * @return the proceedToCheckout button.
     */
    private JButton proceedToCheckoutButton() {
        JButton proceedToCheckout = new JButton("Proceed To Checkout");
        proceedToCheckout.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        proceedToCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JPanel checkOutPanel = new JPanel(new BorderLayout());

                frame.add(checkOutPanel);
                frame.setVisible(true);
            }
        });
        return proceedToCheckout;
    }

    /**
     * This method is from Lab 9, it has been repurposed to add a colour backdrop behind the images of produce.
     * I do not take credit for this method, it is only for aesthetics
     * @return a random colour.
     */
    private Color getColour() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        double luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);

        while (luma < 75) {
            r = (int) (Math.random() * 256);
            g = (int) (Math.random() * 256);
            b = (int) (Math.random() * 256);
            luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);
        }
        return new Color(r, g, b);
    }

    /**
     * A method that displays a GUI meant to represent a Store View.
     * @throws Exception
     */
    public void displayGUI() throws Exception {

        //An ArrayList that holds 5 URL's to images that will be displayed in the GUI
        ArrayList<String> path = new ArrayList<String>();
        path.add("https://media.istockphoto.com/photos/banana-bunch-picture-id173242750?k=6&m=173242750&s=612x612&w=0&h=QJB3WhqIWcF1umqELWFUVu32OJWCuePabFClaMfRWbo=");
        path.add("https://www.gardentech.com/-/media/Images/GardenTech-NA/US/blog/How-to-Grow-Your-Own-Tasty-Strawberries/Strawberries-Header-OG.jpg");
        path.add("https://specialtyproduce.com/sppics/1224.png");
        path.add("https://solidstarts.com/wp-content/uploads/Broccoli_edited-480x320.jpg");
        path.add("https://loveonetoday.com/wp-content/uploads/2017/07/Love-One-Today-Avocado-Nutrition-how-to-ripen-avocados-stages-3.jpg");
        JLabel images = null;

        //Setting up the header JPanel
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        headerPanel.add(headerLabel);
        headerPanel.add(viewCartButton(), BorderLayout.EAST);

        //Adding sizing to the JPanels
        headerPanel.setPreferredSize(new Dimension(250, 100));
        bodyPanel.setPreferredSize(new Dimension(250, 100));
        footerPanel.setPreferredSize(new Dimension(250, 100));

        //An ArrayList of JPanels called produce is manipulated in this for loop
        //Sets up JLabels, Fonts, Background colour, Layouts within the body JPanel, and the add / remove buttons
        //Also adds teh images from the "path" ArrayList
        for(int i = 0; i < produce.size(); i++) {
                produce.get(i).setPreferredSize(new Dimension(250, 100));
                JLabel namePriceAndStockOfProduce = new JLabel(inventory.getProductInfo(i).getName() + " / Price: $" + String.valueOf(inventory.getProductInfo(i).getPrice()) + " / Stock: " + String.valueOf(inventory.getStock(i)));
                namePriceAndStockOfProduce.setFont(new Font("Times New Roman", Font.PLAIN, 25));
                produce.get(i).add(namePriceAndStockOfProduce, BorderLayout.NORTH);
                produce.get(i).setBackground(getColour());
                bodyPanel.add(produce.get(i));
                produce.get(i).add(addToCartButton(), BorderLayout.WEST);
                produce.get(i).add(removeFromCartButton(), BorderLayout.EAST);
                addButtons.add(addToCartButton());
                removeButtons.add(removeFromCartButton());

            try {
                URL url = new URL(path.get(i));
                BufferedImage image = ImageIO.read(url);
                images = new JLabel(new ImageIcon(image));
                images.setPreferredSize(new Dimension(50, 50));
            } catch (Exception exp) {
                exp.printStackTrace();
            }

                produce.get(i).add(images, BorderLayout.CENTER);
        }

        footerPanel.add(proceedToCheckoutButton());
        footerPanel.setBackground(Color.BLACK);
        headerPanel.setBackground(Color.BLACK);
        bodyPanel.setBackground(Color.BLACK);

        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.PAGE_END);
        mainPanel.setPreferredSize(new Dimension(2000, 1000));

        frame.add(mainPanel);
        frame.pack();

        frame.setVisible(true);

        /**
         * NOTE: This method was provided from Main.java in Lab 9.
         */
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
    }

}