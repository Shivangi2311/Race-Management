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

class F1Driver extends Driver {

    private int firstPos;
    private int secondPos;
    private int thirdPos;
    private int driverPoints;
    private int numRaces; //number of races participated
    public String driverTeam;
    public String date;

    F1Driver() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public F1Driver(String driverName, String driverTeam, int firstPos, int secondPos, int thirdPos, int numRaces) {
        setDriverTeam(driverTeam);
        setDriverName(driverName);
        setFirstPos(firstPos);
        setSecondPos(secondPos);
        setThirdPos(thirdPos);
        setNumRaces(numRaces);

    }

    public int getFirstPos() {
        return firstPos;
    }

    public void setFirstPos(int firstPos) {
        this.firstPos = firstPos;
    }

    public int getSecondPos() {
        return secondPos;
    }

    public void setSecondPos(int secondPos) {
        this.secondPos = secondPos;
    }

    public int getThirdPos() {
        return thirdPos;
    }

    public void setThirdPos(int thirdPos) {
        this.thirdPos = thirdPos;
    }

    public int getDriverPoints() {
        driverPoints = (firstPos * 25) + (secondPos * 18) + (thirdPos * 15);
        return driverPoints;
    }

    public void setDriverPoints(int driverPoints) {
        this.driverPoints = driverPoints;
    }

    public int getNumRaces() {
        return numRaces;
    }

    public void setNumRaces(int numRaces) {
        this.numRaces = numRaces;
    }

    public String getDriverTeam() {
        return driverTeam;
    }

    public void setDriverTeam(String driverTeam) {
        this.driverTeam = driverTeam;
    }

    public int points(int position) {
        if (position < 0 || position > 10) {
            return 0;
        }
//Position the driver achieved. eg. 5th pos = 10 points.
        int[] pointScheme = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        int total = (firstPos * 25) + (secondPos * 18) + (thirdPos * 15);
        return pointScheme[position - 1]; // -1 since arrays are 0-indexed

    }

    };
