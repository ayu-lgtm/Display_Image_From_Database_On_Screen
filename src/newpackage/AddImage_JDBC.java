/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayush Rastogi
 */
public class AddImage_JDBC {
    public static void main(String[] args) throws IOException {
        try {
            Connection c=ConnectionProvider.getConnection();
            String q = "insert into image(pic) values(?)";
            
            PreparedStatement pstmt=c.prepareStatement(q);
            
            JFileChooser jfc =new JFileChooser();
            
            jfc.showOpenDialog(null);
            
            File file = jfc.getSelectedFile();
            
            FileInputStream fis = new FileInputStream(file);
            
            pstmt.setBinaryStream(1,fis,fis.available());
            
            pstmt.executeUpdate();
            
            //print gui form
            JOptionPane.showMessageDialog(null,"success");  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
} 
