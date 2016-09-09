package EmployeeStats;

import java.awt.*;
import javax.swing.*;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	<b>Splash</b>
*  File:	Splash.java
* <pre>
*  Description:	Splash screen that is displayeed during the run of the application
*  @author:	Aigerim Shintemirova
*  Environment:	PC, Windows 8, jdk1.7, NetBeans 8.0
*  Date:	4/23/2014
*  @version	1.0
*  @see       	javax.swing.*
*  @see         java.awt.*
* </pre>
*  History Log:	Created on April 1, 2014, 1:12:19 AM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Splash extends JWindow
{
    private int duration;
    
    public Splash(int dur)
    {
        duration = dur;
    }
    
    public void showSplash()
    {
        JPanel content = (JPanel)getContentPane();
        int width = 300;
        int height = 245;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x, y, width, height);
        
        //Build the splash screen
        
        
        JLabel label = new JLabel(new ImageIcon("src/EmployeeStats/fish.jpg"));
        JLabel copyrt = new JLabel ("Employees Pay Statistics, Aigerim Shintemirova", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color border = new Color(50, 20, 20, 55);
        content.setBorder(BorderFactory.createLineBorder(border, 10));
        
        //Display it
        setVisible(true);
        
        try
        {
            Thread.sleep(duration);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        setVisible(false);
    }
}