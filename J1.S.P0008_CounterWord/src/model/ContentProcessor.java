package model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import validate.Validator;

public class ContentProcessor {

    private String input;

    public ContentProcessor() {
    }

    public ContentProcessor(String input) throws Exception {
        setInput(input);
    }

    public String getInput() {
        return input;
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

    public void input() throws Exception {
        String content = Validator.getString(
                "Enter your content: ",
                "Must be can not empty!",
                "^(?!\\s*$).+");
        setInput(content);
    }

    public Map<String, Integer> wordCount() {
        Map<String, Integer> wordCounter = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, wordCounter.get(token) + 1);
            }
        }
        return wordCounter;
    }

    public Map<Character, Integer> charCount() {
        Map<Character, Integer> charCounter = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, charCounter.get(ch) + 1);
            }
        }
        return charCounter;
    }
}
