/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1747361;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Shivangi Shah
 */
public class MyActionListener implements ActionListener {

    JFrame frame;

    JButton showtable;
    JButton sortPoints;
    JButton sortWins;
    JButton randomRace;
    JButton probablityWin;
    JButton searchButton;
    JButton sortDate;
    JTextField searchRace;
    Formula1ChampionshipManager F1D;
    Race r;

    MyActionListener(JFrame f, JButton table, JButton sortPointsButton, JButton sortWinsButton, JButton addrandomRace, JButton probablityWins,
            JButton search, JButton sortDates, JTextField searchTextField, Formula1ChampionshipManager f1d)//,Race race)
    {
        frame = f;
        showtable = table;
        sortPoints = sortPointsButton;
        sortWins = sortWinsButton;
        randomRace = addrandomRace;
        probablityWin = probablityWins;
        sortDate = sortDates;
        searchButton = search;
        searchRace = searchTextField;
        F1D = f1d;
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == showtable) {
            F1D.displayTable(F1D.Formula1D);
            //frame.getContentPane().setBackground(Color.white);
        } else if (a.getSource() == sortPoints) {
            F1D.sortPoints(F1D.Formula1D);
        } else if (a.getSource() == sortWins) {
            F1D.sortWins(F1D.Formula1D);
        } else if (a.getSource() == randomRace) {
            F1D.randomRace(F1D.race);
        } else if (a.getSource() == probablityWin) {
            F1D.randomProbablity(F1D.race);
        } else if (a.getSource() == searchButton) {
            String userSearch = searchRace.getText().trim();
            F1D.search(F1D.race, userSearch);
        } else if (a.getSource() == sortDate) {
            F1D.dateSort(F1D.race);
        }
    }

}
