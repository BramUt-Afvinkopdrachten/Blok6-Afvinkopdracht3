import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class Opdracht1 {
    public static void main(String[] args) {
        String path;
        if ((path = selectFie()) != null) {
            try {
                String content = readFile(path);
                checkSyntax(content);
                System.out.println(content);
            } catch (IOException e) {
                System.out.println("Unable to open file.");
            }
        }
    }

    public static void checkSyntax(String content) {
        char expected;
        boolean endReached = true;
        Stack<Character> checkStack = new Stack<>();
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        for (char c: content.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                checkStack.push(c);
            } else if (c == ')' || c == ']' || c == '}'){
                if (!(checkStack.pop() == (expected = brackets.get(c)))) {
                    System.out.println("Syntax incorrect. " + expected + " expected.");
                    endReached = false;
                    break;
                }
            }
        }
        if (endReached && !checkStack.empty()){
            System.out.println(checkStack.pop() + " is never closed.");
        }
    }

    public static String readFile(String filepath) throws IOException {
        String line;
        StringBuilder content = new StringBuilder();
        BufferedReader inFile = new BufferedReader(new FileReader(filepath));
        while ((line = inFile.readLine()) != null) {
            content.append(line.strip());
        }
        return content.toString();
    }

    public static String selectFie() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }
}
