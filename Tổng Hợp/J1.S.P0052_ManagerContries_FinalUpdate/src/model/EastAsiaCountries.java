/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import utils.Validator;

public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName, double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        if (countryTerrain == null || !countryTerrain.matches("([A-Za-z]+\\s?)+")) {
            throw new IllegalArgumentException("Invalid Country Terrain. It must contain only letters and spaces.");
        }
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.1f%-25s\n", super.getCountryCode(),
                super.getCountryName(), super.totalArea, getCountryTerrain());
    }

    @Override
    public void input() throws Exception {
        super.input();
        this.setCountryTerrain(Validator.getString("Enter terrain of country:\n",
                "Invalid", "([A-Za-z]+\\s?)+"));
    }
}
