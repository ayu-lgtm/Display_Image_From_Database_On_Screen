/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Ayush Rastogi
 */
public class ConnectionProvider {
    private static Connection con;
    public static Connection getConnection(){
        try{
            if(con==null){

                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/mybank";
                String user = "root";
                String password = "";

                con = DriverManager.getConnection(url, user, password);

            }
            
        }
        catch(ClassNotFoundException | SQLException e){
                System.out.print(e.getMessage());
        }
        return con;
    }
}
