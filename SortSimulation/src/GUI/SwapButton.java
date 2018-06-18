package GUI;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DuyVien
 */
public class SwapButton implements ActionListener {
    private JButton Button1,Button2;
    private Timer timer,timerp;
    private int xbutton1,xbutton2;
    private int goAhead,stay;
    private int across;
    private ActionListener actp;
    public SwapButton(Timer timerparent,ActionListener actparent ,JButton button1, JButton button2)
    {
        Button1=button1;
        Button2=button2;
        xbutton1=Button1.getX();
        xbutton2=Button2.getX();
        goAhead=0;
        across=0;
        stay=0;
        timerp=timerparent;
        actp=actparent;
    }
    public void Swap(int speed)
    {
        timer = new Timer((int)15/speed,this);

        timer.start();
    }
    public void actionPerformed(ActionEvent e)
    {
        if(GUI.getStop())
        {
            GUI.setStop(false);
            timer.stop();
            timerp.addActionListener(actp);
            return;
        }
        if (stay<30)
            stay++;
        if((stay==30)&&(goAhead<50))
        {
            Button1.setLocation(Button1.getX(), Button1.getY()-1);
            Button2.setLocation(Button2.getX(), Button2.getY()+1);
            goAhead++;
        }
        if (goAhead==50)
        {

            Button1.setLocation(Button1.getX()+1, Button1.getY());
            Button2.setLocation(Button2.getX()-1, Button2.getY());
            
            across++;
        }
        if(across==xbutton2-xbutton1)
        {
                Button1.setLocation(Button1.getX(), Button1.getY()+1);
                Button2.setLocation(Button2.getX(), Button2.getY()-1);
                goAhead++;
        }
        if(goAhead==100)
        {
            timer.stop();
            Point point=Button1.getLocation();
            Button1.setLocation(Button2.getLocation());
            Button2.setLocation(point.getLocation());
            String string1=Button1.getText();
            String string2=Button2.getText();
            Button1.setText(string2);
            Button2.setText(string1);
            timerp.addActionListener(actp);
        }

    }
    public void stop()
    {
        timer.stop();
    }
    
}
