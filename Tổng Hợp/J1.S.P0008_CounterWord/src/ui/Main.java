package ui;

import model.ContentProcessor;

public class Main {

    public static void main(String args[]) throws Exception {
        // Khởi tạo đối tượng (Lúc này màn hình sẽ hiện câu hỏi nhập content)
        ContentProcessor process = new ContentProcessor();
        // In ra kết quả đếm
        System.out.println(process.wordCount());
        System.out.println(process.charCount());
    }
}