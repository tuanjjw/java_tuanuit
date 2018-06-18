/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 *
 * @author DuyVien
 */
public class Screenshot {
    public Screenshot()
    {
    };
    
    public static BufferedImage capturePanel (JDesktopPane argPanel/*, String fileName*/) {
        Rectangle rec = argPanel.getBounds();        
        BufferedImage capture = new BufferedImage(rec.width, rec.height,
                                        BufferedImage.TYPE_INT_ARGB);
        argPanel.paint(capture.getGraphics());
        return capture;
//       try {
//        
//        ImageIO.write(capture, "png", new File(fileName));
//        
//    } catch (IOException ioe) {
//        System.out.println(ioe);
//    } 
}
}
