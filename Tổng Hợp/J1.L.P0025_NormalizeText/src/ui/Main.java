package ui;

import model.TextNormalizer;

/** Điểm vào chương trình — chỉ gọi TextNormalizer. */
public class Main {

    public static void main(String[] args) {
        TextNormalizer normalizer = new TextNormalizer();
        try {
            normalizer.run("input.txt", "output.txt");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
