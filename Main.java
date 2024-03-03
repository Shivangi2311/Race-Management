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
        
import java.io.IOException;
import java.util.Scanner;
import static w1747361.Formula1ChampionshipManager.addDriver;
import static w1747361.Formula1ChampionshipManager.allDriverStats;
import static w1747361.Formula1ChampionshipManager.changeDriver;
import static w1747361.Formula1ChampionshipManager.deleteDriver;
import static w1747361.Formula1ChampionshipManager.displayMenu;
import static w1747361.Formula1ChampionshipManager.driverStats;
import static w1747361.Formula1ChampionshipManager.driverStatsAdd;
import static w1747361.Formula1ChampionshipManager.load;
import static w1747361.Formula1ChampionshipManager.race;
import static w1747361.Formula1ChampionshipManager.store;
import static w1747361.Formula1ChampionshipManager.viewDriver;
        

//main method for the whole project, it contains the main method the user can choose from
    public class Main {public static void main(String[] args) throws IOException{
        Formula1ChampionshipManager Formula1D = new Formula1ChampionshipManager();
        Scanner input = new Scanner(System.in);
        
        char choice;

        do {

            displayMenu();
            System.out.println("enter a choice (qQ) to exit");
            choice = input.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'A':
                    System.out.println("you chose to add driver");
                    addDriver();
                    break;
                case 'V':
                    System.out.println("you chose to display all drivers and their teams");
                    viewDriver();
                    break;
                case 'D':
                    System.out.println("you chose to remove driver");
                    deleteDriver();
                    break;
                case 'C':
                    System.out.println("you chose to change driver");
                    changeDriver();
                    break;
                case 'T':
                    System.out.println("you chose to display driver statistic");
                    driverStats();
                    break;
                case 'O':
                    System.out.println("you chose to display all driver statistic");
                    allDriverStats();
                    break;
                case 'F':
                    driverStatsAdd();
                    break;
                case 'R':
                    System.out.println("you chose to add race");
                    race();
                    break;
                case 'S':
                    System.out.println("you chose to store program data in to file");
                    store();
                    break;
                case 'L':
                    System.out.println("you chose to load program data from file");
                    load();
                    break;
                case 'G':
                    System.out.println("you chose to use GUI");
                    GUI_Interface GUI = new GUI_Interface(Formula1D);
                    break;
                case 'Q':
                    System.out.println("Thanks for using our system");
                    break;
                default:
                    System.out.println("enter a valid option");

            }

        } while (choice != 'Q');

    }
    }



