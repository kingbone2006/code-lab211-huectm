package ui;

import model.TextNormalizer;

public class Main {

    public static void main(String[] args) {
        TextNormalizer normalizer = new TextNormalizer();
        try {
            normalizer.readFile("input.txt");
            System.out.println("===== Before normalize =====");
            System.out.println(normalizer.getContent());
            normalizer.normalize();
            System.out.println("===== After normalize =====");
            System.out.println(normalizer.getContent());
            normalizer.writeFile("output.txt");
            System.out.println("Normalized text written to output.txt");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
