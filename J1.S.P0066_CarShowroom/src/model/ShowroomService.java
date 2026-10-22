package model;

import java.util.List;

public class ShowroomService {

    private final List<Car> cars;

    public ShowroomService(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("Showroom cannot be empty");
        }
        this.cars = cars;
    }

    public String checkSell(CarRequest request) {
        Car found = null;
        for (Car c : cars) {
            if (c.getName().equalsIgnoreCase(request.getName())) {
                found = c;
                break;
            }
        }
        if (found == null) {
            return "Car break";
        }
        boolean colorOk = false;
        for (String col : found.getColors()) {
            if (col.equalsIgnoreCase(request.getColor())
                    || ("NO COLOR".equalsIgnoreCase(request.getColor())
                    && col.equalsIgnoreCase("NO COLOR"))) {
                colorOk = true;
                break;
            }
        }
        // also accept "no color" variants
        if (!colorOk) {
            for (String col : found.getColors()) {
                if (normalizeColor(col).equals(normalizeColor(request.getColor()))) {
                    colorOk = true;
                    break;
                }
            }
        }
        if (!colorOk) {
            return "Color Car does not exist";
        }
        boolean priceOk = false;
        int base = request.getPrice();
        // unpainted discount 100: if no color, allowed price may be list price - 100
        for (int p : found.getPrices()) {
            if (base == p) {
                priceOk = true;
                break;
            }
            if (isNoColor(request.getColor()) && base == p - 100) {
                priceOk = true;
                break;
            }
        }
        if (!priceOk) {
            // still allow if price matches after discount logic failure? check list again with tolerance
            return "Price Car does not exist";
        }
        boolean dayOk = false;
        for (String d : found.getSoldDays()) {
            if (d.equalsIgnoreCase(request.getToday())) {
                dayOk = true;
                break;
            }
        }
        if (!dayOk) {
            return "Car can't sell today";
        }
        return null;
    }

    private boolean isNoColor(String color) {
        return "NO COLOR".equalsIgnoreCase(color) || "NOCOLOR".equalsIgnoreCase(color.replace(" ", ""));
    }

    private String normalizeColor(String color) {
        return color == null ? "" : color.trim().toUpperCase().replaceAll("\\s+", " ");
    }
}
