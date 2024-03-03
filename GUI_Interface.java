/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1747361;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Shivangi shah
 */

 class MyWindowListener extends WindowAdapter{
    
     @Override
     public void windowClosing(WindowEvent e)
    {
        System.out.println("GUI has been closed.");
        System.exit(0);
    }
}




public class GUI_Interface {
    
    JFrame frame;
    JPanel jP = new JPanel();
    Container c;

    GUI_Interface(Formula1ChampionshipManager F1D)
    {
        frame = new JFrame("F1 race GUI");
        JButton F1Table = new JButton("F1 race Table");
        JButton sortPoints = new JButton("Sort by points scored, ascending order");
        JButton sortWins = new JButton("Sort by wins, descending order");
        JButton addRandomRace = new JButton("Generate a random race");
        JButton probablityWin = new JButton("Probablity of winning");
        JButton sortDate = new JButton("Sort by date,ascending order");
        JButton searchButton = new JButton("Search");
        JTextField searchbox = new JTextField(30);
        //jP.setBackground(Color.white);

        c = frame.getContentPane();
        c.setLayout(new FlowLayout());
        
        c.add(F1Table);
        c.add(sortPoints);
        c.add(sortWins);
        c.add(addRandomRace);
        c.add(probablityWin);
        c.add(sortDate);
        c.add(searchButton);
        c.add(searchbox);

        MyActionListener eventListener = new MyActionListener(frame, F1Table, sortPoints, sortWins, addRandomRace, probablityWin, searchButton,
                sortDate,searchbox ,F1D);
        F1Table.addActionListener(eventListener);
        sortPoints.addActionListener(eventListener);
        sortWins.addActionListener(eventListener);
        addRandomRace.addActionListener(eventListener);
        probablityWin.addActionListener(eventListener);
        sortDate.addActionListener(eventListener);
        searchButton.addActionListener(eventListener);
        searchbox.addActionListener(eventListener);

        frame.setSize(450,400);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.white);
        frame.addWindowListener(new MyWindowListener());
    }

    
}

