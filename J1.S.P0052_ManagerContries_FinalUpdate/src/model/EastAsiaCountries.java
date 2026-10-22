package model;

import utils.Validator;

public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName,
            double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        setCountryTerrain(countryTerrain);
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        if (countryTerrain == null || countryTerrain.trim().isEmpty()
                || !countryTerrain.matches("([A-Za-z]+\\s?)+")) {
            throw new IllegalArgumentException(
                    "Invalid country terrain. It cannot be empty and must contain only letters and spaces.");
        }
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.1f%-25s\n",
                super.getCountryCode(),
                super.getCountryName(),
                super.getTotalArea(),
                getCountryTerrain());
    }

    @Override
    public void input() throws Exception {
        super.input();
        setCountryTerrain(Validator.getString("Enter terrain of country:\n",
                "Invalid", "([A-Za-z]+\\s?)+"));
    }
}
