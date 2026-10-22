package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextNormalizer {

    private String content;

    public TextNormalizer() {
    }

    public TextNormalizer(String content) {
        setContent(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
        this.content = content;
    }

    public void readFile(String path) throws IOException {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be empty");
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(line.trim());
            }
        }
        setContent(sb.toString());
    }

    public void writeFile(String path) throws IOException {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be empty");
        }
        if (content == null) {
            throw new IllegalStateException("No content to write");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(content);
        }
    }

    public String normalize() {
        if (content == null) {
            throw new IllegalStateException("Content is null");
        }
        String text = content.trim().toLowerCase();
        // collapse whitespace
        text = text.replaceAll("\\s+", " ");
        // no space before , . :
        text = text.replaceAll("\\s+([,.:])", "$1");
        // one space after , . :
        text = text.replaceAll("([,.:])(\\S)", "$1 $2");
        text = text.replaceAll("([,.:])\\s+", "$1 ");
        // quotes: no spaces just inside quotes
        text = text.replaceAll("\"\\s+", "\"");
        text = text.replaceAll("\\s+\"", "\"");
        // uppercase first character of document
        if (!text.isEmpty()) {
            text = Character.toUpperCase(text.charAt(0)) + text.substring(1);
        }
        // uppercase first char after dot
        StringBuilder sb = new StringBuilder();
        boolean upperNext = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (upperNext && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                upperNext = false;
            } else {
                sb.append(c);
            }
            if (c == '.') {
                upperNext = true;
            }
        }
        text = sb.toString().trim();
        // must end with dot
        if (!text.endsWith(".")) {
            text = text + ".";
        }
        setContent(text);
        return content;
    }
}
