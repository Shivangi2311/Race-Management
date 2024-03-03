/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shivangi Shah
 */
public class Formula1ChampionshipManager implements ChampionshipManager {

    //creates an arraylist for the F1Driver class
    static ArrayList<F1Driver> Formula1D = new ArrayList<F1Driver>();
    //creates an arraylist for the Race class
    static ArrayList<Race> race = new ArrayList<Race>();
    DefaultTableModel model;
    JTable teamsTable;
    static Scanner input = new Scanner(System.in);

    //This method adds driver to the Formula1D arraylist
    public static void addDriver() {
        String driverName;
        String driverTeam;
        int firstPos = 0;
        int secondPos = 0;
        int thirdPos = 0;
        int numRaces = 0;
        boolean done = false;

        System.out.println("Enter the name of the F1 driver: ");
        driverName = input.next();

        System.out.println("Enter the driver team: ");
        driverTeam = input.next();

        for (int i = 0; i < Formula1D.size(); i++) {
            //This checks if the driver team exists and if it does then it will keep asking for input
            while (done = true) {
                if (Formula1D.get(i).getDriverTeam().equals(driverTeam)) {
                    System.out.println("This team already exsists, add new new team: ");
                    driverTeam = input.next();
                } else {
                    done = false;
                    break;
                }
            }
        }
        F1Driver F1D = new F1Driver(driverName, driverTeam, firstPos, secondPos, thirdPos, numRaces);
        Formula1D.add(F1D);

    }

    //Deletes driver from the arraylist
    public static void deleteDriver() {
        System.out.println("Enter the name of the driver you want to delete: ");
        String dDriver = input.next();
        boolean done = false;
        do {
            for (int i = 0; i < Formula1D.size(); i++) {
                //checks if the driver exists or not 
                if (Formula1D.get(i).getDriverName().equals(dDriver)) {
                    Formula1D.remove(i);
                    System.out.println("This driver and team has been deleted.");
                    done = true;
                    break;
                }
            }
            if (!done) {
                System.out.println("This driver does not exist.Please try again!: ");
                dDriver = input.next();
            }
        } while (done == false);

    }

    //allows the user to view all the driver name and teams in the arraylist
    public static void viewDriver() {
        for (int i = 0; i < Formula1D.size(); i++) {
            System.out.println("Driver Name: " + Formula1D.get(i).getDriverName() + " " + "Driver Team: " + Formula1D.get(i).getDriverTeam());
        }
    }

    //this method lets the user change the name of a driver for a particular team 
    public static void changeDriver() {

        boolean done = false;

        System.out.println("Enter the name of the team where driver needs to be changed: ");
        String nTeam = input.next().toLowerCase();
        //keeps asking for input if the user does not enter the correct name 
        do {
            for (int i = 0; i < Formula1D.size(); i++) {
                if (Formula1D.get(i).getDriverTeam().equals(nTeam)) {
                    System.out.println("Enter the name of the new driver: ");
                    String nDriver = input.next();
                    Formula1D.get(i).setDriverName(nDriver);
                    System.out.println("The new driver for team " + nTeam + " is " + nDriver);
                    done = true;
                    break;
                }
            }
            if (!done) {
                System.out.println("This team does not exist, please try again: ");
                nTeam = input.next();
            }
        } while (done == false);

    }

    //shows diver statistics for a particular driver
    public static void driverStats() {
        boolean done = false;
        System.out.println("Enter the name of the driver to display their stats: ");
        String dName = input.next();
        do {
            for (int i = 0; i < Formula1D.size(); i++) {
                if (Formula1D.get(i).getDriverName().equals(dName)) {
                    System.out.println("Driver name: " + Formula1D.get(i).getDriverName());
                    System.out.println("Driver Team: " + Formula1D.get(i).getDriverTeam());
                    System.out.println("Driver Points: " + Formula1D.get(i).getDriverPoints());
                    System.out.println("Number of races: " + Formula1D.get(i).getNumRaces());
                    System.out.println("Number of 1st Position: " + Formula1D.get(i).getFirstPos());
                    System.out.println("Number of 2nd Position: " + Formula1D.get(i).getSecondPos());
                    System.out.println("Number of 3rd Position: " + Formula1D.get(i).getThirdPos());
                    done = true;
                    System.out.println(" ");
                    System.out.println(" ");
                    break;
                }
            }
            if (!done) {
                System.out.println("This driver does not exist, please try again: ");
                dName = input.next();
            }
        } while (done == false);
    }

    //shows statistics of all drivers, in decending order of driver points
    public static void allDriverStats() {
        Collections.sort(Formula1D, new PointsCompare());
        for (int i = 0; i < Formula1D.size(); i++) {
            System.out.println("Driver name: " + Formula1D.get(i).getDriverName()+ " " + "Driver Team: " + Formula1D.get(i).getDriverTeam()+ " " + "Driver Points: " + Formula1D.get(i).getDriverPoints()+ " " + "Number of races: " + Formula1D.get(i).getNumRaces()+ " " + "Number of 1st Position: " + Formula1D.get(i).getFirstPos()+ " " + "Number of 2nd Position: " + Formula1D.get(i).getSecondPos()+ " " + "Number of 3rd Position: " + Formula1D.get(i).getThirdPos());
            System.out.println(" ");
        }
    }

    //allows user to enter driver statistics manually 
    public static void addDriverStats() {
        int firstPos = 0;
        int secondPos = 0;
        int thirdPos = 0;
        int numRaces = 0;
        int driverPoints = 0;
        String driverName = null;
        String driverTeam = null;

        System.out.println("Add driver statistics");
        System.out.println("Enter the name of the driver you want to add statistics for:");
        driverName = input.next();
        boolean done = false;
        for (int i = 0; i < Formula1D.size(); i++) {
            //checks if the driver name exists 
            if (Formula1D.get(i).getDriverName().equals(driverName)) {
                System.out.println("Enter the number of times this driver came first: ");
                firstPos = input.nextInt();
                Formula1D.get(i).setFirstPos(firstPos);

                System.out.println("Enter the number of times this driver came second: ");
                secondPos = input.nextInt();
                Formula1D.get(i).setSecondPos(secondPos);

                System.out.println("Enter the number of times this driver came third: ");
                thirdPos = input.nextInt();
                Formula1D.get(i).setThirdPos(thirdPos);

                System.out.println("Enter the number of races this driver participated in: ");
                numRaces = input.nextInt();
                Formula1D.get(i).setNumRaces(numRaces);
                //calculate driver points
                driverPoints = 0;
                driverTeam = Formula1D.get(i).getDriverTeam();
                done = true;
            }
        }
        if (!done) {
            System.out.println("This driver does not exist.");
        }
    }

    //menu option to allow user to chose if they wish to add driver stats manually or would they like a random add of stats
    public static void driverStatsAdd() {
        System.out.println("you chose to add driver statistic");
        System.out.println("Press 1 to add driver statistics manually");
        System.out.println("Press 2 to add driver statistics randomly");
        String y = input.next();
        if (y.equals("1")) {
            addDriverStats();
        } else if (y.equals("2")) {
            randomAddDriverStats();
        } else {
            System.out.println("Enter a valid input");
        }
    }

    //allows user to randomly add driver stats
    public static void randomAddDriverStats() {
        int firstPos = 0;
        int secondPos = 0;
        int thirdPos = 0;
        int numRaces = 0;
        int driverPoints = 0;
        String driverName = null;
        String driverTeam = null;

        Random rand = new Random();

        System.out.println("Add driver statistics");
        System.out.println("Enter the name of the driver you want to add statistics for:");
        driverName = input.next();
        boolean done = false;
        for (int i = 0; i < Formula1D.size(); i++) {
            if (Formula1D.get(i).getDriverName().equals(driverName)) {
                //number of times the driver came first 
                //driver 1st position is randomly generated between 1 to 20
                firstPos = rand.nextInt(20);
                Formula1D.get(i).setFirstPos(firstPos);

                //number of times the driver came second
                //driver 2nd position is randomly generated between 1 to 20
                secondPos = rand.nextInt(20);
                Formula1D.get(i).setSecondPos(secondPos);

                //driver 3rd position is randomly generated between 1 to 20
                thirdPos = rand.nextInt(20);
                Formula1D.get(i).setThirdPos(thirdPos);

                //number of races the driver participated in 
                //number of participation is randomly generarted between 1 to 20
                numRaces = rand.nextInt(20);
                Formula1D.get(i).setNumRaces(numRaces);
                //calculate driver points
                driverPoints = 0;
                driverTeam = Formula1D.get(i).getDriverTeam();
                done = true;
            }
        }
        if (!done) {
            System.out.println("This driver does not exist.");
        }

    }

    //this method stores all the information about driver name and driver team in a txt file, driver
    public static void storeData() throws IOException {

        try {
            //this allows user to append to that file 
            FileWriter fw = new FileWriter("driver.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            try ( PrintWriter outToFile = new PrintWriter(bw)) {

                for (int s = 0; s < Formula1D.size(); s++) {

                    String send = Formula1D.get(s).getDriverName();
                    String x = Formula1D.get(s).getDriverTeam();
                    int y = Formula1D.get(s).getFirstPos();
                    int z = Formula1D.get(s).getSecondPos();
                    int a = Formula1D.get(s).getThirdPos();
                    int b = Formula1D.get(s).getNumRaces();
                    int c = Formula1D.get(s).getDriverPoints();

                    outToFile.println(send);
                    outToFile.println(x);
                    outToFile.println(y);
                    outToFile.println(z);
                    outToFile.println(a);
                    outToFile.println(b);
                    outToFile.println(c);

                }
                outToFile.flush();
                fw.close();
                bw.close();
            }

            System.out.println("File has been stored");

        } catch (FileNotFoundException e) {
            System.out.println("Sorry file not found");
        } catch (IOException e) {
            System.out.println("IO Exception caught");
        }
    }

// this method reads all data from the txt file of drivers data
    public static F1Driver loadData() {
        int firstPos = 0;
        int secondPos = 0;
        int thirdPos = 0;
        int numRaces = 0;
        //int driverPoints = 0;
        String driverName = null;
        String driverTeam = null;

        F1Driver F1D = new F1Driver(driverName, driverTeam, firstPos, secondPos, thirdPos, numRaces);
        try ( Scanner fileReader = new Scanner(new BufferedReader(new FileReader("driver.txt")))) {
            int i = 0;

            while (fileReader.hasNext()) {
                Formula1D.add(new F1Driver());
                Formula1D.get(i).setDriverName(fileReader.next());
                Formula1D.get(i).setDriverTeam(fileReader.next());
                Formula1D.get(i).setFirstPos(Integer.parseInt(fileReader.next()));
                Formula1D.get(i).setSecondPos(Integer.parseInt(fileReader.next()));
                Formula1D.get(i).setThirdPos(Integer.parseInt(fileReader.next()));
                Formula1D.get(i).setNumRaces(Integer.parseInt(fileReader.next()));
                Formula1D.get(i).setDriverPoints(Integer.parseInt(fileReader.next()));

                System.out.println("Driver name: " + Formula1D.get(i).getDriverName());
                System.out.println("Driver Team: " + Formula1D.get(i).getDriverTeam());
                System.out.println("Driver Points: " + Formula1D.get(i).getDriverPoints());
                System.out.println("Number of races: " + Formula1D.get(i).getNumRaces());
                System.out.println("Number of 1st Position: " + Formula1D.get(i).getFirstPos());
                System.out.println("Number of 2nd Position: " + Formula1D.get(i).getSecondPos());
                System.out.println("Number of 3rd Position: " + Formula1D.get(i).getThirdPos());
                i += 1;
            }
        } catch (IOException e) {
            System.out.println("Error, Sorry file could not be found");
        }
        return F1D;
    }

    //this stores all the infomation about race in the txt file race
    public static void storeRace() throws IOException {

        try {
            //this lets user append to the exisisting file
            FileWriter fw = new FileWriter("race.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            try ( PrintWriter outToFile = new PrintWriter(bw)) {

                for (int z = 0; z < race.size(); z++) {
                    String send = race.get(z).getRaceDate();
                    String a = race.get(z).getT1();
                    String b = race.get(z).getT2();
                    String c = race.get(z).getT3();
                    String d = race.get(z).getT4();
                    String e = race.get(z).getT5();
                    String f = race.get(z).getT6();
                    String g = race.get(z).getT7();
                    String h = race.get(z).getT8();
                    String i = race.get(z).getT9();
                    String j = race.get(z).getT10();

                    outToFile.println(send);
                    outToFile.println(a);
                    outToFile.println(b);
                    outToFile.println(c);
                    outToFile.println(d);
                    outToFile.println(e);
                    outToFile.println(f);
                    outToFile.println(g);
                    outToFile.println(h);
                    outToFile.println(i);
                    outToFile.println(j);

                }
                outToFile.flush();
                fw.close();
                bw.close();
            }

            System.out.println("File has been stored");

        } catch (FileNotFoundException e) {
            System.out.println("Sorry file not found");
        } catch (IOException e) {
            System.out.println("IO Exception caught");
        }
    }

    //this loads the race txt file
    public static Race loadRace() {
        String raceDate = null;
        String t1 = null;
        String t2 = null;
        String t3 = null;
        String t4 = null;
        String t5 = null;
        String t6 = null;
        String t7 = null;
        String t8 = null;
        String t9 = null;
        String t10 = null;

        Race r = new Race(raceDate, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
        try ( Scanner fileReader = new Scanner(new BufferedReader(new FileReader("race.txt")))) {
            int i = 0;

            while (fileReader.hasNext()) {
                race.add(new Race());

                race.get(i).setRaceDate(fileReader.next());
                race.get(i).setT1(fileReader.next());
                race.get(i).setT2(fileReader.next());
                race.get(i).setT3(fileReader.next());
                race.get(i).setT4(fileReader.next());
                race.get(i).setT5(fileReader.next());
                race.get(i).setT6(fileReader.next());
                race.get(i).setT7(fileReader.next());
                race.get(i).setT8(fileReader.next());
                race.get(i).setT9(fileReader.next());
                race.get(i).setT10(fileReader.next());

                System.out.println("Race Date: " + race.get(i).getRaceDate());
                System.out.println("Team 1: " + race.get(i).getT1());
                System.out.println("Team 2: " + race.get(i).getT2());
                System.out.println("Team 3: " + race.get(i).getT3());
                System.out.println("Team 4: " + race.get(i).getT4());
                System.out.println("Team 5: " + race.get(i).getT5());
                System.out.println("Team 6: " + race.get(i).getT6());
                System.out.println("Team 7: " + race.get(i).getT7());
                System.out.println("Team 8: " + race.get(i).getT8());
                System.out.println("Team 9: " + race.get(i).getT9());
                System.out.println("Team 10: " + race.get(i).getT10());
                i += 1;

            }
        } catch (IOException e) {
            System.out.println("Error, Sorry file could not be found");
        }
        return r;
    }

    //This gives a menu for the user to store either the driver details or the race details 
    public static void store() throws IOException {
        System.out.println("you chose to store data");
        System.out.println("Press 1 to store driver data");
        System.out.println("Press 2 to store race data");
        String y = input.next();
        if (y.equals("1")) {
            storeData();
        } else if (y.equals("2")) {
            storeRace();
        } else {
            System.out.println("Enter a valid input");
        }
    }

    //This gives a menu for the user to load either the driver details or the race details 
    public static void load() {
        System.out.println("you chose to load data");
        System.out.println("Press 1 to load driver data");
        System.out.println("Press 2 to load race data");
        String y = input.next();
        if (y.equals("1")) {
            loadData();
        } else if (y.equals("2")) {
            loadRace();
        } else {
            System.out.println("Enter a valid input");
        }
    }

    //This lets user add a race manually and lets user decide the teams that won in the particular position          
    public static void race() {
        String raceDate;
        System.out.println("Enter the date of the race (in format dd/mm/yyyy): ");
        raceDate = input.next();
        String[] parts = raceDate.split("/");
        if (parts.length != 3) {
            System.out.println("The date is wrong!");
            return;
        }

        String[] t = new String[10];

        for (int i = 0; i < Formula1D.size(); i++) {
            int pos = i + 1;
            System.out.println("Enter the team for position" + " " + pos);
            String name = input.next();
            if (name.equals("-1")) {
                return;
            }//this checks if the team already exists
            for (int j = 0; j < t.length; j++) {
                if (t[j] != null && t[j].equals(name)) {
                    System.out.println("This name has been entered already");
                    return;
                }
            }
            t[i] = name;

//this race only allows user to enter the first 10 positons in the race
            if (i == 0) {
                //if(t[i].size().equals(input)){
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int first = Formula1D.get(i).getFirstPos() + 1;
                    int points = Formula1D.get(i).getDriverPoints() + 25;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setFirstPos(first);
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }

            if (i == 1) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int second = Formula1D.get(i).getSecondPos() + 1;
                    int points = Formula1D.get(i).getDriverPoints() + 18;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setSecondPos(second);
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);
                }
            }

            if (i == 2) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int third = Formula1D.get(i).getThirdPos() + 1;
                    int points = Formula1D.get(i).getDriverPoints() + 15;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setThirdPos(third);
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }
            if (i == 3) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int points = Formula1D.get(i).getDriverPoints() + 12;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }
            if (i == 4) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int points = Formula1D.get(i).getDriverPoints() + 10;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }
            if (i == 5) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int points = Formula1D.get(i).getDriverPoints() + 8;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }
            if (i == 6) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int points = Formula1D.get(i).getDriverPoints() + 6;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }
            if (i == 7) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int points = Formula1D.get(i).getDriverPoints() + 4;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }
            if (i == 8) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int points = Formula1D.get(i).getDriverPoints() + 2;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }

            if (i == 9) {
                if (Formula1D.get(i).getDriverTeam().equals(t[i])) {
                    int points = Formula1D.get(i).getDriverPoints() + 1;
                    int raceNo = Formula1D.get(i).getNumRaces() + 1;
                    Formula1D.get(i).setDriverPoints(points);
                    Formula1D.get(i).setNumRaces(raceNo);

                }
            }

        }
        //add all the race data to the race class
        Race ra = new Race(raceDate, String.valueOf(t[0]), String.valueOf(t[1]), String.valueOf(t[2]), String.valueOf(t[3]), String.valueOf(t[4]), String.valueOf(t[5]), String.valueOf(t[6]), String.valueOf(t[7]), String.valueOf(t[8]), String.valueOf(t[9]));
        race.add(ra);
    }

//this is the display menu that the user can select from 
    public static void displayMenu() {
        System.out.println("A: Add Driver");
        System.out.println("V: View Driver and Team");
        System.out.println("F: Add driver statistics");
        System.out.println("D: Delete driver");
        System.out.println("S: Store program data in to file");
        System.out.println("L: Load program data from file");
        System.out.println("C: Change Driver");
        System.out.println("T: Show statistics of the driver");
        System.out.println("O: Show all driver statistics");
        System.out.println("R: Add races");
        System.out.println("G: Open GUI");
        System.out.println("-----------------------------------------------");
    }

    public String toLowerCase() {
        return null;
    }

    //this method makes the diplay table for the GUI where user can select the buttons to do the particular function
    public void displayTable(ArrayList<F1Driver> F1D) {
        String[] columnNames = {"Driver Name", "Driver Team ", "Points", "Number of race", "1st Position", "2nd Position", "3rd Position"};
        model = new DefaultTableModel(columnNames, 0);
//adds all information in a loop with all the data there is about the drivers
        for (int i = 0; i < F1D.size(); i++) {
            String name = F1D.get(i).getDriverName();
            String team = F1D.get(i).getDriverTeam();
            int points = F1D.get(i).getDriverPoints();
            int race = F1D.get(i).getNumRaces();
            int Pos1 = F1D.get(i).getFirstPos();
            int Pos2 = F1D.get(i).getSecondPos();
            int Pos3 = F1D.get(i).getThirdPos();
            //String date = F1D.get(i).getDate();
            Object[] row = {name, team, points, race, Pos1, Pos2, Pos3};
            model.addRow(row);
        }
//this makes a new JTable 
        teamsTable = new JTable(model);
        teamsTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamsTable);
        panel.add(scrollPane);

        JFrame frame = new JFrame("Table View");
        //Exits the GUI as soon as closed button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamsTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
//Shows a table with all the drivers and their points in ascending order
    public void sortPoints(ArrayList<F1Driver> sortDriverPoints) {
        Collections.sort(sortDriverPoints, new PointCompare());
        Collections.reverse(sortDriverPoints);

        String[] columnNames = {"Driver Name", "Driver Team ", "Points", "Number of race", "1st Position", "2nd Position", "3rd Position"};
        model = new DefaultTableModel(columnNames, 0);
//loops through till all points are covered
        for (int i = 0; i < sortDriverPoints.size(); i++) {
            String name = sortDriverPoints.get(i).getDriverName();
            String team = sortDriverPoints.get(i).getDriverTeam();
            int points = sortDriverPoints.get(i).getDriverPoints();
            int race = sortDriverPoints.get(i).getNumRaces();
            int Pos1 = sortDriverPoints.get(i).getFirstPos();
            int Pos2 = sortDriverPoints.get(i).getSecondPos();
            int Pos3 = sortDriverPoints.get(i).getThirdPos();
            Object[] row = {name, team, points, race, Pos1, Pos2, Pos3};
            model.addRow(row);
        }

        teamsTable = new JTable(model);
        //teamsTable.repaint();
        teamsTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamsTable);
        panel.add(scrollPane);

        JFrame frame = new JFrame("Ascending Sort");
        teamsTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //Shows a table with all the drivers and their points in descending order
    public void sortWins(ArrayList<F1Driver> sortDriverWins) {
        Collections.sort(sortDriverWins, new WinCompare());

        String[] columnNames = {"Driver Name", "Driver Team ", "Points", "Number of race", "1st Position", "2nd Position", "3rd Position"};
        model = new DefaultTableModel(columnNames, 0);

        for (int i = 0; i < sortDriverWins.size(); i++) {
            String name = sortDriverWins.get(i).getDriverName();
            String team = sortDriverWins.get(i).getDriverTeam();
            int points = sortDriverWins.get(i).getDriverPoints();
            int race = sortDriverWins.get(i).getNumRaces();
            int Pos1 = sortDriverWins.get(i).getFirstPos();
            int Pos2 = sortDriverWins.get(i).getSecondPos();
            int Pos3 = sortDriverWins.get(i).getThirdPos();
            Object[] row = {name, team, points, race, Pos1, Pos2, Pos3};
            model.addRow(row);
        }

        teamsTable = new JTable(model);
        //teamsTable.repaint();
        teamsTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamsTable);
        panel.add(scrollPane);

        JFrame frame = new JFrame("Descending Sort");
        teamsTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //Generates a random race 
    public void randomRace(ArrayList<Race> r) {
        Random rand = new Random();
        int day = rand.nextInt(27) + 1;
        int month = rand.nextInt(11) + 1;
        int year = rand.nextInt(122) + 1900;
        String date = String.valueOf(day) + '/' + String.valueOf(month) + '/' + String.valueOf(year);

        List<Integer> solution = new ArrayList<>();
        for (int i = 0; i < Formula1D.size(); i++) {
            solution.add(i);
        }
        //randomises the arraylist
        Collections.shuffle(solution);
        Object[] row = {date, null, null, null, null, null, null, null, null, null, null, null};
        for (int i = 0; i < solution.size(); i++) {
            String t = Formula1D.get(solution.get(i)).getDriverTeam();
            if (i == 0) {
                //sets the points and all other informatio for the driver 
                int first = Formula1D.get(solution.get(i)).getFirstPos() + 1;
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 25;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setFirstPos(first);
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 1) {
                int second = Formula1D.get(solution.get(i)).getSecondPos() + 1;
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 18;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setSecondPos(second);
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 2) {
                int third = Formula1D.get(solution.get(i)).getThirdPos() + 1;
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 15;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setThirdPos(third);
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 3) {
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 12;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 4) {
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 10;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 5) {
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 8;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 6) {
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 6;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 7) {
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 4;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 8) {
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 2;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i == 9) {
                int points = Formula1D.get(solution.get(i)).getDriverPoints() + 1;
                int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                Formula1D.get(solution.get(i)).setDriverPoints(points);
                Formula1D.get(solution.get(i)).setNumRaces(raceNo);
            }
            if (i >= 10) {
                break;
            }

            row[i + 1] = t;
        }
//adds it to the race class
        Race ra = new Race(date, String.valueOf(row[1]), String.valueOf(row[2]), String.valueOf(row[3]), String.valueOf(row[4]), String.valueOf(row[5]), String.valueOf(row[6]), String.valueOf(row[7]), String.valueOf(row[8]), String.valueOf(row[9]), String.valueOf(row[10]));
        race.add(ra);

        //coloumn names for the GUI
        String[] columnNames = {"Date", "Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6", "Team 7", "Team 8", "Team 9", "Team 10"};
        model = new DefaultTableModel(columnNames, 0);

        String raceDate = ra.getRaceDate();
        String team1 = ra.getT1();
        String team2 = ra.getT2();
        String team3 = ra.getT3();
        String team4 = ra.getT4();
        String team5 = ra.getT5();
        String team6 = ra.getT6();
        String team7 = ra.getT7();
        String team8 = ra.getT8();
        String team9 = ra.getT9();
        String team10 = ra.getT10();

        Object[] toAdd = {raceDate, team1, team2, team3, team4, team5, team6, team7, team8, team9, team10};
        model.addRow(toAdd);

        teamsTable = new JTable(model);
        teamsTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamsTable);
        panel.add(scrollPane);
        JFrame frame = new JFrame("Table View");
        teamsTable.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
    
    //generates a random race and decides winner on the basis of a randomly generated number 
    public void randomProbablity(ArrayList<Race> r) {
        Random rand = new Random();
        int day = rand.nextInt(27) + 1;
        int month = rand.nextInt(11) + 1;
        int year = rand.nextInt(122) + 1900;
        //int year = (int)Math.round(Math.random() * (2021-122));
        String date = String.valueOf(day) + '/' + String.valueOf(month) + '/' + String.valueOf(year);
        //stores F1Drivers participating in the championship 
        ArrayList<Integer> solution = new ArrayList<>();

        for (int i = 0; i < Formula1D.size(); i++) {
            solution.add(i);
        }
                Collections.shuffle(solution);
        Object[] row = {date, null, null, null, null, null, null, null, null, null, null, null};
        //this is the 1st row . Displays team names and positions before the race
        for (int i = 0; i < solution.size(); i++) {
            String t = Formula1D.get(solution.get(i)).getDriverTeam();
            if (i >= 10) {
                break;
            }
            //adds team name to the row
            row[i + 1] = t;
        }
        // adds team names to race class 
        Race ra = new Race(date, String.valueOf(row[1]), String.valueOf(row[2]), String.valueOf(row[3]), String.valueOf(row[4]), String.valueOf(row[5]), String.valueOf(row[6]), String.valueOf(row[7]), String.valueOf(row[8]), String.valueOf(row[9]), String.valueOf(row[10]));
        race.add(ra);

        String[] columnNames = {"Date", "Pos 1", "Pos 2", "Pos 3", "Pos 4", "Pos 5", "Pos 6", "Pos 7", "Pos 8", "Pos 9", "Pos 10"};
        model = new DefaultTableModel(columnNames, 0);

        //adds data to the respective coloumn
        Object[] toAdd = {date, ra.t1, ra.t2, ra.t3, ra.t4, ra.t5, ra.t6, ra.t7, ra.t8, ra.t9, ra.t10};
        model.addRow(toAdd);

        String driverName = null;
        String driverTeam = null;
        int firstPos = 0;
        int secondPos = 0;
        int thirdPos = 0;
        int numRaces = 0;
        F1Driver F1D = new F1Driver(driverName, driverTeam, firstPos, secondPos, thirdPos, numRaces);

        String t1 = null;
        int y = rand.nextInt(100) + 1;
        System.out.println(y);
        if (y <= 40) {
            t1 = ra.getT1(); // team 1 will be in position 1 
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        } else if (y > 40 && y <= 70) {
            t1 = ra.getT2(); //team 2 will be in position 1 
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        } else if (y > 70 && y <= 80) {
            t1 = ra.getT3(); // team 3 will be in position 1 
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        } else if (y > 80 && y <= 90) {
            t1 = ra.getT4(); //team 4 will be in position 1
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        } else if (y > 90 && y <= 92) {
            t1 = ra.getT5(); //team 5 will be in position 1
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        } else if (y > 92 && y <= 94) {
            t1 = ra.getT6(); //team 6 will be in position 1
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        } else if (y > 94 && y <= 96) {
            t1 = ra.getT7();  //team 7 will be in position 1
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        } else if (y > 96 && y <= 98) {
            t1 = ra.getT8();    //team 8 will be in position 1
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        } else if (y > 98 && y <= 100) {
            t1 = ra.getT9();  //team 9 will be in position 1
            int first = Formula1D.get(0).getFirstPos() + 1;
            int points = Formula1D.get(0).getDriverPoints() + 25;
            int raceNo = Formula1D.get(0).getNumRaces() + 1;
            Formula1D.get(0).setFirstPos(first);
            Formula1D.get(0).setDriverPoints(points);
            Formula1D.get(0).setNumRaces(raceNo);
        }

        Collections.shuffle(Formula1D);
        for (int i = 0; i < solution.size(); i++) {
            //if teamsomethin wins then dont assign any pos to them
            //otherwise assign position to teams thats been left out
            if (t1 == Formula1D.get(solution.get(i)).getDriverTeam()) {
                //dont assign any values
            } else {
                String t = Formula1D.get(solution.get(i)).getDriverTeam();
                if (i == 1) {
                    int second = Formula1D.get(solution.get(i)).getSecondPos() + 1;
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 18;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setSecondPos(second);
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                if (i == 2) {
                    int third = Formula1D.get(solution.get(i)).getThirdPos() + 1;
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 15;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setThirdPos(third);
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                if (i == 3) {
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 12;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                if (i == 4) {
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 10;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                if (i == 5) {
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 8;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                if (i == 6) {
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 6;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                if (i == 7) {
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 4;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                if (i == 8) {
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 2;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                if (i == 9) {
                    int points = Formula1D.get(solution.get(i)).getDriverPoints() + 1;
                    int raceNo = Formula1D.get(solution.get(i)).getNumRaces() + 1;
                    Formula1D.get(solution.get(i)).setDriverPoints(points);
                    Formula1D.get(solution.get(i)).setNumRaces(raceNo);
                }
                row[i+1] = t;
            }
        }

        String[] endrace = {"End race", t1, String.valueOf(row[2]), String.valueOf(row[3]), String.valueOf(row[4]), String.valueOf(row[5]), String.valueOf(row[6]), String.valueOf(row[7]), String.valueOf(row[8]), String.valueOf(row[9]), String.valueOf(row[10])};
        model.addRow(endrace);

        teamsTable = new JTable(model);
        teamsTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamsTable);
        panel.add(scrollPane);

        JFrame frame = new JFrame("Table View");
        teamsTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    //The date of all the races, either randomly generated or munually entered will be sorted in acsending order of the date 
    public void dateSort(ArrayList<Race> r) {
        Collections.sort(r, new DateCompare());
        String[] columnNames = {"Date", "Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6", "Team 7", "Team 8", "Team 9", "Team 10"};
        model = new DefaultTableModel(columnNames, 0);

        for (int i = 0; i < race.size(); i++) {
            String raceDate = race.get(i).getRaceDate();
            String team1 = race.get(i).getT1();
            String team2 = race.get(i).getT2();
            String team3 = race.get(i).getT3();
            String team4 = race.get(i).getT4();
            String team5 = race.get(i).getT5();
            String team6 = race.get(i).getT6();
            String team7 = race.get(i).getT7();
            String team8 = race.get(i).getT8();
            String team9 = race.get(i).getT9();
            String team10 = race.get(i).getT10();

            Object[] toAdd = {raceDate, team1, team2, team3, team4, team5, team6, team7, team8, team9, team10};
            model.addRow(toAdd);
        }

        teamsTable = new JTable(model);
        teamsTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamsTable);
        panel.add(scrollPane);

        JFrame frame = new JFrame("Ascending Sort of Date");
        teamsTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

//This method lets the user search for all the races that a particular driver took part in      
    public void search(ArrayList<Race> raceSearch, String searchInput) {
          ArrayList<String> teamL = new ArrayList<String>();
    //declaring variables
             String raceDate = null;
                String team1 = null;
                String team2 = null;
                String team3 = null;
                String team4 = null;
                String team5 = null;
                String team6 = null;
                String team7 = null;
                String team8 = null;
                String team9 = null;
                String team10 = null;
        String team = null;
        //find drivers team
        for (int i = 0; i < Formula1D.size(); i++) {
            if(Formula1D.get(i).getDriverName().equals(searchInput)){
                team = Formula1D.get(i).getDriverTeam();
            }
        }
        
        String[] columnNames = {"Date", "Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6", "Team 7", "Team 8", "Team 9", "Team 10"};
        model = new DefaultTableModel(columnNames, 0);

        if (raceSearch.size() == 0) {
            System.out.println("No races played yet");
        } else {
            
            for (int i = 0; i < race.size(); i++) {
                //Getting all team info for race.get(i)
                teamL.add(race.get(i).getT1());
                teamL.add(race.get(i).getT2());
                teamL.add(race.get(i).getT3());
                teamL.add(race.get(i).getT4());
                teamL.add(race.get(i).getT5());
                teamL.add(race.get(i).getT6());
                teamL.add(race.get(i).getT7());
                teamL.add(race.get(i).getT8());
                teamL.add(race.get(i).getT9());
                teamL.add(race.get(i).getT10());
                for (int j = 0; j < teamL.size(); j++) {
                    
                
                
                if (teamL.get(j).equals(team))  { //IF team is found on each race
                
                 raceDate = race.get(i).getRaceDate();
                 team1 = race.get(i).getT1();
                 team2 = race.get(i).getT2();
                 team3 = race.get(i).getT3();
                 team4 = race.get(i).getT4();
                 team5 = race.get(i).getT5();
                 team6 = race.get(i).getT6();
                 team7 = race.get(i).getT7();
                 team8 = race.get(i).getT8();
                 team9 = race.get(i).getT9();
                 team10 = race.get(i).getT10();
                }
                
                }
                //stores object and makes new row 
                Object[] row = {raceDate, team1, team2, team3, team4, team5, team6, team7, team8, team9, team10};
                model.addRow(row);
            }

        }


        teamsTable = new JTable(model);
        teamsTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamsTable);
        panel.add(scrollPane);

        JFrame frame = new JFrame("Search Race");
        teamsTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void deleteDriver(ArrayList<F1Driver> deleteDriver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRaceStatistic(ArrayList<F1Driver> driverStatsAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayDriver(ArrayList<F1Driver> viewDriver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewStatistics(ArrayList<F1Driver> allDriverStats) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    


}


//a class used to compare the points of the drivers to be later reused wherever needed
class PointCompare implements Comparator<F1Driver> {

    public int compare(F1Driver x, F1Driver y) {
        if (y.getDriverPoints() == x.getDriverPoints()) {
            return 0;
        } else if (y.getDriverPoints() > x.getDriverPoints()) {
            return 1;
        } else {
            return -1;
        }
    }

}

//a class used to compare the wins of the drivers to be later reused wherever needed
class WinCompare implements Comparator<F1Driver> {

    public int compare(F1Driver x, F1Driver y) {
        if (y.getFirstPos() == x.getFirstPos()) {
            return 0;
        } else if (y.getFirstPos() > x.getFirstPos()) {
            return 1;
        } else {
            return -1;
        }
    }

}

//a class used to compare the points and incase of a tie the wins of the drivers to decide the position in the leaderboard be later reused wherever needed
class PointsCompare implements Comparator<F1Driver> {

    public int compare(F1Driver x, F1Driver y) {
        if (y.getDriverPoints() == x.getDriverPoints()) {
            if (y.getFirstPos() == x.getFirstPos()) {
                return 0;
            } else if (y.getFirstPos() > x.getFirstPos()) {
                return 1;
            } else {
                return -1;
            }
        } else if (y.getDriverPoints() > x.getDriverPoints()) {
            return 1;
        } else {
            return -1;
        }
    }

}

class DateCompare implements Comparator<Race> {

    @Override
    public int compare(Race x, Race y) {

        int year1 = Integer.parseInt(x.getRaceDate().split("/")[2]);
        int year2 = Integer.parseInt(y.getRaceDate().split("/")[2]);

        int month1 = Integer.parseInt(x.getRaceDate().split("/")[1]);
        int month2 = Integer.parseInt(y.getRaceDate().split("/")[1]);

        int date1 = Integer.parseInt(x.getRaceDate().split("/")[0]);
        int date2 = Integer.parseInt(y.getRaceDate().split("/")[0]);

        if (y.getRaceDate() == x.getRaceDate()) {
            if (y.getRaceDate() == x.getRaceDate()) {
                if (y.getRaceDate() == x.getRaceDate()) {
                    return 0;
                } else if (date1 > date2) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (month1 > month2) {
                return 1;
            } else {
                return -1;
            }
        } else if (year1 > year2) {
            return 1;
        } else {
            return -1;
        }
    }
}
