package model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import validate.Validator;

public class ContentProcessor {

    private String input;

    public ContentProcessor() throws Exception {
        setInput(input);
    }

    public void setInput(String input) throws Exception {
        if (input == null) {
            throw new Exception("Can't be null");
        }
        if (input.trim().isEmpty()) {
            throw new Exception("Input can't be empty");
        }
        this.input = input;
    }

    public Map wordCount() throws Exception {
        Map<String, Integer> wordCounter = new LinkedHashMap<>();
        StringTokenizer Tokenstr = new StringTokenizer(input);
        while (Tokenstr.hasMoreTokens()) {
            String tokens = Tokenstr.nextToken();
            if (!wordCounter.containsKey(tokens)) {
                wordCounter.put(tokens, 1);
            } else {
                wordCounter.put(tokens, ((int) wordCounter.get(tokens) + 1));
            }
        }
        return wordCounter;
    }

    public Map charCount() {
        Map<Character, Integer> charCounter = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch) + 1));
            }
        }
        return charCounter;
    }

    public void inputstr() throws Exception {
        this.input = Validator.getString("Enter your content: ", "Must be can not empty!", "^(?!\\s*$).+");
    }
}
