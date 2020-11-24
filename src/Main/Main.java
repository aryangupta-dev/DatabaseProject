/*   Created by IntelliJ IDEA.
 *   Author: Aryan gupta (ag2602)
 *   Date: 11/20/2020
 *   Time: 1:23 PM
 *   File: Main.java
 */

package Main;

import Connetion.DatabaseConnection;
import Data.City;
import Helper.CityHelper;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final short ADD_CITY = 1;
    private static final short READ_CITY = 2;
    private static final short UPDATE_KILOMETRE = 3;
    private static final int DELETE_CITY = 4;

    public static void main(String[] args) {
        DatabaseConnection obj = new DatabaseConnection();
        obj.connectToDatabase();
        if (DatabaseConnection.connection != null) {
            System.out.println("Happy to see U here in database manipulation species.");
            System.out.println("Enter 1 to add city name in the database");
            System.out.println("Enter 2 to read values from the database.");
            System.out.println("Enter 3 to update values in database.");
            System.out.println("Enter 4 to delete the values from the database.");
            System.out.println("Enter 5 to exit.");
            Scanner sc = new Scanner(System.in);
            boolean exitLoop = true;
            CityHelper manipulated = new CityHelper();
            while (exitLoop) {
                int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice for manipulation in DB.", "Choice", JOptionPane.PLAIN_MESSAGE));
                switch (choice) {
                    case ADD_CITY:
                        int kilometres = 0;
                        String cityName = JOptionPane.showInputDialog(null, "Enter city you want to add.", "add data", JOptionPane.PLAIN_MESSAGE);
                        boolean isTraversed = Boolean.parseBoolean(JOptionPane.showInputDialog(
                                null,
                                "Have you visited there (True/false.)",
                                "isTraversed",
                                JOptionPane.PLAIN_MESSAGE
                        ));
                        try {
                            kilometres = Integer.parseInt(JOptionPane.showInputDialog(
                                    null,
                                    "Distance from the current location.",
                                    "Distance",
                                    JOptionPane.PLAIN_MESSAGE
                            ));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Cant added km not a no.",
                                    "Invalid.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                        City city = new City(cityName, isTraversed, kilometres);
                        try {
                            manipulated.addCityToDatabase(DatabaseConnection.getConnection(), city);
                        } catch (SQLException throwables) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Cant added.",
                                    "Invalid.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        } finally {
                            JOptionPane.showMessageDialog(null, "City added to the database.", "Added", JOptionPane.DEFAULT_OPTION);
                        }
                        break;
                    case READ_CITY:
                        manipulated.readAllCitiesFromTheDatabase(DatabaseConnection.getConnection());
                        JOptionPane.showMessageDialog(null, "Details shown to you", "Done", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case UPDATE_KILOMETRE:
                        int updateKilometre = 0;
                        String cityKilometreUpdation = JOptionPane.showInputDialog(null, "Enter City for kilometre updation.",
                                "City", JOptionPane.DEFAULT_OPTION);

                        try {
                            updateKilometre = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Enter the kilometre for updation.", "Kilometre", JOptionPane.DEFAULT_OPTION));
                            manipulated.updateCity(DatabaseConnection.getConnection(), cityKilometreUpdation, updateKilometre);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Cant added km not a no.",
                                    "Invalid.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }

                        break;
                    case DELETE_CITY:
                        String cityNam = JOptionPane.showInputDialog(
                                null,
                                "Enter the city to be delete.",
                                "Delete",
                                JOptionPane.PLAIN_MESSAGE

                        );
                        manipulated.deleteCity(DatabaseConnection.connection, cityNam);

                        break;
                    default:
                        exitLoop = false;
                }

            }
        }
    }
}