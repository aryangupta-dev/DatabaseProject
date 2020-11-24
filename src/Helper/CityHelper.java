/*   Created by IntelliJ IDEA.
 *   Author: Aryan gupta (ag2602)
 *   Date: 11/20/2020
 *   Time: 3:05 PM
 *   File: CityHelper.java
 */

package Helper;

import Data.City;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityHelper {
    //inserted query
    public static final String QUERY="Insert into cities(name,traversal,kilometres)values(?,?,?);";

    //Create
    public boolean addCityToDatabase(Connection connection,City city) throws SQLException {
        String name= city.getName();
        boolean traversal=city.isTraversed();
        int kilometres=city.getKilometres();
        PreparedStatement insertStatement=(
                connection.prepareStatement(QUERY)
        );
        insertStatement.setString(1, name);
        insertStatement.setBoolean(2, traversal);
        insertStatement.setInt(3, kilometres);
        insertStatement.executeUpdate();
        return true;

    }

    //Read
    public static final String Read_Query = "Select * from cities;";
    //Update
    public static final String UPDATE_QUERY = "Update cities set kilometres=? where name=?";
    //Delete
    public static final String DELETE_QUERY = "delete from cities where name=?;";

    public void readAllCitiesFromTheDatabase(Connection connection) {
        try {
            PreparedStatement readStatement = connection.prepareStatement(Read_Query);
            ResultSet str = readStatement.executeQuery();
            while (str.next()) {
                String name = str.getString(1);
                boolean isTraversal = str.getBoolean(2);
                int kilometres = str.getInt(3);
                City city = new City(name, isTraversal, kilometres);
                System.out.println(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateCity(Connection connection, String name, int kilometres) {
        try {
            PreparedStatement updateStatement = connection.prepareStatement(UPDATE_QUERY);

            updateStatement.setInt(1, kilometres);
            updateStatement.setString(2, name);
            updateStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "kilometre updated", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            System.err.println(name + " is not there in the table.");
        }
    }

    public void deleteCity(Connection connection, String name) {
        try {
            PreparedStatement deleteStstement = connection.prepareStatement(DELETE_QUERY);
            deleteStstement.setNString(1, name);
            deleteStstement.executeUpdate();
            JOptionPane.showMessageDialog(null, "City deleted", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}