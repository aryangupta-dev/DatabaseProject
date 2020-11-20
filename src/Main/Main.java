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
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the city name.");
        String name=sc.nextLine();
        System.out.println("Have you visited there.(True/False)");
        boolean traversal=sc.nextBoolean();
        int kilometres=(int)(Math.random()*500+50);
        City inserted=new City(name,traversal,kilometres);
        CityHelper rowInsertion=new CityHelper();
        try {
            rowInsertion.addCityToDatabase(DatabaseConnection.getConnection(),inserted);
        } catch (SQLException throwables) {
            System.err.println(inserted.getName()+"cannot be inserted to the database.");
        }


    }
}