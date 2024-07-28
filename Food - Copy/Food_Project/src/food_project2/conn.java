/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food_project2;

import java.sql.*;
public class conn {
    public static Connection mycon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Print the exception stack trace for debugging purposes
        }
        return con;
    }
}

