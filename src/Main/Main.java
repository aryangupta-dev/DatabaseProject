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

import java.rmi.ServerError;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection obj=new DatabaseConnection();
        obj.connectToDatabase();
        if(DatabaseConnection.connection!=null){
            System.out.println("Happy to see U here in database manipulation species.");
            System.out.println("Enter 1 to add city name in the database");
            System.out.println("Enter 2 to read values from the database.");
            System.out.println("Enter 3 to update values in database.");
            System.out.println("Enter 4 to delete the values from the database.");


    }}
}