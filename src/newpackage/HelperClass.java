/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import javax.swing.ImageIcon;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Ayush Rastogi
 */
public class HelperClass {
    public static ImageIcon getImageIconBy(int id,Connection con) throws IOException{
        ImageIcon icon =null;
        try {
            String q="select pic from image where id=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1,id);
            ResultSet set=pstmt.executeQuery();
            
            if(set.next()){
                Blob b =set.getBlob("pic");
                InputStream is =b.getBinaryStream();
                Image image =ImageIO.read(is);
                icon =new ImageIcon(image);       
            }
                    
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return icon;
        
    }
}
