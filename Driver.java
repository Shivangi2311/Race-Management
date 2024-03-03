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
public abstract class Driver {

    public  String driverName;
    public String driverLoc;
    public String licenseNb;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverFName) {
        this.driverName = driverFName;
    }

    public String getDriverLoc() {
        return driverLoc;
    }

    public void setDriverLoc(String driverLoc) {
        this.driverLoc = driverLoc;
    }

    public String getLicenseNb() {
        return licenseNb;
    }

    public void setLicenseNb(String licenseNb) {
        this.licenseNb = licenseNb;
    }

}



