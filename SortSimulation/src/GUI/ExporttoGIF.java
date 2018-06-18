/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author DuyVien
 */
public class ExporttoGIF implements ActionListener{
    private BufferedImage[] pic;
    private Timer timer;

    
    private AnimatedGifEncoder gif;
    public ExporttoGIF(int Speed)
    {
        gif = new AnimatedGifEncoder();
        timer =new Timer(200/Speed,this);
        timer.start();
        gif.start("simulation.gif");
        gif.setDelay(200/Speed);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        
        //screenshot.capturePanel(GUI.workPlace, getClass().getResource("\\pic\\pic"+Numberofpic+".png").toString());
        addF(Screenshot.capturePanel(GUI.workPlace));
    }

    public void addF(BufferedImage buffer)
    {
        gif.addFrame(buffer);
    }
    public void finish()
    {
        timer.stop();
        gif.finish();
    }
}
