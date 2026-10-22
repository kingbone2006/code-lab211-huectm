package management;

import model.Country;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageEastAsiaCountries extends ArrayList<Country> {

    private static final int MAX_COUNTRIES = 11;

    public void addCountryInfor(Country country) throws Exception {
        if (country == null) {
            throw new Exception("Country cannot be null!");
        }
        if (this.size() >= MAX_COUNTRIES) {
            throw new Exception("Maximum " + MAX_COUNTRIES + " countries allowed!");
        }
        String newCode = country.getCountryCode();
        for (Country c : this) {
            if (c.getCountryCode().equalsIgnoreCase(newCode)) {
                throw new Exception("Country code already exists!");
            }
        }
        this.add(country);
    }

    public Country getRecentlyEnteredInformation() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty!");
        }
        return this.get(this.size() - 1);
    }

    public void displayCountry(Country country) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        country.display();
    }

    public void displayListCountries() {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name",
                "Total Area", "Terrain");
        for (int i = 0; i < this.size(); i++) {
            this.get(i).display();
        }
    }

    public ManageEastAsiaCountries searchCountriesByName(String name) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty!");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Search name cannot be empty!");
        }
        ManageEastAsiaCountries listSearch = new ManageEastAsiaCountries();
        String searchKeyword = name.trim().toLowerCase();
        for (int i = 0; i < this.size(); i++) {
            String currentName = this.get(i).getCountryName().toLowerCase();
            if (currentName.contains(searchKeyword)) {
                listSearch.add(this.get(i));
            }
        }
        if (listSearch.isEmpty()) {
            throw new Exception("Not found name!");
        }
        return listSearch;
    }

    public ManageEastAsiaCountries sortByNameCountry() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty!");
        }
        // Sort a copy so original list order (recently entered) is preserved
        ManageEastAsiaCountries listSorted = new ManageEastAsiaCountries();
        listSorted.addAll(this);
        Comparator<Country> byNameAsc = (Country a, Country b)
                -> a.getCountryName().compareToIgnoreCase(b.getCountryName());
        Collections.sort(listSorted, byNameAsc);
        return listSorted;
    }
}
