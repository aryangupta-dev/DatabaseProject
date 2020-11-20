/*   Created by IntelliJ IDEA.
 *   Author: Aryan gupta (ag2602)
 *   Date: 11/20/2020
 *   Time: 12:25 PM
 *   File: DatabaseConnection.java
 */

package Connetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //url of the database.
    //name of the admin of the database.
    //password of the admin of the database.

    public static final String URL="jdbc:mysql://localhost:3306/Transport";
    public static final String USERNAME="root";
    public static final String PASSWORD="";
    public static Connection connection=null;

        public void connectToDatabase( ){
        try {
            connection= DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );
        } catch (SQLException throwables) {
            System.out.println("Cannot connect to the database ,"+"Please check your credentials of database");
        }finally {
            printStatus();
        }}


    private void printStatus() {
        System.out.println(connection==null ?"Database is inactive ":"Database is active.");
    }

    public static Connection getConnection() {
        return connection;
    }
}