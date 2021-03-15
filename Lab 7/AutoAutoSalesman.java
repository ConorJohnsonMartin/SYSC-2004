/**
 * @author Conor Johnson Martin 101106217
 * @date March 15th, 2021
 * @version Version 1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * A class that uses method-overloading to sort through a List of cars
 *    and based off of the car's attributes and the parameters passed to the various methods of getReco(),
 *    add these cars to a new ArrayList of autoRecommendations.
 *
 * NOTE: There are 8 possible outcomes based off how many filters the user wishes to use.
 * This table describes the possible outcomes: (1 == ON), (0 == OFF)
 * |[PRICE] [ECO] [STYLE]|
 * |   1      1      1   |
 * |   1      1      0   |
 * |   1      0      1   |
 * |   1      0      0   |
 * |   0      1      1   |
 * |   0      1      0   |
 * |   0      0      1   |
 * |   0      0      0   |
 */

public class AutoAutoSalesman {

    private List<Car> carInventory; //Stores the List of cars that are assigned in Main.

    /**
     * A constructor for the AutoAutoSalesman class that initializes an ArrayList that stores all of the Car objects from the List in Main.
     * @param cars is the List that stores Car objects that has been created in Main.
     */
    public AutoAutoSalesman(List<Car> cars) {
        carInventory = cars;
    }

    /**
     * If customer chooses to get recommendations based off of pricePoint, priceRange, ecoFriendly-ness and style. CASE: (1, 1, 1)
     * @param pricePoint  is the initial pricePoint the buyer wishes to search for.
     * @param priceRange  is the range for which the the buyer is willing to spend above and below the initial pricePoint.
     * @param ecoFriendly is a boolean, if true, then the car is ecoFriendly, if false, the car is not ecoFriendly.
     * @param style       is a String that describes the style of the car that is being filtered for.
     * @return the new ArrayList of filtered / recommended cars.
     */
    public ArrayList<Car> getReco(double pricePoint, double priceRange, boolean ecoFriendly, String style) {
        double upperRange = pricePoint + (priceRange / 2);
        double lowerRange = pricePoint - (priceRange / 2);
        ArrayList<Car> autoRecommendations = new ArrayList<Car>();
        for (Car cars : carInventory) {
            if (cars.getPrice() >= lowerRange && cars.getPrice() <= upperRange) {
                if (ecoFriendly && cars.getFuelEconomy() < 6.0) {
                    if (cars.getStyle().equals(style)) {
                        autoRecommendations.add(cars);
                    }
                }
                if (!ecoFriendly && cars.getFuelEconomy() >= 6.0) {
                    if (cars.getStyle().equals(style)) {
                        autoRecommendations.add(cars);
                    }
                }
            }
        }
        return autoRecommendations;
    }

    /**
     * If customer chooses to get recommendations based off of pricePoint, priceRange, and ecoFriendly-ness. CASE: (1, 1, 0)
     * @param pricePoint is the initial pricePoint the buyer wishes to search for.
     * @param priceRange is the range for which the the buyer is willing to spend above and below the initial pricePoint.
     * @param ecoFriendly is a boolean, if true, then the car is ecoFriendly, if false, the car is not ecoFriendly.
     * @return the new ArrayList of filtered / recommended cars.
     */
    public ArrayList<Car> getReco(double pricePoint, double priceRange, boolean ecoFriendly) {
        double upperRange = pricePoint + (priceRange / 2);
        double lowerRange = pricePoint - (priceRange / 2);
        ArrayList<Car> autoRecommendations = new ArrayList<Car>();
        for (Car cars : carInventory) {
            if (cars.getPrice() >= lowerRange && cars.getPrice() <= upperRange) {
                if (ecoFriendly && cars.getFuelEconomy() < 6.0) {
                    autoRecommendations.add(cars);
                }
                if (!ecoFriendly && cars.getFuelEconomy() >= 6.0) {
                        autoRecommendations.add(cars);
                }
            }
        }
        return autoRecommendations;
    }

    /**
     * If customer chooses to get recommendations based off of pricePoint, priceRange, and style. CASE: (1, 0, 1)
     * @param pricePoint is the initial pricePoint the buyer wishes to search for.
     * @param priceRange is the range for which the the buyer is willing to spend above and below the initial pricePoint.
     * @param style is a String that describes the style of the car that is being filtered for.
     * @return the new ArrayList of filtered / recommended cars.
     */
    public ArrayList<Car> getReco(double pricePoint, double priceRange, String style) {
        double upperRange = pricePoint + (priceRange / 2);
        double lowerRange = pricePoint - (priceRange / 2);
        ArrayList<Car> autoRecommendations = new ArrayList<Car>();
        for (Car cars : carInventory) {
            if (cars.getPrice() >= lowerRange && cars.getPrice() <= upperRange) {
                if (cars.getStyle().equals(style)) {
                    autoRecommendations.add(cars);
                }
            }
        }
        return autoRecommendations;
    }

    /**
     * If customer chooses to get recommendations based off of pricePoint and priceRange. CASE: (1, 0, 0)
     * @param pricePoint is the initial pricePoint the buyer wishes to search for.
     * @param priceRange is the range for which the the buyer is willing to spend above and below the initial pricePoint.
     * @return the new ArrayList of filtered / recommended cars.
     */
    public ArrayList<Car> getReco(double pricePoint, double priceRange) {
        double upperRange = pricePoint + (priceRange / 2);
        double lowerRange = pricePoint - (priceRange / 2);
        ArrayList<Car> autoRecommendations = new ArrayList<Car>();
        for (Car cars : carInventory) {
            if (cars.getPrice() >= lowerRange && cars.getPrice() <= upperRange) {
                autoRecommendations.add(cars);
            }
        }
        return autoRecommendations;
    }

    /**
     * If customer chooses to get recommendations based off of ecoFriendly-ness and style. CASE: (0, 1, 1)
     * @param ecoFriendly is a boolean, if true, then the car is ecoFriendly, if false, the car is not ecoFriendly.
     * @param style is a String that describes the style of the car that is being filtered for.
     * @return the new ArrayList of filtered / recommended cars.
     */
    public ArrayList<Car> getReco(boolean ecoFriendly, String style) {
        ArrayList<Car> autoRecommendations = new ArrayList<Car>();
        for (Car cars : carInventory) {
            if (ecoFriendly && cars.getFuelEconomy() < 6.0) {
                if (cars.getStyle().equals(style)) {
                    autoRecommendations.add(cars);
                }
            }
            if (!ecoFriendly && cars.getFuelEconomy() >= 6.0) {
                if (cars.getStyle().equals(style)) {
                    autoRecommendations.add(cars);
                }
            }
        }
        return autoRecommendations;
    }

    /**
     * If customer chooses to get recommendations based off of ecoFriendly-ness. CASE: (0, 1, 0)
     * @param ecoFriendly is a boolean, if true, then the car is ecoFriendly, if false, the car is not ecoFriendly.
     * @return the new ArrayList of filtered / recommended cars.
     */
    public ArrayList<Car> getReco(boolean ecoFriendly) {
        ArrayList<Car> autoRecommendations = new ArrayList<Car>();
        for (Car cars : carInventory) {
            if (ecoFriendly && cars.getFuelEconomy() < 6.0) {
                autoRecommendations.add(cars);
            }
            if (!ecoFriendly && cars.getFuelEconomy() >= 6.0) {
                autoRecommendations.add(cars);
            }
        }
        return autoRecommendations;
    }

    /**
     * If customer chooses to get recommendations based off of style. CASE: (0, 0, 1)
     * @param style is a String that describes the style of the car that is being filtered for.
     * @return the new ArrayList of filtered / recommended cars.
     */
    public ArrayList<Car> getReco(String style) {
        ArrayList<Car> autoRecommendations = new ArrayList<Car>();
        for (Car cars : carInventory) {
            //If customer provides no price information (0.0), ecoFriendly is false and style matters (0, 0, 1)
            if (cars.getStyle().equals(style)) {
                autoRecommendations.add(cars);
            }
        }
        return autoRecommendations;
    }

    /**
     * If customer chooses to get no recommendations. CASE: (0, 0, 0)
     * @return the new ArrayList of filtered / recommended cars.
     */
    public ArrayList<Car> getReco() {
        ArrayList<Car> autoRecommendations = new ArrayList<Car>();
        autoRecommendations.addAll(carInventory);
        return autoRecommendations;
    }
}
