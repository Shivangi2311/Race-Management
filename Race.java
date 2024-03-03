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
public class Race {
    String driverTeam;
    String driverName;
    String raceDate;
    String t1; //
    String t2;
    String t3;
    String t4;
    String t5;
    String t6;
    String t7;
    String t8;
    String t9;
    String t10;
    String t [] = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10};
    F1Driver Formula1D;
 

    

    public Race(String raceDate, String t1, String t2, String t3, String t4, String t5, String t6, String t7, String t8, String t9, String t10) {
        setRaceDate(raceDate);
        setT1(t1);
        setT2(t2);
        setT3(t3);
        setT4(t4);
        setT5(t5);
        setT6(t6);
        setT7(t7);
        setT8(t8);
        setT9(t9);
        setT10(t10);

    }
    
public Race(){

}

    
    public String getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public String getT5() {
        return t5;
    }

    public void setT5(String t5) {
        this.t5 = t5;
    }

    public String getT6() {
        return t6;
    }

    public void setT6(String t6) {
        this.t6 = t6;
    }

    public String getT7() {
        return t7;
    }

    public void setT7(String t7) {
        this.t7 = t7;
    }

    public String getT8() {
        return t8;
    }

    public void setT8(String t8) {
        this.t8 = t8;
    }

    public String getT9() {
        return t9;
    }

    public void setT9(String t9) {
        this.t9 = t9;
    }

    public String getT10() {
        return t10;
    }

    public void setT10(String t10) {
        this.t10 = t10;
    }
        public String getDriverTeam() {
        return driverTeam;
    }

    public void setDriverTeam(String driverTeam) {
        this.driverTeam = driverTeam;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    
}
