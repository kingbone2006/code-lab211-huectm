package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysisString {

    private String input;

    public AnalysisString() {
    }

    public AnalysisString(String input) {
        setInput(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        this.input = input;
    }

    public HashMap<String, List<Integer>> getNumber(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<Integer> all = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> square = new ArrayList<>();

        Matcher matcher = Pattern.compile("\\d+").matcher(input);
        while (matcher.find()) {
            int n = Integer.parseInt(matcher.group());
            all.add(n);
            if (n % 2 == 0) {
                even.add(n);
            } else {
                odd.add(n);
            }
            int root = (int) Math.sqrt(n);
            if (root * root == n) {
                square.add(n);
            }
        }
        map.put("Perfect Square Numbers", square);
        map.put("Odd Numbers", odd);
        map.put("Even Numbers", even);
        map.put("All Numbers", all);
        return map;
    }

    public HashMap<String, StringBuilder> getCharacter(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        HashMap<String, StringBuilder> map = new HashMap<>();
        StringBuilder all = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();
        StringBuilder special = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                continue;
            }
            all.append(c);
            if (Character.isUpperCase(c)) {
                upper.append(c);
            } else if (Character.isLowerCase(c)) {
                lower.append(c);
            } else {
                special.append(c);
            }
        }
        map.put("Uppercase Characters", upper);
        map.put("Lowercase Characters", lower);
        map.put("Special Characters", special);
        map.put("All Characters", all);
        return map;
    }

    public void printResult() {
        HashMap<String, List<Integer>> numbers = getNumber(input);
        HashMap<String, StringBuilder> characters = getCharacter(input);
        System.out.println("-----Result Analysis------");
        System.out.println("Perfect Square Numbers: " + numbers.get("Perfect Square Numbers"));
        System.out.println("Odd Numbers: " + numbers.get("Odd Numbers"));
        System.out.println("Even Numbers: " + numbers.get("Even Numbers"));
        System.out.println("All Numbers: " + numbers.get("All Numbers"));
        System.out.println("Uppercase Characters: " + characters.get("Uppercase Characters"));
        System.out.println("Lowercase Characters: " + characters.get("Lowercase Characters"));
        System.out.println("Special Characters: " + characters.get("Special Characters"));
        System.out.println("All Characters: " + characters.get("All Characters"));
    }
}
