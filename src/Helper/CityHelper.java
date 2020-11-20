/*   Created by IntelliJ IDEA.
 *   Author: Aryan gupta (ag2602)
 *   Date: 11/20/2020
 *   Time: 3:05 PM
 *   File: CityHelper.java
 */

package Helper;

import Data.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
        insertStatement.setString(1,name);
        insertStatement.setBoolean(2,traversal);
        insertStatement.setInt(3,kilometres);
        insertStatement.executeUpdate();
        return true;

    }
    //Read
    public List<City> readAllCitiesFromTheDatabase(){
        return null;
    }
    //Update
    public boolean updateCity(){
        return false;
    }
    //Delete
    public boolean deleteCity(){
        return false;
    }
}