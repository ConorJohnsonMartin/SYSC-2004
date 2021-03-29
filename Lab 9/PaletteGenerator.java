/**
 * @author Conor Johnson Martin 101106217
 * @date March 29th, 2021
 * @version Version 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.Math;
import java.util.ArrayList;

/**
 * A class that builds a colour palette generator displayed in a GUI.
 */
public class PaletteGenerator {

    private final JFrame frame;
    private JLabel headerLabel;
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel bodyPanel;
    private JPanel footerPanel;
    private ArrayList<JPanel> palettes;
    private ArrayList<JButton> buttons;


    /**
     * A constructor for the PaletteGenerator class that initializes the required components to build the PaletteGenerator GUI.
     */
    public PaletteGenerator() {
        this.frame = new JFrame("Palette Generator");
        this.headerLabel = new JLabel("Your Palette:");
        this.mainPanel = new JPanel(new BorderLayout());
        this.headerPanel = new JPanel();
        this.palettes = new ArrayList<JPanel>();
        palettes.add(new JPanel(new BorderLayout()));
        palettes.add(new JPanel(new BorderLayout()));
        palettes.add(new JPanel(new BorderLayout()));
        palettes.add(new JPanel(new BorderLayout()));
        palettes.add(new JPanel(new BorderLayout()));
        palettes.add(new JPanel(new BorderLayout()));
        palettes.add(new JPanel(new BorderLayout()));
        palettes.add(new JPanel(new BorderLayout()));
        this.buttons = new ArrayList<JButton>();
        this.bodyPanel = new JPanel(new GridLayout());
        this.footerPanel = new JPanel(new GridBagLayout());
    }

    /**
     * NOTE: This class was provided in the Main.java file to complete Lab 9.
     * Get colours of a certain brightness
     * @return Color : A Color object with the generated colour.
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
     * Get a button that does not allow the palette to switch colours.
     * @return JButton : a JButton object.
     */
    private JButton keepColourButton() {
        JButton lockPaletteButton = new JButton();

        lockPaletteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!lockPaletteButton.getText().equals("X")){
                    lockPaletteButton.setText("X");
                }else{
                    lockPaletteButton.setText("");
                }

            }
        });
        return lockPaletteButton;
    }

    /**
     * Get a button that generates a palette of colours.
     * @return JButton : a JButton object.
     */
    private JButton getColourButton() {
        JButton generatePaletteButton = new JButton("Generate Palette");

        // add the action listener
        generatePaletteButton.addActionListener(new ActionListener() {

            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(JPanel palette: palettes) {
                    if (!buttons.get(palettes.indexOf(palette)).getText().equals("X")) {
                        palette.setBackground(getColour());
                    }
                }
            }
        });

        return generatePaletteButton;
    }

    /**
     * A method that builds all of the required pieces of the GUI.
     * Iterates over an ArrayList of JPanels containing the pallets and adds dimensions, background colours, layouts, and buttons.
     */
    public void displayGUI() {
        headerPanel.add(headerLabel);
        headerPanel.setPreferredSize(new Dimension(250, 100));

        for(int i = 0; i < palettes.size(); i++) {
            JButton colourButton = keepColourButton();
            palettes.get(i).setPreferredSize(new Dimension(250, 100));
            palettes.get(i).setBackground(getColour());
            bodyPanel.add(palettes.get(i), BorderLayout.CENTER);
            palettes.get(i).add(colourButton, BorderLayout.SOUTH);
            buttons.add(colourButton);
        }

        footerPanel.setPreferredSize(new Dimension(250, 100));
        footerPanel.add(getColourButton());

        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.PAGE_END);

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