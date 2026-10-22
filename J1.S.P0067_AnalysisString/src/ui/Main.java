package ui;

import model.AnalysisString;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        System.out.println("===== Analysis String program =====");
        String input = Validator.getString("Input String: ", "Input cannot be empty!", "^.+$");
        AnalysisString analysis = new AnalysisString(input);
        analysis.printResult();
    }
}
