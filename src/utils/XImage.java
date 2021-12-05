/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author User
 */
public class XImage {

    public static void saveLogo(File file) {
        File dir = new File("logos",file.getName());  //khai báo thư mục logos ngang hàng với src
        // Tạo thư mục nếu chưa tồn tại
        if (!dir.getParentFile().exists()) {
            dir.getParentFile().mkdirs();
        }
        try {
            // Copy vào thư mục logos (đè nếu đã tồn tại)
           Path source = Paths.get(file.getAbsolutePath());
         Path destination = Paths.get(dir.getAbsolutePath());
         Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos",fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    }

    

}
