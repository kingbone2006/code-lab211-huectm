/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Country;
import model.EastAsiaCountries;
import java.util.ArrayList;
import management.ManageEastAsiaCountries;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        do {
            System.out.println("                               MENU\n"
                    + "==========================================================================\n"
                    + "1. Input the information of 11 countries "
                    + "in East Asia\n"
                    + "2. Display the information of country you"
                    + "'ve just input\n"
                    + "3. Search the information of country by "
                    + "user-entered name\n"
                    + "4. Display the information of countries sorted name in "
                    + "ascending order  \n"
                    + "5. Exit \n"
                    + "==========================================================================");
            int choice = Validator.getInt("Enter your choice: ", "Enter (1-5)",
                    "Invalid!", 1, 5);
            switch (choice) {
                
                case 1:
                    Country country = new EastAsiaCountries(); 
                    try {
                        country.input();
                        manager.addCountryInfor(country);
                        System.out.println("Add successful!");
                    } catch (Exception ex) {
                        System.out.println("Country code already exists!");
                    }
                    break;
                
                case 2:
                    try {
                    Country countryJustInput = manager.getRecentlyEnteredInformation();
                    manager.displayCountry(countryJustInput);
                } catch (Exception ex) {
                    System.out.println("List is empty!Please enter...");
                }
                break;
               
                case 3:
                    String name = Validator.getString("Enter the name you want to search:", "Invalid!", "^(?!\\s*$).+");
                    try {
                        ManageEastAsiaCountries result = manager.searchCountriesByName(name);
                        result.displayListCountries();
                    } catch (Exception e) {
                        System.out.println("Not found name!");
                    }
                    break;
                
                case 4:
                    try {
                    ManageEastAsiaCountries result = manager.sortByNameCountry();
                    result.displayListCountries();
                } catch (Exception ex) {
                    System.out.println("List is empty!");
                }
                break;
                case 5:
                    return;
            }
        } while (true);
    }
}
