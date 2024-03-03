
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1747361;

/**
 *
 * @author Shivangi Shah
 */

import java.util.ArrayList;

interface ChampionshipManager {

    void deleteDriver(ArrayList<F1Driver> deleteDriver);
    void addRaceStatistic(ArrayList<F1Driver> driverStatsAdd);
    void displayDriver(ArrayList<F1Driver> viewDriver);
    void viewStatistics(ArrayList<F1Driver> allDriverStats);
}
