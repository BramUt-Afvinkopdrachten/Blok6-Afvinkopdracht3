package Opdracht2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Opdracht2 {
    private HashMap<Character, List<Gene>> chromosomes = new HashMap<>();
    public static void main(String[] args) {

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
}
