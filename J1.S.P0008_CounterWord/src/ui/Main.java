package ui;

import model.ContentProcessor;

public class Main {

    public static void main(String args[]) throws Exception {
        ContentProcessor process = new ContentProcessor();
        process.input();
        System.out.println(process.wordCount());
        System.out.println(process.charCount());
    }
}
